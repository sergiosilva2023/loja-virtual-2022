package com.dev.backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.Pessoa;
import com.dev.backend.service.PessoaGestaoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/pessoa-gestao")
public class PessoaGestaoController {

    @Autowired
    private PessoaGestaoService pessoaGestaoService;


    @PostMapping("/senha-codigo")
    public String recuperarCodigo(@RequestBody Pessoa pessoa){
        return pessoaGestaoService.solicitarCodigo(pessoa.getEmail());
    }

    @PostMapping("/senha-alterar")
    public String alterarSenha(@RequestBody Pessoa pessoa){
        return pessoaGestaoService.alterarSenha(pessoa);
    }


}
