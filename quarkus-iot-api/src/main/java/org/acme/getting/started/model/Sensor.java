package org.acme.getting.started.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import java.util.Calendar;
@Entity
public class Sensor {
    
    @Id
    @GeneratedValue
    @JsonIgnore
    @Column(name = "sensor_id")
    @ConfigProperty(name = "id", defaultValue = "1")
    private Long id;


    @Column(name = "usuario_id", length = 10)
    @ConfigProperty(name = "usuario")
    private Long usuarioId;

    @Column(name = "nome", length = 10)
    @ConfigProperty(name = "nome", defaultValue = "Pandora")
    private String nome;


    @Column(name = "descricao")
    @ConfigProperty(name = "descricao", defaultValue = "sensor arduino")
    private String descricao;

    @Column(name = "funcao")
    @ConfigProperty(name = "funcao", defaultValue = "colher dados")
    private String funcao; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }



}