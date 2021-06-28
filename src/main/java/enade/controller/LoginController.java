package enade.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import enade.dao.UsuarioDao;
import enade.model.Usuario;

import enade.dao.TipoUsuarioDao;
import enade.model.TipoUsuario;

import enade.dao.ResultadoDao;
import enade.model.Resultado;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import enade.LoginEntity;

@ManagedBean(name = "LoginController")
@ViewScoped
@SessionScoped
public class LoginController {

  private LoginEntity login;

  private UsuarioDao usuarioDao;
  private Usuario usuario;

  private TipoUsuarioDao tipoUsuarioDao;
  private TipoUsuario tipoUsuario;

  private ResultadoDao resultadoDao;
  private Resultado resultado;

  public LoginController(){
    login = new LoginEntity();

    usuarioDao = new UsuarioDao();
    usuario = new Usuario();

    tipoUsuarioDao = new TipoUsuarioDao();
    tipoUsuario = new TipoUsuario();

    resultadoDao = new ResultadoDao();
    resultado = new Resultado();

  }

  public String logarNoSistema() {

    usuario = usuarioDao.getUsuario(usuario.getNomeUsuario(), usuario.getSenhaUsuario());
    if (usuario == null) {
      usuario = new Usuario();
      FacesContext.getCurrentInstance().addMessage(
         null,
         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário Aluno não encontrado!",
           "Erro no Login!"));
      return null;
    } 
    else 
    { 
      int idUsuario = usuario.getIdUsuario();

      List<Resultado> resultado = resultadoDao.buscarTodas();

      for (Resultado r : resultado)
      {
         Usuario idUsuarioResultado = r.getUsuarioidUsuario();
         int teste = idUsuarioResultado.getIdUsuario();
         System.out.println(teste);

         if (teste == idUsuario)
         {
            System.out.println("AlunoRealizouProva"); 
            login.setRealizouProva(true); 
         }
      };
      
      login.setLogin(usuario.getNomeUsuario()); 
      login.setSenha(usuario.getSenhaUsuario()); 
      login.setTipoUsuario(usuario.getTipoUsuarioidtipoUsuario().toString()); 

      HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
      session.setAttribute("usuario", login);
      
      System.out.println(idUsuario);
      System.out.println(resultado);

      tipoUsuario.setIdtipoUsuario(2);

      if (usuario.getTipoUsuarioidtipoUsuario().toString().contains("2"))
      {
        return "/index.html";
      }
      else if (login.getRealizouProva())
      {
        return "/indexAlunoSemProva.xhtml";
      }
      else
      {
        return "/indexAluno.xhtml";
      }
    }
  }

  public String logout(){
      FacesContext.getCurrentInstance().getExternalContext().invalidateSession(); 
      return "/login.xhtml";
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public LoginEntity getLogin() {
    return login;
  }

  public void setLogin(LoginEntity login) {
    this.login = login;
  }
}