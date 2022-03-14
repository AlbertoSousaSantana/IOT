package org.acme.getting.started.resources;

import  org.acme.getting.started.model.Sensor;
import  org.acme.getting.started.repository.SensorRepository;
import  io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import  io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(exposed = false)
public interface SensorResources  extends PanacheRepositoryResource<SensorRepository, Sensor, Long> {
    
}