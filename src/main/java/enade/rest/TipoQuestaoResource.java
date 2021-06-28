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
import enade.dao.TipoQuestaoDAO;
import enade.model.TipoQuestao;
/**
 *
 * @author carolyne.carreira
 */
@Path("tipoquestao")
public class TipoQuestaoResource {

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosTipoQuestao")
    public List<TipoQuestao> TodosTipoQuestao() {
        List<TipoQuestao> tipoQuestao = TipoQuestaoDAO.getInstance().buscarTodas();
        return tipoQuestao;
    }

    //OK
    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String Cadastrar(TipoQuestao tipoQuestao) {
                
        TipoQuestao tp = new TipoQuestao();
        try {
            tp.setIdtipoQuestao(tipoQuestao.getIdtipoQuestao());
            tp.setNomeTipoQuestao(tipoQuestao.getNomeTipoQuestao());
            TipoQuestaoDAO.getInstance().persistir(tp);
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro " + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String Alterar(TipoQuestao tipoQuestao) {
        TipoQuestao tp = new TipoQuestao();
        try {
            tp.setIdtipoQuestao(tipoQuestao.getIdtipoQuestao());
            tp.setNomeTipoQuestao(tipoQuestao.getNomeTipoQuestao());
            return TipoQuestaoDAO.getInstance().atualizar(tp).toString();
        } catch (Exception e) {
            return "Erro ao cadastrar um registro " + e.getMessage();
        }
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{codigo}")
    public String Excluir(@PathParam("codigo") int codigo) {
        try {
            TipoQuestao tipoQuestao = new TipoQuestao(codigo);
            TipoQuestaoDAO.getInstance().remover(tipoQuestao);
            return "Registro excluido com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @GET
    public Response ping(){
        return Response.ok("ping").build();
    }
}