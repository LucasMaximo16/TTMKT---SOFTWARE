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
public class AtualizarContatoDTO {

        private Integer id;

        @NotEmpty(message = "O campo nome é obrigatório")
        private String nome;

        @NotEmpty(message = "O campo telefone é obrigatório")
        private String telefone;

        @NotNull(message = "O campo email é obrigatório")
        private String email;

}
