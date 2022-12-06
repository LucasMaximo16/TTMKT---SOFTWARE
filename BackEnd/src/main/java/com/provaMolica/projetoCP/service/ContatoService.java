package com.provaMolica.projetoCP.service;

import com.provaMolica.projetoCP.domain.Contato;
import com.provaMolica.projetoCP.domain.Pessoa;
import com.provaMolica.projetoCP.dto.AtualizarContatoDTO;
import com.provaMolica.projetoCP.dto.AtualizarPessoaDTO;
import com.provaMolica.projetoCP.dto.ContatoDTO;
import com.provaMolica.projetoCP.repository.ContatoRepository;
import com.provaMolica.projetoCP.service.exceptions.NegocioException;
import com.provaMolica.projetoCP.service.mapper.ContatoDTOMapper;
import com.provaMolica.projetoCP.service.validacao.ContatoValidator;
import com.provaMolica.projetoCP.service.validacao.PessoaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

	@Autowired
	ContatoRepository contatoRepository;
	@Autowired
	ContatoDTOMapper contatoDTOMapper;

	@Transactional
	public Contato cadatrarContato(ContatoDTO dto) {
		ContatoValidator.validarContato(dto);
		Contato contato = contatoDTOMapper.dtoParaEntidade(dto);
		contatoRepository.save(contato);
		return contato;
	}


	public ContatoDTO buscaContatoId(Integer id) {
		return contatoDTOMapper.entidadeParaDto(getById(id));
	}

	@Transactional
	public void delete(Integer id) {
		getById(id);
		contatoRepository.deleteById(id);
	}

	@Transactional
	public void alterar(Integer id,ContatoDTO dto, Integer idContato) {
		ContatoValidator.validarContato(dto);
		Contato contato = getById(idContato);
		contato.setNome(dto.getNome());
		contato.setEmail(dto.getEmail());
		contato.setTelefone(dto.getTelefone());
		contatoRepository.save(contato);
	}
	@Transactional
	public void cadatrarContatos(List<ContatoDTO> dtos, Pessoa pessoa) {
		dtos.forEach(x -> {
			ContatoValidator.validarContato(x);
			Contato contato = new Contato();
			if (x.getId() != null) {
				contato = getById(x.getId());
			}
			contato.setPessoa(pessoa);
			contato.setTelefone(x.getTelefone());
			contato.setEmail(x.getEmail());
			contato.setNome(x.getNome());

			contatoRepository.save(contato);
		});
	}

	private void alterarContato (ContatoDTO contatoDTO, Integer id){
		ContatoValidator.validarContato(contatoDTO);
		Contato contato = getById(id);
		contato.setNome(contatoDTO.getNome());
		contato.setEmail(contatoDTO.getEmail());
		contato.setTelefone(contatoDTO.getTelefone());
		contatoRepository.save(contato);
	}

	private Contato getById(Integer id) {
		Optional<Contato> contato = contatoRepository.findById(id);
		if (!contato.isPresent()) {
			throw new NegocioException("Contato não Encontrado com o id: " + id);
		}
		return contato.get();
	}

	@Transactional
	public void excluirContatos(List<ContatoDTO> contatosParaExcluir) {
		contatosParaExcluir.forEach(x -> {
			delete(x.getId());
		});
	}
}
