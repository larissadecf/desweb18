package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Modalidades;

public class ModalidadesDAO<ListaModalidades> {
	public int criar(Modalidades modalidades) {
		String sqlInsert = "INSERT INTO modalidade( nome, tipo,pais_id,ano_ano,olimpiada_id ) VALUES (?,?,?,?,? )";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setString(1, modalidades.getNome());
			stm.setString(2, modalidades.getTipo());
			
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					modalidades.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modalidades.getId();
	}

	public void atualizar(Modalidades modalidades) {
		String sqlUpdate = "UPDATE modalidade SET  nome=?,tipo=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setString(1, modalidades.getNome());
			stm.setString(2, modalidades.getTipo());
			stm.setInt(3, modalidades.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM modalidade WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Modalidades carregar(int id) {
		Modalidades modalidades = new Modalidades();
		modalidades.setId(id);
		String sqlSelect = "SELECT nome, tipo,pais_id,olimpiada_id,ano_ano FROM modalidade WHERE modalidade.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, modalidades.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					modalidades.setNome(rs.getString("nome"));
					modalidades.setTipo(rs.getString("tipo"));
					

				} else {
					modalidades.setId(-1);
					modalidades.setNome(null);
					modalidades.setTipo(null);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return modalidades;

	}
	
	public ArrayList<Modalidades> listaModalidades()
	{
		Modalidades modalidades ;
		ArrayList <Modalidades>lista  = new ArrayList<>();
		String sqlSelect = "SELECT id,nome,tipo,ano_ano,pais_id,olimpiada_id FROM modalidade ";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
		
		try (ResultSet rs = stm.executeQuery();) {
			if (rs.next()) {
				modalidades = new Modalidades();
				modalidades.setId(rs.getInt("id"));
				modalidades.setNome(rs.getString("nome"));
				modalidades.setTipo(rs.getString("tipo"));
				
				lista.add(modalidades);

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
	public ArrayList<Modalidades> listaModalidades(String chave)
	{
		Modalidades modalidades ;
		ArrayList <Modalidades>lista  = new ArrayList<>();
		String sqlSelect = "SELECT id,nome, tipo,ano_ano,pais_id,olimpiada_id FROM modalidade where upper(nome)like?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
		stm.setString(1, "%"+chave.toUpperCase()+"%");
		try (ResultSet rs = stm.executeQuery();) {
			if (rs.next()) {
				modalidades = new Modalidades();
				modalidades.setId(rs.getInt("id"));
				modalidades.setNome(rs.getString("nome"));
				modalidades.setTipo(rs.getString("tipo"));
				
				lista.add(modalidades);

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