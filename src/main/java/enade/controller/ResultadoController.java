/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enade.controller;

import enade.dao.ResultadoDao;
import enade.model.Resultado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author carolyne.carreira
 */
@Named
@ViewScoped
public class ResultadoController implements Serializable {

    Resultado resultado = new Resultado();
    List<Resultado> resultados = new ArrayList<>();

    public ResultadoController() {
        resultados = ResultadoDao.getInstance().buscarTodas();
        resultado = new Resultado();
    }

    public void gravar(ActionEvent actionEvent) {
        ResultadoDao.getInstance().atualizar(resultado);
        resultados = ResultadoDao.getInstance().buscarTodas();
        resultado = new Resultado();
    }

    public void remover(ActionEvent actionEvent) {
        ResultadoDao.getInstance().remover(resultado);
        resultados = ResultadoDao.getInstance().buscarTodas();
        resultado = new Resultado();
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }
}