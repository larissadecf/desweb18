package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Olimpiadas;
import service.OlimpiadasService;

public class CriarOlimpiadas implements Command {
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String oOuro = request.getParameter("ouro");
		String oPrata = request.getParameter("prata");
		String oBronze = request.getParameter("bronze");
		
		
		Olimpiadas o = new Olimpiadas();
		
			o.setOuro(Integer.parseInt(oOuro));
			o.setPrata(Integer.parseInt(oPrata));
			o.setBronze(Integer.parseInt(oBronze));
			
		
		
		OlimpiadasService os = new OlimpiadasService();


			os.criar(o);

			os.carregar(o);

			request.setAttribute("olimpiadas", o);
			RequestDispatcher view = request.getRequestDispatcher("VisualizarOlimpiadas.jsp");
			view.forward(request, response);
		
	}
}
