package service;

import java.util.ArrayList;

import dao.OlimpiadasDAO;
import model.Olimpiadas;

public class OlimpiadasService {
OlimpiadasDAO dao = new OlimpiadasDAO();
	
	public void criar(Olimpiadas olimpiadas) {
		dao.criar(olimpiadas);
	}

	public void atualizar(Olimpiadas olimpiadas) {
		dao.atualizar(olimpiadas);
	}

	public void excluir(Olimpiadas olimpiadas) {
		dao.excluir(olimpiadas);
	}

	public Olimpiadas carregar(Olimpiadas novo) {
		return dao.carregar(novo);
		
	}
	public ArrayList<Olimpiadas>listaOlimpiadas(){
		return dao.listaOlimpiadas();
		
	}
	public ArrayList<Olimpiadas>listaOlimpiadas(String chave){
		return dao.listaOlimpiadas(chave);
		
	}

	

	
}