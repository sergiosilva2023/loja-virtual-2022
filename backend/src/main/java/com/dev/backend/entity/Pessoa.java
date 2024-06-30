package com.dev.backend.entity;
import java.util.*;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;


@Entity
@Table(name= "pessoa")
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String nome;
    private String nif;
    private String email;
    private String codigoRecuperacaoSenha;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEnvioCodigo;
    private String senha;
    private String morada;
    private String codpostal;
    private String telefone;
    @ManyToOne
    @JoinColumn(name="idCidade")
    private Cidade cidade;

    @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    
    @Setter(value = AccessLevel.NONE)
    private List<PermissaoPessoa> permissaoPessoas;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    public void setPermissaoPessoas(List<PermissaoPessoa> pp){
        for(PermissaoPessoa p:pp){
            p.setPessoa(this);
        }

        this.permissaoPessoas = pp;
    }

}