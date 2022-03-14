package org.acme.getting.started.resources;
import  org.acme.getting.started.model.Usuario;
import  org.acme.getting.started.repository.UsuarioRepository;
import  io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import  io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(exposed = false)
public interface UsuarioResources  extends PanacheRepositoryResource<UsuarioRepository, Usuario, Long> {
    
}