package com.provaMolica.projetoCP.dto;

import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CadastroPessoaDTO {

    private Integer id;

    @NotEmpty(message = "O campo nome é obrigatório")
    private String nome;

    @NotEmpty(message = "O campo cpf é obrigatório")
    private String cpf;

    @NotNull(message = "O campo data de nascimento é obrigatório")
    private Date dataNascimento;

    @NotEmpty(message = "Pelo menos um contato é obrigatório")
    private List<ContatoDTO> contatos = new ArrayList<>();

}
