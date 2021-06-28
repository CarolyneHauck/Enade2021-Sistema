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
import enade.dao.UsuarioDao;
import enade.model.Usuario;

/**
 *
 * @author carolyne.carreira

@Path("usuario")
public class UsuarioResource {

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosUsuario")
    public List<Usuario> TodosUsuario() {
        List<Usuario> usuario = UsuarioDao.getInstance().buscarTodos();
        return usuario;
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getUsuario/{codigo}")
    public Usuario GetUsuario(@PathParam("codigo") int codigo) {
        return UsuarioDao.getInstance().buscarPorId(codigo);
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String Cadastrar(Usuario usuario) {
        Usuario tq = new Usuario();
        try {
            tq.setNomeUsuario(usuario.getNomeUsuario());
            tq.setEmailUsuario(usuario.getEmailUsuario());
            tq.setSenhaUsuario(usuario.getSenhaUsuario());
            UsuarioDao.getInstance().salvar(tq);
            return "Registro cadastrado com sucesso";
        }catch (Exception e) {
            return "Erro ao cadastrar o registro:" + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String Alterar(Usuario usuario) {
        Usuario tq = new Usuario();
        try {
            tq.setIdUsuario(usuario.getIdUsuario());
            tq.setNomeUsuario(usuario.getNomeUsuario());
            tq.setEmailUsuario(usuario.getEmailUsuario());
            tq.setSenhaUsuario(usuario.getSenhaUsuario());
            return UsuarioDao.getInstance().atualizar(tq).toString();
        }catch (Exception e) {
            return "Erro ao atualizar o registro:" + e.getMessage();
        }
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{codigo}")
    public String Excluir(@PathParam("codigo") Integer codigo) {
        try {
            Usuario usuario = new Usuario(codigo);
            UsuarioDao.getInstance().remover(codigo);
            return "Registro excluido com sucesso";
        }catch (Exception e) {
            return "Erro ao excluir o registro:" + e.getMessage();
        }
    }
}
 */