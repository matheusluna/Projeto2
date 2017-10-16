package conexoes;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.Mongo;

public class ConnectionFactoryMongo {
	public DB getConnection() throws UnknownHostException {
		Mongo m = new Mongo("localhost", 27017);
		DB db = m.getDB("tcc");
		db.createCollection("tccs", null);
		return db;
	}
}
