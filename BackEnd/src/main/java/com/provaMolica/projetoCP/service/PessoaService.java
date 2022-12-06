package com.provaMolica.projetoCP.service;

import java.util.Optional;

import javax.transaction.Transactional;

import com.provaMolica.projetoCP.dto.*;
import com.provaMolica.projetoCP.resource.utils.Util;
import com.provaMolica.projetoCP.service.exceptions.NegocioException;
import com.provaMolica.projetoCP.service.mapper.ContatoDTOMapper;
import com.provaMolica.projetoCP.service.mapper.PessoaDTOMapper;
import com.provaMolica.projetoCP.service.mapper.PessoaDetalheDTOMapper;
import com.provaMolica.projetoCP.service.validacao.PessoaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.provaMolica.projetoCP.domain.Pessoa;
import com.provaMolica.projetoCP.repository.ContatoRepository;
import com.provaMolica.projetoCP.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	ContatoRepository contatoRepository;

	@Autowired
	ContatoService contatoService;
	@Autowired
	PessoaDTOMapper pessoaDTOMapper;

	@Autowired
	ContatoDTOMapper contatoDTOMapper;

	@Autowired
	PessoaDetalheDTOMapper pessoaDetalheDTOMapper;

	public PessoaDetalheDTO buscaPessoaId(Integer id) {
		return pessoaDetalheDTOMapper.entidadeParaDTO(getById(id));
	}
		
	public Page<PessoaDTO> getAllPessoa(String filtro, Pageable pageable) {
		if (filtro == "") {
			filtro = null;
		}
		PageRequest pagination = Util.createPagination(pageable.getPageNumber(), pageable.getPageSize(), null,null, "id");
		Page<Pessoa> page = pessoaRepository.findByAll(filtro, pagination);
		Page<PessoaDTO>  pagePessoa = pessoaDTOMapper.pageEntidadeDTO(page);
		return pagePessoa;
	}

	@Transactional
	public void delete(Integer id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		if (!pessoa.isPresent()) {
			throw new NegocioException("Pessoa não Encontrada com o id: " + id);
		}
		pessoaRepository.deleteById(id);
	}

	@Transactional
	public void alterar(AtualizarPessoaDTO dto, Integer id) {
		PessoaValidator.validarPessoa(dto);
		Pessoa p = getById(id);
		p.setNome(dto.getNome());
		p.setCpf(dto.getCpf());
		p.setDataNacimento(dto.getDataNascimento());
		pessoaRepository.save(p);
		if (!dto.getContatoParaExcluir().isEmpty()) {
			contatoService.excluirContatos(dto.getContatoParaExcluir());
		}
		if (!dto.getContatosCadastrarAtualizar().isEmpty()) {
			contatoService.cadatrarContatos(dto.getContatosCadastrarAtualizar(), p);
		}

	}

	@Transactional
	public Pessoa cadatrarPessoa(CadastroPessoaDTO dto) {
		PessoaValidator.validarPessoa(dto);
		Pessoa p = pessoaDTOMapper.dtoParaentidade(dto);
		pessoaRepository.save(p);
		contatoService.cadatrarContatos(dto.getContatos(), p);
		return p;
	}

	private Pessoa getById(Integer id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		if (!pessoa.isPresent()) {
			throw new NegocioException("Pessoa não Encontrada com o id: " + id);
		}
		return pessoa.get();
	}
}
