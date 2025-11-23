package br.com.fiap.resource;

import br.com.fiap.bo.UsuarioHabilidadeBO;
import br.com.fiap.to.UsuarioHabilidadeTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/usuario-habilidade")

public class UsuarioHabilidadeResource {
    private UsuarioHabilidadeBO usuarioHabilidadeBO = new UsuarioHabilidadeBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<UsuarioHabilidadeTO> resultado = usuarioHabilidadeBO.findAll();
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
        UsuarioHabilidadeTO resultado = usuarioHabilidadeBO.findById(id);
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
        ArrayList<UsuarioHabilidadeTO> resultado = usuarioHabilidadeBO.findByHabilidade(id);
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
    public Response save(@Valid UsuarioHabilidadeTO usuarioHabilidade) {
        try{
            UsuarioHabilidadeTO resultado = usuarioHabilidadeBO.save(usuarioHabilidade);
            Response.ResponseBuilder response = null;
            if (resultado != null) {
                response = Response.created(null);
            } else {
                response = Response.status(400);
            }
            response.entity(resultado);
            return response.build();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Response.ResponseBuilder response = null;
        if (usuarioHabilidadeBO.delete(id)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid UsuarioHabilidadeTO usuarioHabilidade, @PathParam("id") Long id) {
        try {
        usuarioHabilidade.setId(id);
        UsuarioHabilidadeTO resultado = usuarioHabilidadeBO.update(usuarioHabilidade);
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
