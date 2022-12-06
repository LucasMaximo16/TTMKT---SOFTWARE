package com.provaMolica.projetoCP.service.mapper;

import com.provaMolica.projetoCP.domain.Contato;
import com.provaMolica.projetoCP.domain.Pessoa;
import com.provaMolica.projetoCP.dto.ContatoDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContatoDTOMapper {

    public List<ContatoDTO> entidadeParaDTOs(List<Contato> contatos) {
        return contatos.stream()
                .map(x -> entidadeParaDto(x))
                .collect(Collectors.toList());
    }

    public Page<ContatoDTO> pageEntidadeDTO(Page<Contato> contatos) {
        return contatos.map(this::entidadeParaDto);
    }

    public ContatoDTO entidadeParaDto(Contato contato) {
        ContatoDTO dto = new ContatoDTO();
        dto.setId(contato.getId());
        dto.setNome(contato.getNome());
        dto.setTelefone(contato.getTelefone());
        dto.setEmail(contato.getEmail());

        return dto;
    }
    public Contato entidadeParaDto(ContatoDTO dto, Pessoa pessoa) {
        Contato contato = new Contato();
//        contato.setNome(dto.getNome());
//        contato.setTelefone(dto.getTelefone());
//        contato.setEmail(dto.getEmail());
//        contato.setPessoa(pessoa);

        return  Contato
                .builder()
                .email(dto.getEmail())
                .telefone(dto.getTelefone())
                .nome(dto.getNome())
                .pessoa(pessoa)
                .build();
    }

    public Contato dtoParaEntidade(ContatoDTO dto) {
        return  Contato
                .builder()
                .email(dto.getEmail())
                .telefone(dto.getTelefone())
                .nome(dto.getNome())
                .build();
    }
}
