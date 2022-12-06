package com.provaMolica.projetoCP.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtualizarPessoaDTO {

    private Integer id;

    @NotEmpty(message = "O campo nome é obrigatório")
    private String nome;

    @NotEmpty(message = "O campo cpf é obrigatório")
    private String cpf;

    @NotNull(message = "O campo data de nascimento é obrigatório")
    private Date dataNascimento;

    private List<ContatoDTO> contatosCadastrarAtualizar = new ArrayList<>();
    private List<ContatoDTO> contatoParaExcluir = new ArrayList<>();
}
