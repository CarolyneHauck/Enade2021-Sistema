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
import enade.dao.ResultadoDao;
import enade.model.Resultado;

/**
 *
 * @author carolyne.carreira

@Path("resultado")
public class ResultadoResource {

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todasResultado")
    public List<Resultado> TodosResultados() {
        List<Resultado> resultado = ResultadoDao.getInstance().buscarTodos();
        return resultado;
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getResultado/{codigo}")
    public Resultado GetResultado(@PathParam("codigo") int codigo) {
        return ResultadoDao.getInstance().buscarPorId(codigo);
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String Cadastrar(Resultado resultado) {
        Resultado tq = new Resultado();
        try {
            tq.setValorObtido(resultado.getValorObtido());
            ResultadoDao.getInstance().salvar(tq);
            return "Registro cadastrado com sucesso";
        }catch (Exception e) {
            return "Erro ao cadastrar o registro:" + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String Alterar(Resultado resultado) {
        Resultado tq = new Resultado();
        try {
            tq.setValorObtido(resultado.getValorObtido());
            return ResultadoDao.getInstance().atualizar(tq).toString();
        }catch (Exception e) {
            return "Erro ao atualizar o registro:" + e.getMessage();
        }
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{codigo}")
    public String Excluir(@PathParam("codigo") Integer codigo) {
        try {
            Resultado resultado = new Resultado(codigo);
            ResultadoDao.getInstance().remover(codigo);
            return "Registro excluido com sucesso";
        }catch (Exception e) {
            return "Erro ao excluir o registro:" + e.getMessage();
        }
    }
    
}
 */