package com.provaMolica.projetoCP.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDetalheDTO extends PessoaDTO {
    private List<ContatoDTO> contatoDTOS = new ArrayList<>();
}
