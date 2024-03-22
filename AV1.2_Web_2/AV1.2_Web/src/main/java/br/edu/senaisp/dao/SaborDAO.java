package br.edu.senaisp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.senaisp.model.Sabor;

public class SaborDAO {

	private final String SQLINSERT = 
	"INSERT INTO sabores (nome, descricao, preco) VALUES(?, ?, ?)";
	
	private final String SQLSELECT = 
	"SELECT id, nome, descricao, preco FROM sabores";	
	
	public void novo(Sabor sabor) {
		System.out.println(sabor.getNome());
		try {
			Connection con = dao.conexao();
			
            if (!con.isClosed()) {
            	PreparedStatement ps = 
            			con.prepareStatement(SQLINSERT);
            	ps.setString(1, sabor.getNome());
            	ps.setString(2, sabor.getDescricao());
            	ps.setFloat(3, sabor.getPreco());
            	
            	ps.execute();
            }
            	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Sabor> lista() {
		System.out.println("Sele��o");
		
		List<Sabor> sabores = new ArrayList<Sabor>();
		
		try {
			Connection con = dao.conexao();
			
            if (!con.isClosed()) {
            	PreparedStatement ps = 
            	con.prepareStatement(SQLSELECT);
            	ResultSet rs = ps.executeQuery();
            	
            	Sabor tmp = null;
            	while (rs.next()) {
            		
            		tmp = new Sabor();
            		tmp.setId( rs.getInt("id") );
            		tmp.setNome(rs.getString("nome") );
            		tmp.setDescricao(rs.getString("descricao"));
            		tmp.setPreco(rs.getFloat("preco"));
            		
            		sabores.add(tmp);
            	}
            	
            	con.close();
            }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return sabores;
	}
	
	
}
