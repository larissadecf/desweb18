package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Olimpiadas;
import service.OlimpiadasService;


public class AlterarOlimpiadas implements Command {
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
