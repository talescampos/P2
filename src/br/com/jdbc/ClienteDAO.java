package br.com.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 import java.sql.Connection;
import br.com.beans.Cliente;

public class ClienteDAO {

	
	private Connection con =  Conexão.getConnection();
	
	
		public void cadastro(Cliente cliente){
			String sql ="insert into cliente (nome, login, senha) values(?,?,?)";
		try {
			//prepara trecho sql
			
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getLogin());
			preparador.setString(3, cliente.getSenha());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Cadastrado!");
		} catch (SQLException e) {
			System.out.println("Erro - SQL" + e.getMessage());
			} 
		}
		
		
		
		public List<Cliente> buscarTodos(Cliente cliente ){
			String sql ="SELECT * FROM Cliente";
			List<Cliente> lista = new ArrayList<Cliente>();
			try {
					
				PreparedStatement preparador = con.prepareStatement(sql);
				ResultSet resultados = preparador.executeQuery();
				while(resultados.next()){
				Cliente cli = new Cliente();
				cli.setId(resultados.getInt("id"));
				cli.setNome(resultados.getString("nome"));
				cli.setLogin(resultados.getString("login"));
				cli.setSenha(resultados.getString("Senha"));
				lista.add(cli);
					
				}
			
			
			} catch (SQLException e) {
				System.out.println("Erro - " + e.getMessage());
				
			}return lista;
	
	}
		
		public Cliente autenticacao(Cliente cliente ){
			Cliente cliRetorno = null;
			String sql = "SELECT * FROM cliente where login = ? and senha = ?";
			
			try {
					
				PreparedStatement preparador = con.prepareStatement(sql);
				preparador.setString(1, cliente.getLogin());
				preparador.setString(2, cliente.getSenha());
				
				ResultSet resultados = preparador.executeQuery();
				if (resultados.next()){
				 cliRetorno = new Cliente();
				cliRetorno.setId(resultados.getInt("id"));
				cliRetorno.setNome(resultados.getString("nome"));
				cliRetorno.setLogin(resultados.getString("login"));
				cliRetorno.setSenha(resultados.getString("Senha"));
				
					
				}
			
			
			} catch (SQLException e) {
				System.out.println("Erro - " + e.getMessage());
			}
			return cliRetorno;
			
}}
	
