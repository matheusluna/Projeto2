package interfaces;

import entidades.Tcc;

public interface DaoTccRedisInterface {
	public boolean create(Tcc tcc);
	public Tcc read(String titulo);
	public boolean delete(Tcc tcc);
}
