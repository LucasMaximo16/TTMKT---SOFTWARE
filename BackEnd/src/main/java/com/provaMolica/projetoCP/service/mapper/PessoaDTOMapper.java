package com.provaMolica.projetoCP.service.mapper;

import com.provaMolica.projetoCP.domain.Pessoa;
import com.provaMolica.projetoCP.dto.CadastroPessoaDTO;
import com.provaMolica.projetoCP.dto.PessoaDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PessoaDTOMapper {
    public Page<PessoaDTO> pageEntidadeDTO(Page<Pessoa> pessoas) {
        return pessoas.map(this::entidadeParaDTO);
    }
    public PessoaDTO entidadeParaDTO(Pessoa pessoa) {
        PessoaDTO pessoaDTO = new PessoaDTO();

        if (pessoa.getId() != null) {
            pessoaDTO.setId(pessoa.getId());
        }
        pessoaDTO.setNome(pessoa.getNome());
        pessoaDTO.setCpf(pessoa.getCpf());
        pessoaDTO.setDataNascimento(pessoa.getDataNacimento());

        return pessoaDTO;
    }
    public Pessoa dtoParaentidade(CadastroPessoaDTO dto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getNome());
        pessoa.setCpf(dto.getCpf());
        pessoa.setDataNacimento(dto.getDataNascimento());
        return pessoa;
    }
}
