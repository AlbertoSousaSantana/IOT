
package org.acme.getting.started.repository;

import org.acme.getting.started.model.SensorLog;
import javax.enterprise.context.ApplicationScoped;


import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class SensorLogRepository implements PanacheRepository<SensorLog>{
    
}
