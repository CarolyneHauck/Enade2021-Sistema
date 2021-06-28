/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enade.controller;

import enade.dao.ProvaDao;
import enade.model.Prova;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import enade.LoginEntity;

/**
 *
 * @author carolyne.carreira
 */
@Named
@ViewScoped
public class ProvaController implements Serializable {

    Prova prova = new Prova();
    List<Prova> provas = new ArrayList<>();

    private LoginEntity login;

    public ProvaController() {
        provas = ProvaDao.getInstance().buscarTodas();
        prova = new Prova();
        login = new LoginEntity();
    }

    public void gravar(ActionEvent actionEvent) {
        ProvaDao.getInstance().atualizar(prova);
        provas = ProvaDao.getInstance().buscarTodas();
        prova = new Prova();
    }

    public void remover(ActionEvent actionEvent) {
        ProvaDao.getInstance().remover(prova);
        provas = ProvaDao.getInstance().buscarTodas();
        prova = new Prova();
    }

  public String Check() {

      login.getLogin();
      System.out.println(login.getLogin());

      if (login != null)
      {
        return "/index.html";
      }
      else
      {
        return "/indexAluno.xhtml";
      }
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public List<Prova> getProvas() {
        return provas;
    }

    public void setProvas(List<Prova> provas) {
        this.provas = provas;
    }
}