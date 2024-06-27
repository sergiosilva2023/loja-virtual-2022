package com.dev.backend.entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name= "distrito")
@Data
public class Distrito {

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