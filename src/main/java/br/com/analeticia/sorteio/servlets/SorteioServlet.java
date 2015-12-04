package br.com.analeticia.sorteio.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet que realiza o sorteio dos números.
 * 
 * @author Ana Let&iacute;cia Herculano
 *
 */
@WebServlet(value = "/sorteio")
public class SorteioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 5460697432337471229L;
	
	private static final int TAMANHO_LISTA = 10;
	private static ConcurrentMap<HttpSession, List<Integer>> mapSessionList = new ConcurrentHashMap<HttpSession, List<Integer>>();
	public String daVez = "?";

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Referência para a sessão.
		HttpSession sessao = req.getSession();
		
		if (mapSessionList.containsKey(sessao)) {
			tratarSessaoQueJaPossuiUmaLista(sessao);
		} else {
			tratarSessaoQueNaoPossuiUmaLista(sessao);
		}
		
		// Insere o número da vez no atributo da requisição...
		req.setAttribute("daVez", daVez);

		// Obtém referência para o atributo "usuarioLogado".
		Boolean usuarioLogado = (Boolean) sessao.getAttribute("usuarioLogado");

		if (usuarioLogado == null || usuarioLogado == false) {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("sorteio.jsp").forward(req, resp);
		}
	}

	/**
	 * Faz o tratamento da sess&atilde;o que ainda n&atilde;o possui uma lista de n&uacute;meros.
	 * 
	 * @param sessao a sess&atilde;o do usu&aacute;rio
	 */
	private void tratarSessaoQueNaoPossuiUmaLista(HttpSession sessao) {
		List<Integer> lista;
		// A sessao nao possui lista. Irei criar uma e inserir no mapa.
		lista = new ArrayList<Integer>(TAMANHO_LISTA);
		
		// Insiro os n numeros na lista, de 1 ate TAMANHO_LISTA.
		for (int i = 1; i <= TAMANHO_LISTA; i++) {
			lista.add(i);
		}
		
		// Shuffle serve para embaralhar os elementos da lista.
		Collections.shuffle(lista);
		
		// Coloco a lista em um mapa.
		mapSessionList.put(sessao, lista);
	}
	
	/**
	 * Faz o tratamento da sess&atilde;o que j&aacute; possui uma lista de n&uacute;meros.
	 * 
	 * @param sessao a sess&atilde;o do usu&aacute;rio
	 */
	private void tratarSessaoQueJaPossuiUmaLista(HttpSession sessao) {
		List<Integer> lista;
		// A sessao ja possui uma lista no mapa. Irei usa-la.
		lista = mapSessionList.get(sessao);
		
		if (!lista.isEmpty()) {
			Integer daVezTemp = lista.get(0);
			daVez = String.valueOf(daVezTemp);
			lista.remove(0);
		} else {
			// Significa que a lista esta vazia. Imprime um '!'
			daVez = "!";
		}
	}

}