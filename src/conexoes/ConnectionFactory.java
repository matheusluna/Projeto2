package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() throws SQLException, ClassNotFoundException{
		String url = "jdbc:postgresql://localhost:5432/tcc";
		String user = "postgres";
		String senha = "123456";
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection(url, user, senha);
	}
}
