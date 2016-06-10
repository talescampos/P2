package br.com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.beans.Produto;

public class ProdutoDAO {

	//depois apagas (connection)
	private Connection con =  (Connection) Conexão.getConnection();

	
	public List<Produto> buscarProduto(Produto produto ){
		String sql ="SELECT * FROM PRODUTO";
		List<Produto> lista = new ArrayList<Produto>();
		try {
				
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();
			while(resultados.next()){
			Produto prod = new Produto();
			prod.setId(resultados.getInt("id"));
			prod.setDescrição(resultados.getString("descrição"));
			prod.setPreço(resultados.getInt("preço"));
					lista.add(prod);
				
			}
		
		
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
			
		}return lista;
	
	
	
	
	
}
	
	
}
