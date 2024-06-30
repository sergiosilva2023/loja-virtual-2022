package com.dev.backend.entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name= "marca")
@Data
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String nome;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

}
