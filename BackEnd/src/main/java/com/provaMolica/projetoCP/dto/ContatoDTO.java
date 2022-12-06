package com.provaMolica.projetoCP.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContatoDTO {

    private Integer id;

    @NotEmpty(message = "O campo nome é obrigatório")
    @NotNull
    private String nome;

    @NotEmpty(message = "O campo telefone é obrigatório")
    @NotNull
    private String telefone;

    @NotEmpty(message = "O campo email é obrigatório")
    @Email(message = "Email inválido")
    private String email;
}
