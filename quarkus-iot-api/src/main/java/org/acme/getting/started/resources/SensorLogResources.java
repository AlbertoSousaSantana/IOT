package org.acme.getting.started.resources;

import  org.acme.getting.started.model.SensorLog;
import  org.acme.getting.started.repository.SensorLogRepository;
import  io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import  io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(exposed = false)
public interface SensorLogResources  extends PanacheRepositoryResource<SensorLogRepository, SensorLog, Long> {
    
}