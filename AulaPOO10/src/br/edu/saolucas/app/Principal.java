package br.edu.saolucas.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.edu.saolucas.db.ConexaoDB;

public class Principal {
	
	public static void salvar() {
		try {
			
			ConexaoDB.getInstancia();
			Connection conexao = ConexaoDB.conexao;
			
			String sql = "INSERT INTO veiculos (chassis, placa) VALUES "
					+ "('XXXXXXA1','JBS3369'),"
					+ "('XXXXXXA2','JBS3370'),"
					+ "('XXXXXXA3','JBS3371'),"
					+ "('XXXXXXA4','JBS3372'),"
					+ "('XXXXXXA5','JBS3373'),"
					+ "('XXXXXXA6','JBS3374'),"
					+ "('XXXXXXA7','JBS3375'),"
					+ "('XXXXXXA8','JBS3376'),"
					+ "('XXXXXXA9','JBS3377'),"
					+ "('XXXXXXA10','JBS3378');";
			
			//Prepara a instruÃ§Ã£o SQL
			PreparedStatement ps;
			ps = conexao.prepareStatement(sql);
			
			//Executa a instruÃ§Ã£o SQL
			ps.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean salvarItem(String chassis, String placa) {
		try {
			
			ConexaoDB.getInstancia();
			Connection conexao = ConexaoDB.conexao;
			
			String sql = "UPDATE funcionario SET nome=?, sobrenome=? WHERE codigo=?";
			
			//Prepara a instrução SQL
			PreparedStatement ps;
			ps = conexao.prepareStatement(sql);
			
			//Executa a instrução SQL
			ps.execute();			
			
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean atualizar(String id, String chassis, String placa) {
		try {
			
			ConexaoDB.getInstancia();
			Connection conexao = ConexaoDB.conexao;
			
			String sql = "UPDATE veiculos SET chassis='"+ chassis +"', placa= '" + placa +"' WHERE id=" + id + ";";
			
			//Prepara a instruÃ§Ã£o SQL
			PreparedStatement ps;
			ps = conexao.prepareStatement(sql);
			
			//Executa a instruÃ§Ã£o SQL
			ps.execute();
			
			return true;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean excluir(String id) {
		try {
			
			ConexaoDB.getInstancia();
			Connection conexao = ConexaoDB.conexao;
			
			String sql = "DELETE FROM veiculos WHERE id=" + id + ";";
			
			//Prepara a instruÃ§Ã£o SQL
			PreparedStatement ps;
			ps = conexao.prepareStatement(sql);
			
			//Executa a instruÃ§Ã£o SQL
			ps.execute();
			
			return true;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void buscar(String id) {
		try {
			
			ConexaoDB.getInstancia();
			Connection conexao = ConexaoDB.conexao;
			
			String sql = "SELECT * FROM veiculos WHERE id=" + id + ";";
			
			//Prepara a instruÃ§Ã£o SQL
			PreparedStatement ps;
			ps = conexao.prepareStatement(sql);
			
			// Conjunto de resultados
			ResultSet rs = ps.executeQuery();
			
			if(rs.isBeforeFirst()) {
				while(rs.next()) {
					int key = rs.getInt("id");
					String chassis = rs.getString(2);
					String placa = rs.getString("placa");
					
					String resultado = String.format("ID: %s, Chassis: %s, Placa: %s", key, chassis, placa);
					
					//System.out.println(resultado);
					JOptionPane.showMessageDialog(null, resultado);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Registro nÃ£o localizado.");
			}

		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		//salvar();
		
		/*
		// Salvar um registro
		
		String chassis, placa;
		
		chassis = JOptionPane.showInputDialog("Entre com o chassis: ");
		placa = JOptionPane.showInputDialog("Entre com a placa: ");
		
		if(salvarItem(chassis, placa))
			JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");
		else
			JOptionPane.showMessageDialog(null, "ERRO!");
		*/
		
		//Alterar registro pela id
		/*
		String id = JOptionPane.showInputDialog("Entre com a id a ser alterada: ");
		String chassis = JOptionPane.showInputDialog("Entre com o NOVO chassis: ");
		String placa = JOptionPane.showInputDialog("Entre com a NOVA placa: ");
		
		if(atualizar(id, chassis, placa))
			JOptionPane.showMessageDialog(null, "Registro atualizado!");
		else
			JOptionPane.showMessageDialog(null, "ERRO!");	
		*/
		
		//Excluir registro pela id
		
		/*
		String id = JOptionPane.showInputDialog("Entre com a id a ser EXCLUÃ�DA: ");
				
		if(excluir(id))
			JOptionPane.showMessageDialog(null, "Registro atualizado!");
		else
			JOptionPane.showMessageDialog(null, "ERRO!");	
		*/
		
		// Buscar registro
		
		String id = JOptionPane.showInputDialog("Entre com a id a ser LOCALIZADA: ");		
		buscar(id);
		
	}

}











//		ConexaoDB.getInstancia();

//		Connection conexao = ConexaoDB.conexao; 