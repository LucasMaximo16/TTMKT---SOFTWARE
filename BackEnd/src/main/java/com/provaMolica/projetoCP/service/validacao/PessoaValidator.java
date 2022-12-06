package com.provaMolica.projetoCP.service.validacao;

import com.provaMolica.projetoCP.dto.AtualizarPessoaDTO;
import com.provaMolica.projetoCP.dto.CadastroPessoaDTO;
import com.provaMolica.projetoCP.service.exceptions.NegocioException;

import java.util.Date;

public class PessoaValidator {
    private static final int[] weightSsn = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
    public static void validarPessoa(CadastroPessoaDTO dto) {
        if (!isValidCPF(dto.getCpf())) {
            throw new NegocioException("O CPF da pessoa é invalido");
        }
        if (dto.getDataNascimento().after(new Date())) {
            throw new NegocioException("A Data de nascimento não pode ser uma data futura");
        }
        if (dto.getContatos().isEmpty()) {
            throw new NegocioException("É obrigatório o cadastro de ao menos um contato");
        }
    }

    public static void validarPessoa(AtualizarPessoaDTO dto) {

        if (!isValidCPF(dto.getCpf())) {
            throw new NegocioException("O CPF da pessoa é invalido");
        }

        if (dto.getDataNascimento().after(new Date())) {
            throw new NegocioException("A Data de nascimento não pode ser uma data futura");
        }
    }

    public static boolean isValidCPF(final String ssn) {
        if ((ssn == null) || (ssn.length() != 11) || ssn.matches(ssn.charAt(0) + "{11}"))
            return false;

        final Integer digit1 = calculate(ssn.substring(0, 9), weightSsn);
        final Integer digit2 = calculate(ssn.substring(0, 9) + digit1, weightSsn);
        return ssn.equals(ssn.substring(0, 9) + digit1.toString() + digit2.toString());
    }

    private static int calculate(final String str, final int[] weight) {
        int sum = 0;
        for (int i = str.length() - 1, digit; i >= 0; i--) {
            digit = Integer.parseInt(str.substring(i, i + 1));
            sum += digit * weight[weight.length - str.length() + i];
        }
        sum = 11 - sum % 11;
        return sum > 9 ? 0 : sum;
    }

}
