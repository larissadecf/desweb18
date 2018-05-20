package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Olimpiadas;
import service.OlimpiadasService;

public class VisualizarOlimpiadas implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String oOuro = request.getParameter("ouro");
		String oPrata = request.getParameter("prata");
		String oBronze = request.getParameter("bronze");

		Olimpiadas olimpiadas = new Olimpiadas();
		olimpiadas.setOuro(Integer.parseInt(oOuro));
		olimpiadas.setPrata(Integer.parseInt(oPrata));
		olimpiadas.setBronze(Integer.parseInt(oBronze));

		OlimpiadasService os = new OlimpiadasService();
		os.atualizar(olimpiadas);
		RequestDispatcher view = null;
		olimpiadas = os.carregar(olimpiadas);
		request.setAttribute("olimpiadas", olimpiadas);
		view = request.getRequestDispatcher("VisualizarOlimpiadas.jsp");
		view.forward(request, response);
	}
}
