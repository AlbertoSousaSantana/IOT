
package org.acme.getting.started.repository;

import org.acme.getting.started.model.Sensor;
import javax.enterprise.context.ApplicationScoped;


import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class SensorRepository implements PanacheRepository<Sensor>{
    
}
