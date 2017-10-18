package banco;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Value;
import org.neo4j.driver.v1.Values;

import com.beust.jcommander.Parameters;

import conexoes.ConnectionFactoryNeo4j;
import entidades.Tcc;
import interfaces.DaoTccNeo4jInterface;

public class DaoTccNeo4j implements DaoTccNeo4jInterface{
	public List<Tcc> listarTcc() throws UnknownHostException{
		List<Tcc> lista = new ArrayList<>();
		DaoTcc dao = new DaoTcc();
		Driver driver = new ConnectionFactoryNeo4j().getConnection();
		Session session = driver.session();
		String cql = "MATCH (t:Tcc) RETURN t.titulo AS titulo";
		StatementResult result = session.run(cql);
		while(result.hasNext()) {
			Record record = result.next();
			String titulo = record.get("titulo").asString();
			Tcc tcc = dao.read(titulo);
			lista.add(tcc);
		}
		session.close();
		driver.close();
		return lista;
	}
	
	public List<Tcc> listarOrientador(String orientador) throws UnknownHostException{
		List<Tcc> lista = new ArrayList<>();
		DaoTcc dao = new DaoTcc();
		Driver driver = new ConnectionFactoryNeo4j().getConnection();
		Session session = driver.session();
		String cql = "MATCH (o:Orientador{nome:$nome})-[Orienta]->(t:Tcc)"
				+ "RETURN t.titulo AS titulo";
		StatementResult result = session.run(cql, Values.parameters("nome", orientador));
		while(result.hasNext()) {
			Record record = result.next();
			String titulo = record.get("titulo").asString();
			Tcc tcc = dao.read(titulo);
			lista.add(tcc);
		}
		session.close();
		driver.close();
		return lista;
	}
	
	public List<Tcc> listarArea(String area) throws UnknownHostException{
		List<Tcc> lista = new ArrayList<>();
		DaoTcc dao = new DaoTcc();
		Driver driver = new ConnectionFactoryNeo4j().getConnection();
		Session session = driver.session();
		String cql = "MATCH (a:Area{nome:$nome})-[Tem]->(t:Tcc)"
				+ "RETURN t.titulo AS titulo";
		StatementResult result = session.run(cql, Values.parameters("nome", area));
		while(result.hasNext()) {
			Record record = result.next();
			String titulo = record.get("titulo").asString();
			Tcc tcc = dao.read(titulo);
			lista.add(tcc);
		}
		session.close();
		driver.close();
		return lista;
	}
	
	@Override
	public boolean create(Tcc tcc) throws UnknownHostException {
		// TODO Auto-generated method stub
		List<Tcc> lista = listarTcc();
		for(Tcc t : lista) {
			if(t.equals(tcc)) {
				return false;
			}
		}
		Driver driver = new ConnectionFactoryNeo4j().getConnection();
		Session session = driver.session();
		String cql = "MATCH (o:Orientador{nome:$nome})"
				+ "RETURN o.nome AS nome";
		StatementResult result = session.run(cql, Values.parameters("nome", tcc.getOrientador()));
		if(!result.hasNext()) {
			cql = "CREATE (o:Orientador{nome:$nome})";
			session.run(cql, Values.parameters("nome", tcc.getOrientador()));
		}
		cql = "MATCH (a:Area{nome:$nome})"
				+ "RETURN a.nome AS nome";
		result = session.run(cql, Values.parameters("nome", tcc.getArea()));
		if(!result.hasNext()) {
			cql = "CREATE (a:Area{nome:$nome})";
			session.run(cql, Values.parameters("nome", tcc.getArea()));
		}
		
		cql = "CREATE (t:Tcc{titulo:$titulo})";
		session.run(cql, Values.parameters("titulo", tcc.getTitulo()));
		cql = "MATCH (o:Orientador{nome:$nome}), (a:Area{nome:$nome2}), (t:Tcc{titulo:$titulo})"
              +"CREATE (o)-[:Orienta]->(t), (t)-[:Orientado]->(o), (t)-[:Pertence]->(a), (a)-[:Tem]->(t)";
		session.run(cql, Values.parameters("nome", tcc.getOrientador(), "nome2", tcc.getArea(), "titulo", tcc.getTitulo()));
		session.close();
		driver.close();
		return true;
	}

	@Override
	public Tcc read(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Tcc tcc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Tcc tcc) {
		// TODO Auto-generated method stub
		return false;
	}

}
