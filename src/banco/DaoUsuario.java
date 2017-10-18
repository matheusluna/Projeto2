package banco;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import conexoes.ConnectionFactory;
import conversores.Conversor;
import entidades.Usuario;
import interfaces.DaoUsuarioInterface;

public class DaoUsuario implements DaoUsuarioInterface{
	public List<Usuario> listar() throws SQLException, ClassNotFoundException{
		Conversor conversor = new Conversor();
		List<Usuario> lista = new ArrayList<>();
		Connection con = new ConnectionFactory().getConnection();
		String sql = "select * from usuario";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			String nome = rs.getString("nome");
			String email = rs.getString("email");
			String senha = rs.getString("senha");
			LocalDate nascimento = LocalDate.parse(rs.getString("datadenascimento"));
			String sexo = rs.getString("sexo");
			String telefone = rs.getString("telefone");
			String foto = rs.getString("foto");
			Usuario usuario = new Usuario(nome, email, senha, nascimento, telefone, sexo, foto);
			lista.add(usuario);
		}
		stmt.close();
		con.close();
		return lista;
	}
	
	@Override
	public boolean create(Usuario usuario) throws SQLException, ClassNotFoundException {
		List<Usuario> lista = listar();
		for(Usuario u : lista) {
			if(u.getEmail().equals(usuario.getEmail())) {
				return false;
			}
		}
		Connection con = new ConnectionFactory().getConnection();
		String sql = "insert into usuario values(?,?,?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getEmail());
		stmt.setDate(3, Date.valueOf(usuario.getNascimento()));
		stmt.setString(4, usuario.getSexo());
		stmt.setString(5, usuario.getSenha());
		stmt.setString(6, usuario.getTelefone());
		stmt.setString(7, usuario.getFoto());
		boolean resultado = !stmt.execute();
		stmt.close();
		con.close();
		return resultado;
	}

	@Override
	public Usuario read(String email) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		List<Usuario> lista = listar();
		for(Usuario u : lista) {
			if(u.getEmail().equals(email)) {
				return u;
			}
		}
		return null;
	}

	@Override
	public boolean update(Usuario usuario) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		List<Usuario> lista = listar();
		for(Usuario u : lista) {
			if(u.getEmail().equals(usuario.getEmail())) {
				Connection con = new ConnectionFactory().getConnection();
				String sql = "update usuario set nome = ?, senha = ?, datadenascimento = ?, sexo = ?, telefone = ?, foto = ? where email = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, usuario.getNome());
				stmt.setString(2, usuario.getSenha());
				stmt.setDate(3, Date.valueOf(usuario.getNascimento()));
				stmt.setString(4, usuario.getSexo());				
				stmt.setString(5, usuario.getTelefone());
				stmt.setString(6, usuario.getFoto());
				stmt.setString(7, usuario.getEmail());
				boolean resultado = !stmt.execute();
				stmt.close();
				con.close();
				return resultado;
			}
		}
		return false;
	}

	@Override
	public boolean delete(Usuario usuario) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		List<Usuario> lista = listar();
		for(Usuario u : lista) {
			if(u.getEmail().equals(usuario.getEmail())) {
				Connection con = new ConnectionFactory().getConnection();
				String sql = "delete from usuario where email = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, usuario.getEmail());
				boolean resultado = !stmt.execute();
				stmt.close();
				con.close();
				return resultado;
			}
		}
		return false;
	}

}
