package banco;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import conexoes.ConnectionFactoryMongo;
import conversores.Conversor;
import entidades.Tcc;
import interfaces.DaoTccInterface;

public class DaoTcc implements DaoTccInterface{
	public List<Tcc> listar() throws UnknownHostException{
		DB bancoTcc = new ConnectionFactoryMongo().getConnection();
		DBCollection colecaoTcc = bancoTcc.getCollection("tccs");
		List<Tcc> lista = new ArrayList<>();
		DBCursor cursor = colecaoTcc.find();
		while(cursor.hasNext()) {
			BasicDBObject tcc = (BasicDBObject) cursor.next();
			String autor = tcc.getString("autor");
			String orientador = tcc.getString("orientador");
			String[] palavrasChave = new Conversor().lista(tcc.getString("palavrasChave"));
			int ano = tcc.getInt("ano");
			String resumo = tcc.getString("resumo");
			String area = tcc.getString("area");
			String caminho = tcc.getString("caminho");
			String texto = tcc.getString("texto");
			String titulo = tcc.getString("titulo");
			Tcc trabalho = new Tcc(autor, orientador, palavrasChave, ano, resumo, area, titulo, caminho, texto);
			lista.add(trabalho);
		}
		bancoTcc.getMongo().close();
		return lista;		
		
	}
	
	public List<Tcc> pesquisaAno(String ano) throws UnknownHostException{
		DB bancoTcc = new ConnectionFactoryMongo().getConnection();
		DBCollection colecaoTcc = bancoTcc.getCollection("tccs");
		List<Tcc> lista = new ArrayList<>();
		try {
			int numero = Integer.parseInt(ano);
			
			BasicDBObject query = new BasicDBObject();
			query.put("ano", numero);
			
			DBCursor cursor = colecaoTcc.find(query);
			while(cursor.hasNext()) {
				BasicDBObject tcc = (BasicDBObject) cursor.next();
				String autor = tcc.getString("autor");
				String orientador = tcc.getString("orientador");
				String[] palavrasChave = new Conversor().lista(tcc.getString("palavrasChave"));
				int anoBanco = tcc.getInt("ano");
				String resumo = tcc.getString("resumo");
				String area = tcc.getString("area");
				String caminho = tcc.getString("caminho");
				String texto = tcc.getString("texto");
				String titulo = tcc.getString("titulo");
				Tcc trabalho = new Tcc(autor, orientador, palavrasChave, anoBanco, resumo, area, titulo, caminho, texto);
				lista.add(trabalho);
			}
			return lista;
		}catch(NumberFormatException e) {
			return lista;
		}finally {
			return lista;
		}
		
	}
	
	public List<Tcc> pesquisaAutor(String autor) throws UnknownHostException{
		DB bancoTcc = new ConnectionFactoryMongo().getConnection();
		DBCollection colecaoTcc = bancoTcc.getCollection("tccs");
		List<Tcc> lista = new ArrayList<>();
		BasicDBObject query = new BasicDBObject();
		query.put("autor", autor);
		DBCursor cursor = colecaoTcc.find(query);
		while(cursor.hasNext()) {
			BasicDBObject tcc = (BasicDBObject) cursor.next();
			String autorBanco = tcc.getString("autor");
			String orientador = tcc.getString("orientador");
			String[] palavrasChave = new Conversor().lista(tcc.getString("palavrasChave"));
			int ano = tcc.getInt("ano");
			String resumo = tcc.getString("resumo");
			String area = tcc.getString("area");
			String caminho = tcc.getString("caminho");
			String texto = tcc.getString("texto");
			String titulo = tcc.getString("titulo");
			Tcc trabalho = new Tcc(autorBanco, orientador, palavrasChave, ano, resumo, area, titulo, caminho, texto);
			lista.add(trabalho);
		}
		return lista;
	}
	
	public List<Tcc> pesquisaConteudo(String conteudo) throws UnknownHostException{
		BasicDBObject pesquisa = new BasicDBObject();
		pesquisa.put("$search", conteudo);
		BasicDBObject meta = new BasicDBObject();
		meta.put("$meta", "textScore");
		BasicDBObject text = new BasicDBObject();
		text.put("$text", pesquisa);
		BasicDBObject score = new BasicDBObject();
		score.put("score", meta);
		
		DB bancoTcc = new ConnectionFactoryMongo().getConnection();
		DBCollection colecaoTcc = bancoTcc.getCollection("tccs");
		List<Tcc> lista = new ArrayList<>();
		DBCursor cursor = colecaoTcc.find(text, score).sort(score);
		while(cursor.hasNext()) {
			BasicDBObject tcc = (BasicDBObject) cursor.next();
			String autorBanco = tcc.getString("autor");
			String orientador = tcc.getString("orientador");
			String[] palavrasChave = new Conversor().lista(tcc.getString("palavrasChave"));
			int ano = tcc.getInt("ano");
			String resumo = tcc.getString("resumo");
			String area = tcc.getString("area");
			String caminho = tcc.getString("caminho");
			String texto = tcc.getString("texto");
			String titulo = tcc.getString("titulo");
			Tcc trabalho = new Tcc(autorBanco, orientador, palavrasChave, ano, resumo, area, titulo, caminho, texto);
			lista.add(trabalho);
		}
		return lista;
		
	}
	
	@Override
	public boolean create(Tcc tcc) throws UnknownHostException {
		// TODO Auto-generated method stub
		List<Tcc> lista = listar();
		
		for(Tcc t : lista) {
			if(t.equals(tcc)) {
				return false;
			}
		}
		DB bancoTcc = new ConnectionFactoryMongo().getConnection();
		DBCollection colecaoTcc = bancoTcc.getCollection("tccs");
		BasicDBObject trabalho = new BasicDBObject();
		trabalho.put("autor", tcc.getAutor());
		trabalho.put("orientador", tcc.getOrientador());
		trabalho.put("titulo", tcc.getTitulo());
		trabalho.put("palavrasChave", tcc.getPalavrasChave());
		trabalho.put("resumo", tcc.getResumo());
		trabalho.put("area", tcc.getArea());
		trabalho.put("caminho", tcc.getCaminho());
		trabalho.put("texto", tcc.getTexto());
		trabalho.put("ano", tcc.getAno());
		
		colecaoTcc.insert(trabalho);
		bancoTcc.getMongo().close();
		return true;
	}

	@Override
	public Tcc read(String titulo) throws UnknownHostException {
		// TODO Auto-generated method stub
		List<Tcc> lista = listar();
		for(Tcc t : lista) {
			if(t.getTitulo().equals(titulo)) {
				return t;
			}
		}
		return null;
	}

	@Override
	public boolean update(Tcc tcc) throws UnknownHostException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Tcc tcc) throws UnknownHostException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
