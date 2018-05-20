package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Modalidades;
import model.Olimpiadas;

public class OlimpiadasDAO {
	public void criar(Olimpiadas olimpiadas) {
		String sqlInsert = "INSERT INTO olimpiada(ouro,prata,bronze,modalidade_id,pais_id,ano_ano) VALUES (?,?,?,?,?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setInt(1, olimpiadas.getOuro());
			stm.setInt(2, olimpiadas.getPrata());
			stm.setInt(3, olimpiadas.getBronze());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					
			
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Olimpiadas olimpiadas) {
		String sqlUpdate = "UPDATE olimpiada SET ouro=?, prata=?, bronze=? WHERE modalidade_id=?,pais_id,ano_ano";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, olimpiadas.getOuro());
			stm.setInt(2, olimpiadas.getPrata());
			stm.setInt(3, olimpiadas.getBronze());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Olimpiadas olimpiadas) {
		String sqlDelete = "DELETE FROM olimpiada WHERE ouro=?,prata =?,bronze = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Olimpiadas carregar(Olimpiadas olimpiadas) {
		
		String sqlSelect = "SELECT ouro,prata,bronze,modalidade_id,pais_id,ano_ano FROM olimpiada  = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, olimpiadas.getOuro());
			stm.setInt(2, olimpiadas.getPrata());
			stm.setInt(3, olimpiadas.getBronze());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
				
					olimpiadas.setOuro(0);
					olimpiadas.setBronze(0);
					olimpiadas.setPrata(0);
					
				} else {
					olimpiadas.setOuro(-1);
					olimpiadas.setBronze(-1);
					olimpiadas.setPrata(-1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return olimpiadas;

	}
	public ArrayList<Olimpiadas> listaOlimpiadas()
	{
		Olimpiadas olimpiadas ;
		ArrayList <Olimpiadas>lista  = new ArrayList<>();
		String sqlSelect = "SELECT id,nome, ouro, prata, bronze FROM olimpiada ";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
		
		try (ResultSet rs = stm.executeQuery();) {
			if (rs.next()) {
				olimpiadas = new Olimpiadas(0, 0, 0);
				olimpiadas.setOuro(rs.getInt("ouro"));
				olimpiadas.setPrata(rs.getInt("prata"));
				olimpiadas.setBronze(rs.getInt("bronze"));
				lista.add(olimpiadas);

			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
			// TODO: handle exception
		}catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
		
	}
	public ArrayList<Olimpiadas> listaOlimpiadas(String chave)
	{
		Olimpiadas olimpiadas;
		ArrayList <Olimpiadas>lista  = new ArrayList<>();
		String sqlSelect = "SELECT ouro, prata, bronze,modalidade_id,pais_id,ano_ano FROM olimpiada where upper(ouro)like?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
		stm.setString(1, "%"+chave.toUpperCase()+"%");
		try (ResultSet rs = stm.executeQuery();) {
			if (rs.next()) {
				olimpiadas = new Olimpiadas(0, 0, 0);
				
				olimpiadas.setOuro(rs.getInt("ouro"));
				olimpiadas.setPrata(rs.getInt("prata"));
				olimpiadas.setBronze(rs.getInt("bronze"));
				lista.add(olimpiadas);

			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
			// TODO: handle exception
		}catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
		
	}
}