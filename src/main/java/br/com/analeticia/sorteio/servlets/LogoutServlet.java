package br.com.analeticia.sorteio.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet da pagina de logout.
 * 
 * @author Ana Let&iacute;cia Herculano
 *
 */
@WebServlet(value = "/logout")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 2002123882692652852L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Referência para a sessão.
		HttpSession sessao = req.getSession();
		// Remove todos os objetos da sessão e a invalida.
		sessao.invalidate();

		resp.sendRedirect("login");
	}

}