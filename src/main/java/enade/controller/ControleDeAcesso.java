/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enade.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.faces.context.FacesContext;

import enade.LoginEntity;

@WebFilter(servletNames = { "Faces Servlet" })
public class ControleDeAcesso implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

                LoginEntity login = (LoginEntity)session.getAttribute("usuario");

		if (((login != null) && login.getTipoUsuario().toString().contains("1") && login.getRealizouProva())
				&& ((req.getRequestURI().endsWith("indexAlunoSemProva.xhtml"))
                                || (req.getRequestURI().endsWith("login.xhtml"))
                                || (req.getRequestURI().endsWith("realizarProva.xhtml"))
                                || (req.getRequestURI().endsWith("resultadoProvas.xhtml"))
                                || (req.getRequestURI().contains("javax.faces.resource/")))) {
			System.out.println("Estou aki-1?");
                        System.out.println(login.getRealizouProva());
			chain.doFilter(request, response);
		}

		else if (((login != null) && login.getTipoUsuario().toString().contains("1"))
				&& ((req.getRequestURI().endsWith("indexAluno.xhtml"))
                                || (req.getRequestURI().endsWith("login.xhtml"))
                                || (req.getRequestURI().endsWith("realizarProvas.xhtml"))
                                || (req.getRequestURI().endsWith("resultadoProvas.xhtml"))
                                || (req.getRequestURI().contains("javax.faces.resource/")))) {
			System.out.println("Estou aki-5?");
			chain.doFilter(request, response);
		}

		else if 
                    (((login != null) && (login.getTipoUsuario().toString().contains("2"))) && ((req.getRequestURI().endsWith("index.xhtml"))
                                || (req.getRequestURI().endsWith("usuarios.xhtml")) 
                                || (req.getRequestURI().endsWith("questoes.xhtml"))
                                || (req.getRequestURI().endsWith("prova.xhtml"))
                                || (req.getRequestURI().endsWith("tipoQuestao.xhtml"))
                                || (req.getRequestURI().endsWith("graficoNotas.xhtml"))
                                || (req.getRequestURI().endsWith("graficoProvasFeitas.xhtml"))
                                || (req.getRequestURI().contains("javax.faces.resource/")))) {
			System.out.println("Estou aki-2?");
			chain.doFilter(request, response);
			
		}

		else if 
                    (login == null) {
			System.out.println("Estou aki-3?");
			chain.doFilter(request, response);
			
		}

                else {
                    System.out.println("Estou aki-4?");
                    FacesContext.getCurrentInstance().getExternalContext().invalidateSession(); 
                    redireciona("/Trabalho3/login.xhtml", response);
                }

	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}

	private void redireciona(String url, ServletResponse response)
			throws IOException {
		HttpServletResponse res = (HttpServletResponse) response;
		res.sendRedirect(url);
	}
}