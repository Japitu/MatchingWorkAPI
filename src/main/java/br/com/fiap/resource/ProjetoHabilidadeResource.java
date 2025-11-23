package br.com.fiap.resource;

import br.com.fiap.bo.ProjetoHabilidadeBO;
import br.com.fiap.to.ProjetoHabilidadeTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/projeto-habilidade")

public class ProjetoHabilidadeResource {
    private ProjetoHabilidadeBO projetoHabilidadeBO = new ProjetoHabilidadeBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findALl() {
        ArrayList<ProjetoHabilidadeTO> resultado = projetoHabilidadeBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        ProjetoHabilidadeTO resultado = projetoHabilidadeBO.findById(id);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/habilidade/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByHabilidade(@PathParam("id") Long id) {
        ArrayList<ProjetoHabilidadeTO> resultado = projetoHabilidadeBO.findByHabilidade(id);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid ProjetoHabilidadeTO projetoHabilidade) {
        try {
        ProjetoHabilidadeTO resultado = projetoHabilidadeBO.save(projetoHabilidade);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Response.ResponseBuilder response = null;
        if (projetoHabilidadeBO.delete(id)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update (@Valid ProjetoHabilidadeTO projetoHabilidade, @PathParam("id") Long id) {
        try {


        projetoHabilidade.setId(id);
        ProjetoHabilidadeTO resultado = projetoHabilidadeBO.update(projetoHabilidade);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
