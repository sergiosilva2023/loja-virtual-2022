package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Marcas;
import com.dev.backend.repository.MarcasRepository;

@Service
public class MarcasService {

    @Autowired
    private MarcasRepository marcasRepository;

    public List<Marcas> buscarTodos() {
        return marcasRepository.findAll();
    }

    public Marcas inserir(Marcas marcas) {
        marcas.setDataCriacao(new Date(0));
        Marcas marcaNova = marcasRepository.saveAndFlush(marcas);
        return marcaNova;
    }

    public Marcas alterar(Marcas marcas) {
        marcas.setDataAtualizacao(new Date(0));
        return marcasRepository.saveAndFlush(marcas);
    }

    public void excluir(Long id) {
        Marcas marcas = marcasRepository.findById(id).get();
        marcasRepository.delete(marcas);
    }
}