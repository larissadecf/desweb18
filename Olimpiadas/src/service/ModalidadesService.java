package service;

import java.util.ArrayList;

import dao.ModalidadesDAO;
import model.Modalidades;

public class ModalidadesService {
ModalidadesDAO dao = new ModalidadesDAO();
	
	public void criar(Modalidades modalidades) {
		dao.criar(modalidades);
	}

	public void atualizar(Modalidades modalidades) {
		dao.atualizar(modalidades);
	}

	public void excluir(int id) {
		dao.excluir(id);
	}

	public void carregar(int id) {
		dao.carregar(id);
	}
	
	public ArrayList<Modalidades> listarModalidades(){
		return dao.listaModalidades();
	}
	public ArrayList<Modalidades> listarModalidades(String chave){
		return dao.listaModalidades(chave);
	}
}
