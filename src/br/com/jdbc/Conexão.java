package br.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexão {
	public static Connection getConnection(){
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/P2","root", "juggernaut");
			System.out.println("Conectado ");
					
		}catch (SQLException e ){
			System.out.println("Erro-Conexao"+e.getMessage());
		}catch (ClassNotFoundException e){
			System.out.println("Erro - Driver" + e.getMessage());
		}return con;
		
		
		
		
		
		
		
		
		
		
	}
}
