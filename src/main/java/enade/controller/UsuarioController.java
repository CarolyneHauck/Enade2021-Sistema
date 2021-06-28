/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enade.controller;

import enade.dao.UsuarioDao;
import enade.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author carolyne.carreira
 */
@Named
@ViewScoped
public class UsuarioController implements Serializable {

    Usuario usuario = new Usuario();
    List<Usuario> usuarios = new ArrayList<>();

    public UsuarioController() {
        usuarios = UsuarioDao.getInstance().buscarTodas();
        usuario = new Usuario();
    }

    public void gravar(ActionEvent actionEvent) {
        UsuarioDao.getInstance().atualizar(usuario);
        usuarios = UsuarioDao.getInstance().buscarTodas();
        usuario = new Usuario();
    }

    public void remover(ActionEvent actionEvent) {
        UsuarioDao.getInstance().remover(usuario);
        usuarios = UsuarioDao.getInstance().buscarTodas();
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void onRowEdit(RowEditEvent event) {
        Usuario q = (Usuario) event.getObject();
        UsuarioDao.getInstance().atualizar(q);
        usuarios = UsuarioDao.getInstance().buscarTodas();
        usuario = new Usuario();
        FacesMessage msg = new FacesMessage("Editado", q.getIdUsuario().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Usuario> event) {
        FacesMessage msg = new FacesMessage("Cancelado", event.getObject().getIdUsuario().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}