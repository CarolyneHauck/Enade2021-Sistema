/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enade;

import java.io.Serializable;

/**
 *
 * @author carolyne.carreira
 */
public class LoginEntity implements Serializable {  

    public static final long serialVersionUIS = 1L;
    
    private String login;
    private String senha;
    private String tipoUsuario;
    private boolean realizouProva;

    public LoginEntity() {
    
    }
    
    public LoginEntity(String login, String senha, String tipoUsuario, boolean realizouProva) {
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.realizouProva = realizouProva; 
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getTipoUsuario(){
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario){
        this.tipoUsuario = tipoUsuario;
    }

    public boolean getRealizouProva(){
        return realizouProva;
    }

    public void setRealizouProva(boolean realizouProva){
        this.realizouProva = realizouProva;
    }
}
