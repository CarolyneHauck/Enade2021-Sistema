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
import enade.dao.QuestaoDao;
import enade.model.Questao;

/**
 *
 * @author carolyne.carreira

@Path("questao")
public class QuestaoResource {

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todasQuestoes")
    public List<Questao> TodasQuestoes() {
        List<Questao> questao = QuestaoDao.getInstance().buscarTodos();
        return questao;
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getQuestao/{codigo}")
    public Questao GetQuestao(@PathParam("codigo") int codigo) {
        return QuestaoDao.getInstance().buscarPorId(codigo);
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String Cadastrar(Questao questao) {
        Questao tq = new Questao();
        try {
            tq.setDescricaoQuestao(questao.getDescricaoQuestao());
            tq.setAlternativaA(questao.getAlternativaA());
            tq.setAlternativaB(questao.getAlternativaB());
            tq.setAlternativaC(questao.getAlternativaC());
            tq.setAlternativaD(questao.getAlternativaD());
            tq.setAlternativaE(questao.getAlternativaE());
            tq.setQuestaoCorreta(questao.getQuestaoCorreta());
            tq.setEstadoQuestao(questao.getEstadoQuestao());
            QuestaoDao.getInstance().salvar(tq);
            return "Registro cadastrado com sucesso";
        }catch (Exception e) {
            return "Erro ao cadastrar o registro:" + e.getMessage();
        }
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterar")
    public String Alterar(Questao questao) {
        Questao tq = new Questao();
        try {
            tq.setIdQuestao(questao.getIdQuestao());
            tq.setDescricaoQuestao(questao.getDescricaoQuestao());
            tq.setAlternativaA(questao.getAlternativaA());
            tq.setAlternativaB(questao.getAlternativaB());
            tq.setAlternativaC(questao.getAlternativaC());
            tq.setAlternativaD(questao.getAlternativaD());
            tq.setAlternativaE(questao.getAlternativaE());
            tq.setQuestaoCorreta(questao.getQuestaoCorreta());
            tq.setEstadoQuestao(questao.getEstadoQuestao());
            return QuestaoDao.getInstance().atualizar(tq).toString();
        }catch (Exception e) {
            return "Erro ao atualizar o registro:" + e.getMessage();
        }
    }

    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{codigo}")
    public String Excluir(@PathParam("codigo") Integer codigo) {
        try {
            Questao questao = new Questao(codigo);
            QuestaoDao.getInstance().remover(codigo);
            return "Registro excluido com sucesso";
        }catch (Exception e) {
            return "Erro ao excluir o registro:" + e.getMessage();
        }
    }
}

*/