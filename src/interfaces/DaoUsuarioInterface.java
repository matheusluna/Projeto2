package interfaces;

import java.sql.SQLException;

import entidades.Usuario;

public interface DaoUsuarioInterface {
	public boolean create(Usuario usuario) throws SQLException, ClassNotFoundException;
	public Usuario read(String email) throws SQLException, ClassNotFoundException;
	public boolean update(Usuario usuario) throws SQLException, ClassNotFoundException;
	public boolean delete(Usuario usuario) throws SQLException, ClassNotFoundException;
}
