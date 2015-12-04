package br.com.analeticia.sorteio.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet da pagina de login.
 * 
 * @author Ana Let&iacute;cia Herculano
 *
 */
@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -3195979849959630337L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Referência para a sessão.
		HttpSession sessao = req.getSession();

		String usuario = req.getParameter("usuario");
		String senha = req.getParameter("senha");
		// Usuário válido.
		if (usuario != null && usuario.equals("admin") && senha != null && senha.equals("admin")) {
			sessao.setAttribute("usuarioLogado", true);
			resp.sendRedirect("sorteio");
		} else {
			sessao.setAttribute("usuarioLogado", false);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}

}