package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;

public class CriarPais implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pPopulacao = request.getParameter("populacao");
		String pArea = request.getParameter("area");
		
		Pais p = new Pais();
		p.setNome(pNome);
		if (pPopulacao != null && pPopulacao.length() > 0) {

			p.setPopulacao(Long.parseLong(pPopulacao));
			p.setArea(Double.parseDouble(pArea));
		
			
		}
		
		PaisService ps = new PaisService();


			ps.criar(p);

			ps.carregar(p.getId());

			request.setAttribute("pais", p);
			RequestDispatcher view = request.getRequestDispatcher("VisualizarPais.jsp");
			view.forward(request, response);
		
	}

}

