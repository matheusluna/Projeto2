package banco;

import com.google.gson.Gson;

import conexoes.ConnectionFactoryRedis;
import entidades.Tcc;
import interfaces.DaoTccRedisInterface;
import redis.clients.jedis.Jedis;

public class DaoTccRedis implements DaoTccRedisInterface{

	@Override
	public boolean create(Tcc tcc) {
		Jedis jedis = new ConnectionFactoryRedis().getConnection();
		Gson gson = new Gson();
		String conteudo = gson.toJson(tcc);
		jedis.set(tcc.getTitulo(), conteudo);
		jedis.close();
		return true;
	}

	@Override
	public Tcc read(String titulo) {
		// TODO Auto-generated method stub
		Jedis jedis = new ConnectionFactoryRedis().getConnection();
		Gson gson = new Gson();
		String conteudo = jedis.get(titulo);
		Tcc tcc = gson.fromJson(conteudo, Tcc.class);
		jedis.close();
		return tcc;
	}

	@Override
	public boolean delete(Tcc tcc) {
		// TODO Auto-generated method stub
		Jedis jedis = new ConnectionFactoryRedis().getConnection();
		jedis.del(tcc.getTitulo());
		jedis.close();
		return true;
	}

}
