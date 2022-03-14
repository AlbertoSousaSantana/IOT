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

import org.acme.getting.started.model.Sensor;
import org.acme.getting.started.repository.SensorRepository;
import org.acme.getting.started.resources.SensorResources;

@Path("/sensorLog")
@Tag(name="SensorLog", description="API de Sensor log")
public class SensorLogResource {
    
    @Inject
    SensorRepository sensorLogRepository;

    @Inject
    SensorResources sensorLogResources;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        operationId = "getSensorById",
        summary = "Busca de log do sensor pelo ID do sensor",
        description = "Busca de log sensor pelo ID")
    @APIResponse(
      responseCode = "200",
      description = "sensor encontrado",
      content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = Sensor.class)))
    @APIResponse(
        responseCode = "404",
        description = "Log do Sensor não encontrado",
        content = @Content(mediaType = "application/json"))
    public Response getAnimalById(
        @Parameter(
            description = "Busca log sensor pelo ID",
            required = true,
            example = "1",
            schema = @Schema(implementation = Long.class))
        @PathParam("id") Long id){
        return sensorLogRepository
                .findByIdOptional(id)
                .map(sensor -> Response.ok(sensor).build())
                .orElse(Response.status(Status.NOT_FOUND).build());
    }


    @POST
    @Transactional
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        operationId = "addSensor",
        summary = "Gera um novo log",
        description = "Gera um novo log de sensor")
    @APIResponse(
      responseCode = "201",
      description = "Log Sensor",
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
            description = "Gera um novo log de sensor",
            required = true,
            schema = @Schema(implementation = Sensor.class))
        Sensor sensor){
            
        sensorLogRepository.persist(sensor);

        return sensorLogRepository
            .findByIdOptional(sensor.getId())
            .map(pet -> Response.created(URI.create("/sensorlog/" + pet.getId())).build())
            .orElse(Response.status(Status.BAD_REQUEST).build());
    }


    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        operationId = "getAall",
        summary = "Busca de todos logs de sensores",
        description = "Busca de todos os logs de sensores")
    @APIResponse(
      responseCode = "200",
      description = "Log de sensores encontrados.",
      content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = Sensor.class)))
    @APIResponse(
        responseCode = "404",
        description = "Log de Sensores não encontrados.",
        content = @Content(mediaType = "application/json"))
    public Response getAll() throws EmptyStackException{
        if(sensorLogRepository.findAll().count() == 0){
            throw new EmptyStackException();
        }

        List<Sensor> logs = sensorLogRepository.findAll().list();

        return Response.ok(logs).build();
    }
}
