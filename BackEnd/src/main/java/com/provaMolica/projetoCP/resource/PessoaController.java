package com.provaMolica.projetoCP.resource;

import java.net.URI;

import com.provaMolica.projetoCP.domain.Pessoa;
import com.provaMolica.projetoCP.dto.*;
import com.provaMolica.projetoCP.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.provaMolica.projetoCP.service.PessoaService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private ContatoService contatoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<PessoaDTO>> getListaPessoas(@Param("filtro")String filtro, Pageable pageable) {
		return ResponseEntity.ok(pessoaService.getAllPessoa(filtro, pageable));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PessoaDetalheDTO> getpessoaById(@PathVariable Integer id) {
		PessoaDetalheDTO pessoa = pessoaService.buscaPessoaId(id);
		return ResponseEntity.ok().body(pessoa);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> cadastrarPessoa(@RequestBody @Valid CadastroPessoaDTO dto) {
		Pessoa p = pessoaService.cadatrarPessoa(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizarPessoa(@PathVariable Integer id, @RequestBody @Valid AtualizarPessoaDTO dto) {
		pessoaService.alterar(dto, id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}/contato/{idContato}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizarContato(@PathVariable Integer id,@PathVariable Integer idContato, @RequestBody @Valid ContatoDTO dto) {
		contatoService.alterar(id,dto, idContato);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletarPessoa(@PathVariable Integer id) {
		pessoaService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
