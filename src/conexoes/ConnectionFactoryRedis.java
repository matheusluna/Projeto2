package conexoes;

import redis.clients.jedis.Jedis;

public class ConnectionFactoryRedis {
	public Jedis getConnection() {
		return new Jedis("localhost", 6379);
	}
}
