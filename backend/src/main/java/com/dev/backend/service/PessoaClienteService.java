package com.dev.backend.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.dto.PessoaClienteRequestDTO;
import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PessoaClienteRepository;

@Service
public class PessoaClienteService {

    @Autowired
    private PessoaClienteRepository pessoaRepository;
    @Autowired
    private PermissaoPessoaService permissaoPessoaService;
    @Autowired
    private EmailService emailService;
   

    public Pessoa registar(PessoaClienteRequestDTO pessoaClienteRequestDTO)
    {
        Pessoa pessoa = new PessoaClienteRequestDTO().converter(pessoaClienteRequestDTO);
        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNova = pessoaRepository.saveAndFlush(pessoa);
        permissaoPessoaService.vincularPessoaPermissaoCliente(pessoaNova);
        
        //emailService.enviarEmailTexto(pessoaNova.getEmail(), "Registo na loja Benipesca.com", "O seu registo foi efetuado com sucesso! Seremos breves no envio da sua chave de registo. Obrigado!");

        Map<String, Object> proprMap = new HashMap<>();
        proprMap.put("nome", pessoaNova.getNome());
        proprMap.put("mensagem", "O seu pedido de registo foi efetuado com sucesso! Seremos breves no envio da sua chave de registo. Obrigado!");

        emailService.enviarEmailTemplate(pessoaNova.getEmail(), "Registo na loja Benipesca.com", proprMap);
        return pessoaNova;
    }

}
