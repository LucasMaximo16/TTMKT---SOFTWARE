package com.provaMolica.projetoCP.dto;

import com.provaMolica.projetoCP.domain.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PessoaDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
}
