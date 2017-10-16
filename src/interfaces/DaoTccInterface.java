package interfaces;

import java.net.UnknownHostException;

import entidades.Tcc;

public interface DaoTccInterface {
	public boolean create(Tcc tcc) throws UnknownHostException;
	public Tcc read(String titulo) throws UnknownHostException;
	public boolean update(Tcc tcc) throws UnknownHostException;
	public boolean delete(Tcc tcc) throws UnknownHostException;
}
