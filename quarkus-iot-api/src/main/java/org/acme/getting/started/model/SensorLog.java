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
public class SensorLog {
    
    @Id
    @GeneratedValue
    @JsonIgnore
    @Column(name = "sensorLog_id")
    @ConfigProperty(name = "id", defaultValue = "1")
    private Long id;


    @Column(name = "sensor_id", length = 10)
    @ConfigProperty(name = "sensor")
    private Long sensorId;

    @Column(name = "dados", length = 10)
    @ConfigProperty(name = "dados", defaultValue = "dados")
    private String dados;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }
    
    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    } 



}