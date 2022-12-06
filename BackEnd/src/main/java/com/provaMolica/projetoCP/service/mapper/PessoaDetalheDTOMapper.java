package com.provaMolica.projetoCP.service.mapper;

import com.provaMolica.projetoCP.domain.Pessoa;
import com.provaMolica.projetoCP.dto.PessoaDTO;
import com.provaMolica.projetoCP.dto.PessoaDetalheDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class PessoaDetalheDTOMapper {
    @Autowired
    ContatoDTOMapper contatoDTOMapper;

    public PessoaDetalheDTO entidadeParaDTO(Pessoa pessoa) {
        PessoaDetalheDTO dto = new PessoaDetalheDTO();

        if (pessoa.getId() != null) {
            dto.setId(pessoa.getId());
        }
        dto.setNome(pessoa.getNome());
        dto.setCpf(pessoa.getCpf());
        dto.setDataNascimento(pessoa.getDataNacimento());
        dto.setContatoDTOS(contatoDTOMapper.entidadeParaDTOs(pessoa.getContatos()));
        return dto;
    }
}
