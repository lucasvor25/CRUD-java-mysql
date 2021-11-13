package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;

import com.mysql.jdbc.PreparedStatement;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Agenda;

public class AgendaDAO {

	public void save(Agenda agenda) {
	String sql = "INSERT INTO contatos(nome, idade, datacadastro) VALUES (?,?,?)";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		//Criar uma conexao com o mysql
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		pstm.setString(1, agenda.getNome());
		pstm.setInt(2, agenda.getIdade());
		pstm.setDate(3, new Date(agenda.getDataCadastro().getTime()));
	
		pstm.execute();
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		
		try {
			if(pstm!=null) {
				pstm.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		}
}
}
