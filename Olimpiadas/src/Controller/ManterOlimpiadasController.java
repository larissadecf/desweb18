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

import model.Modalidades;
import model.Olimpiadas;
import model.Pais;
import service.OlimpiadasService;
/**
 * Servlet implementation class ManterOlimpiadasController
 */
@WebServlet("/ManterOlimpiadas.do")
public class ManterOlimpiadasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acao = request.getParameter("acao");
		String pId = request.getParameter("id");
		String pNome = request.getParameter("Nome");
		String mTipo = request.getParameter("tipo");
		String mModalidade = request.getParameter("modalidade");
		String oOuro = request.getParameter("ouro"); 
		String oPrata = request.getParameter("prata"); 
		String oBronze = request.getParameter("bronze"); 
		HttpSession session = request.getSession();
		String pagina = "";
		
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {
		}

		
	    
	    Olimpiadas o= new Olimpiadas();
	    Modalidades m = new Modalidades();
	    Pais p = new Pais();
	    p.setId(id);
	    p.setNome(pNome);
	    m.setNome(mModalidade);
	    m.setTipo(mTipo);
	    if (oOuro != null && oOuro.length() > 0) {

			o.setOuro(Integer.parseInt(oOuro));
			o.setPrata(Integer.parseInt(oPrata));
			o.setBronze(Integer.parseInt(oBronze));
		}
	 
	    
	    
		
	    OlimpiadasService os = new OlimpiadasService();
	    
	    if (acao.equals("Criar")) {

			os.criar(o);

			os.carregar(o);

			request.setAttribute("olimpiadas", o);
			pagina = "ManterOlimpiadas.jsp";

			
		} else if (acao.equals("Visualizar")) {
			os.carregar(o);
			request.setAttribute("olimpiadas", o);
			pagina = "ManterOlimpiadas.jsp";
		}

		else if (acao.equals("Excluir")) {
			os.excluir(o);
			ArrayList<Olimpiadas> lista = (ArrayList<Olimpiadas>) session.getAttribute("lista");
			lista.remove(busca(o, lista));
			session.setAttribute("lista", lista);
			pagina = "ListarOlimpiadas.jsp";

			
		} else if (acao.equals("Alterar")) {
			os.atualizar(o);
			ArrayList<Olimpiadas> lista = (ArrayList<Olimpiadas>)session.getAttribute( "lista" );
			int pos = busca(o, lista);
			lista.remove(pos);
			lista.add(pos, o);
			session.setAttribute("lista", lista);
			request.setAttribute("olimpiadas", o);
			pagina = "ManterOlimpiadas.jsp";
		}
		
		else if (acao.equals("Editar")) {
			os.carregar(o);
			request.setAttribute("olimpiadas", o);
			pagina = "AlterarOlimpiadas.jsp";
		}
			
		
		RequestDispatcher view = request.getRequestDispatcher(pagina);
		view.forward(request, response);
	}

	private int busca(Olimpiadas olimpiadas, ArrayList<Olimpiadas> lista) {
		Olimpiadas  to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			
		}
		return -1;
	}

}