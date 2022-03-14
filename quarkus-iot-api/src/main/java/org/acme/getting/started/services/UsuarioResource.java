package org.acme.getting.started.services;

import java.net.URI;
import java.util.EmptyStackException;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import org.acme.getting.started.model.Usuario;
import org.acme.getting.started.repository.UsuarioRepository;
import org.acme.getting.started.resources.UsuarioResources;

@Path("/usuario")
@Tag(name="Usuarios", description="API de Usuarios")
public class UsuarioResource {
    
    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    UsuarioResources pesoaResources;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        operationId = "getUsuarioById",
        summary = "Busca de usuário pelo ID",
        description = "Busca de usuário pelo ID")
    @APIResponse(
      responseCode = "200",
      description = "Usuário encontrado",
      content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = Usuario.class)))
    @APIResponse(
        responseCode = "404",
        description = "Usuário não encontrado",
        content = @Content(mediaType = "application/json"))
    public Response getAnimalById(
        @Parameter(
            description = "Busca usuário pelo ID",
            required = true,
            example = "1",
            schema = @Schema(implementation = Long.class))
        @PathParam("id") Long id){
        return usuarioRepository
                .findByIdOptional(id)
                .map(usuario -> Response.ok(usuario).build())
                .orElse(Response.status(Status.NOT_FOUND).build());
    }


    @POST
    @Transactional
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        operationId = "addUsuario",
        summary = "Cadastra uma novo usuário",
        description = "Cadastra uma novo usuário")
    @APIResponse(
      responseCode = "201",
      description = "Usuário Cadastrado",
      content = @Content(
        mediaType = "application/json"))
    @APIResponse(
        responseCode = "400",
        description = "Cadastro fora das especificações",
        content = @Content(mediaType = "application/json"))
    @APIResponse(
        responseCode = "401",
        description = "Sem autorização",
        content = @Content(mediaType = "application/json"))
    public Response addClient(
        @Parameter(
            description = "Cadastra um novo Usuário",
            required = true,
            schema = @Schema(implementation = Usuario.class))
        Usuario usuario){
            
        usuarioRepository.persist(usuario);

        return usuarioRepository
            .findByIdOptional(usuario.getId())
            .map(pet -> Response.created(URI.create("/usuario/" + pet.getId())).build())
            .orElse(Response.status(Status.BAD_REQUEST).build());
    }


    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        operationId = "getAall",
        summary = "Busca de todos os usuários",
        description = "Busca de todos as usuários")
    @APIResponse(
      responseCode = "200",
      description = "Usuários encontrados.",
      content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = Usuario.class)))
    @APIResponse(
        responseCode = "404",
        description = "Usuários não encontrados.",
        content = @Content(mediaType = "application/json"))
    public Response getAll() throws EmptyStackException{
        if(usuarioRepository.findAll().count() == 0){
            throw new EmptyStackException();
        }

        List<Usuario> usuarios = usuarioRepository.findAll().list();

        return Response.ok(usuarios).build();
    }
}
