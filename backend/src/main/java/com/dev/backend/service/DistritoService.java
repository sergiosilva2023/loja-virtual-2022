package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.backend.entity.Distrito;
import com.dev.backend.repository.DistritoRepository;

@Service
public class DistritoService {

    @Autowired
    private DistritoRepository distritoRepository;

    public List<Distrito> buscarTodos() {
        return distritoRepository.findAll();
    }

    public Distrito inserir(Distrito distrito) {
        distrito.setDataCriacao(new Date());
        Distrito distritoNovo = distritoRepository.saveAndFlush(distrito);
        return distritoNovo;
    }

    public Distrito alterar(Distrito distrito) {
        distrito.setDataAtualizacao(new Date());
        return distritoRepository.saveAndFlush(distrito);
    }

    public void excluir(Long id) {
        Distrito distrito = distritoRepository.findById(id).get();
        distritoRepository.delete(distrito);
    }
}
