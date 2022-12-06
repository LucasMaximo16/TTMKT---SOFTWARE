package com.provaMolica.projetoCP.resource;

import com.provaMolica.projetoCP.dto.AtualizarPessoaDTO;
import com.provaMolica.projetoCP.dto.ContatoDTO;
import com.provaMolica.projetoCP.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Method;

@RequestMapping(value = "/contato")
@RestController
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> alterarContato(@PathVariable Integer id, @RequestBody @Valid ContatoDTO contatoDTO){
        contatoService.alterar(id,contatoDTO,id);

        return ResponseEntity.noContent().build();
    }
}
