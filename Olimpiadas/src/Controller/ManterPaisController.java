package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pais;
import service.PaisService;

/**
 * Servlet implementation class ManterPaisController
 */
@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String acao = request.getParameter("acao");
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pPopulacao = request.getParameter("populacao");
		String pArea = request.getParameter("area");
		HttpSession session = request.getSession();
		String pagina = "";

		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {
		}

		Pais p = new Pais();
		p.setId(id);
		p.setNome(pNome);
		if (pPopulacao != null && pPopulacao.length() > 0) {

			p.setPopulacao(Long.parseLong(pPopulacao));
			p.setArea(Double.parseDouble(pArea));
		}

		PaisService ps = new PaisService();

		if (acao.equals("Criar")) {

			ps.criar(p);

			ps.carregar(p.getId());

			request.setAttribute("pais", p);
			pagina = "ManterPais.jsp";

			
		} else if (acao.equals("Visualizar")) {
			ps.carregar(p.getId());
			request.setAttribute("pais", p);
			pagina = "ManterPais.jsp";
		}

		else if (acao.equals("Excluir")) {
			ps.excluir(p.getId());
			ArrayList<Pais> lista = (ArrayList<Pais>) session.getAttribute("lista");
			lista.remove(busca(p, lista));
			session.setAttribute("lista", lista);
			pagina = "ListarPaises.jsp";

			
		} else if (acao.equals("Alterar")) {
			ps.atualizar(p);
			ArrayList<Pais> lista = (ArrayList<Pais>) session.getAttribute( "lista" );
			int pos = busca(p, lista);
			lista.remove(pos);
			lista.add(pos, p);
			session.setAttribute("lista", lista);
			request.setAttribute("pais", p);
			pagina = "ManterPais.jsp";
		}
		
		else if (acao.equals("Editar")) {
			ps.carregar(p.getId());
			request.setAttribute("pais", p);
			pagina = "AlterarPais.jsp";
		}
			
		
		RequestDispatcher view = request.getRequestDispatcher(pagina);
		view.forward(request, response);
	}

	private int busca(Pais pais, ArrayList<Pais> lista) {
		Pais to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == pais.getId()) {
				return i;
			}
		}
		return -1;
	}

}
