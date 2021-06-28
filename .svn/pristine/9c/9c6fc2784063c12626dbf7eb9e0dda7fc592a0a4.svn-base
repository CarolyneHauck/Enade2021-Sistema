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
import enade.dao.TipoUsuarioDao;
import enade.model.TipoUsuario;

/**
 *
 * @author carolyne.carreira

@Path("tipousuario")
public class TipoUsuarioResource {

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosTipoUsuario")
    public List<TipoUsuario> TodosTipoUsuario() {
        List<TipoUsuario> tipoUsuario = TipoUsuarioDao.getInstance().buscarTodos();
        return tipoUsuario;
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getTipoUsuario/{codigo}")
    public TipoUsuario GetTipoUsuario(@PathParam("id") int id) {
        return TipoUsuarioDao.getInstance().buscarPorId(id);
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String Cadastrar(TipoUsuario tipoUsuario) {
        TipoUsuario tq = new TipoUsuario();
        try {
            tq.setNomeTipoUsuario(tipoUsuario.getNomeTipoUsuario());
            TipoUsuarioDao.getInstance().salvar(tq);
            return "Registro cadastrado com sucesso";
        }catch (Exception e) {
            return "Erro ao cadastrar o registro:" + e.getMessage();
        }
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{codigo}")
    public String Excluir(@PathParam("codigo") int codigo) {
        try {
            TipoUsuario tipoUsuario = new TipoUsuario(codigo);
            TipoUsuarioDao.getInstance().remover(codigo);
            return "Registro excluido com sucesso";
        }catch (Exception e) {
            return "Erro ao excluir o registro:" + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String Alterar(TipoUsuario tipoUsuario) {
        TipoUsuario tq = new TipoUsuario();
        try {
            tq.setIdtipoUsuario(tipoUsuario.getIdtipoUsuario());
            tq.setNomeTipoUsuario(tipoUsuario.getNomeTipoUsuario());
            return TipoUsuarioDao.getInstance().atualizar(tq).toString();
        }catch (Exception e) {
            return "Erro ao atualizar o registro:" + e.getMessage();
        }
    }
}
 */