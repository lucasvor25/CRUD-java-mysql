package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	//nome do usuario do mysql
	private static final String USERNAME = "root";
	//senha do mysql
	private static final String PASSWORD = "admin";
	//caminho do banco de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3307/agenda";
	//conexao com o mysql
	public static Connection createConnectionToMySQL() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		//Criar conexao do banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL,
				USERNAME , PASSWORD);
		
		return connection;
	}
	public static void main(String[] args) throws Exception {
		Connection con = createConnectionToMySQL();
		if(con!=null) {
			System.out.println("Conexao obtida com sucesso!");
			con.close();
		}
	}
}
