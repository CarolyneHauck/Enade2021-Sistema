/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enade.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import enade.dao.ProvaDao;
import enade.model.Prova;

/**
 *
 * @author carolyne.carreira


@Path("prova")
public class ProvaResource {

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todasProva")
    public List<Prova> TodasProvas() {
        List<Prova> prova = ProvaDao.getInstance().buscarTodos();
        return prova;
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getProva/{codigo}")
    public Prova GetProva(@PathParam("codigo") int codigo) {
        return ProvaDao.getInstance().buscarPorId(codigo);
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String Cadastrar(Prova prova) {
        Prova tq = new Prova();
        try {
            tq.setDataProva(prova.getDataProva());
            ProvaDao.getInstance().salvar(tq);
            return "Registro cadastrado com sucesso";
        }catch (Exception e) {
            return "Erro ao cadastrar o registro:" + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String Alterar(Prova prova) {
        Prova tq = new Prova();
        try {
            tq.setIdProva(prova.getIdProva());
            tq.setDataProva(prova.getDataProva());
            return ProvaDao.getInstance().atualizar(tq).toString();
        }catch (Exception e) {
            return "Erro ao atualizar o registro:" + e.getMessage();
        }
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{codigo}")
    public String Excluir(@PathParam("codigo") Integer codigo) {
        try {
            Prova prova = new Prova(codigo);
            ProvaDao.getInstance().remover(codigo);
            return "Registro excluido com sucesso";
        }catch (Exception e) {
            return "Erro ao excluir o registro:" + e.getMessage();
        }
    }
    
    
    @GET
    public Response ping(){
        return Response.ok("ping").build();
    }
}
 */