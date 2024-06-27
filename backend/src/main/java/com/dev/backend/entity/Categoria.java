package com.dev.backend.entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name= "categoria")
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String nome;
    private String sigla;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

}