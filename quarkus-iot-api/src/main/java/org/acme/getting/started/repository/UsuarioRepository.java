
package org.acme.getting.started.repository;

import org.acme.getting.started.model.Usuario;
import javax.enterprise.context.ApplicationScoped;


import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario>{
    
}
