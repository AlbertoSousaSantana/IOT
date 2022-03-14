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

@Entity
public class Usuario {
    
    @Id
    @GeneratedValue
    @JsonIgnore
    @Column(name = "usuario_id")
    @ConfigProperty(name = "id", defaultValue = "1")
    private Long id;

    @Column(name = "nome", length = 10)
    @ConfigProperty(name = "nome", defaultValue = "Pandora")
    private String nome;


    @Column(name = "login")
    @ConfigProperty(name = "login")
    private String login;

    @Column(name = "password")
    @ConfigProperty(name = "password")
    private String password;
        

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}