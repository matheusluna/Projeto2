package interfaces;

import java.net.UnknownHostException;

import entidades.Tcc;

public interface DaoTccNeo4jInterface {
	public boolean create(Tcc tcc) throws UnknownHostException;
	public Tcc read(String titulo);
	public boolean update(Tcc tcc);
	public boolean delete(Tcc tcc);
}
