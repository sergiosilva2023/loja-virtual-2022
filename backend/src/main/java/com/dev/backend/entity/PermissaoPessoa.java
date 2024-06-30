package com.dev.backend.entity;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "permissao_pessoa")
@Data
public class PermissaoPessoa implements GrantedAuthority{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idPessoa")
    @JsonIgnore
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "idPermissao")
    private Permissao permissao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;


}