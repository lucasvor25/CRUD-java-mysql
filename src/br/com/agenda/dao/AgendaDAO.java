package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Agenda;

public class AgendaDAO {
//Salvando a agenda
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
	//Atualizando a agenda
	public void update(Agenda agenda) {
		String sql = "UPDATE contatos SET nome = ?, idade = ?, dataCadastro = ?"+
	"WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, agenda.getNome());
			pstm.setInt(2, agenda.getIdade());
			pstm.setDate(3, new Date(agenda.getDataCadastro().getTime()));
			pstm.setInt(4, agenda.getId());
			
			pstm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	//Metodo para apagar agendas pelo id
	public void deletarPorId(int id) {
		String sql = "DELETE FROM contatos WHERE id = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn= ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!= null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
//Metodo para buscar agendas no banco de dados
	public List<Agenda> getAgendas(){
		String sql = "SELECT * FROM contatos";
		
		List<Agenda> agendas = new ArrayList<Agenda>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Recuperar dados do banco
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
		
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Agenda agenda = new Agenda();
				agenda.setId(rset.getInt("id"));
				agenda.setNome(rset.getString("nome"));
				agenda.setIdade(rset.getInt("idade"));
				agenda.setDataCadastro(rset.getDate("dataCadastro"));
				agenda.add(agenda);
			}
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				try {
				if(rset!=null){
					rset.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return agendas;	
		}
			
	}

