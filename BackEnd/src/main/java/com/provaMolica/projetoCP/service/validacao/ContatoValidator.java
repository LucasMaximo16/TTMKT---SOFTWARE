package com.provaMolica.projetoCP.service.validacao;

import com.provaMolica.projetoCP.dto.ContatoDTO;
import com.provaMolica.projetoCP.service.exceptions.NegocioException;
import org.apache.commons.validator.routines.EmailValidator;

public class ContatoValidator {
    public static void validarContato(ContatoDTO dto) {

        if ("".equals(dto.getNome())) {
            throw new NegocioException("O nome do contato é obrigatório");
        }
        if ("".equals(dto.getEmail())) {
            throw new NegocioException("O Email do contato é obrigatório");
        }
        if (!EmailValidator.getInstance().isValid(dto.getEmail())) {
            throw new NegocioException("O Email do contato é inválido");
        }
        if ("".equals(dto.getTelefone())) {
            throw new NegocioException("O telefone do contato é obrigatório");
        }
    }

}
