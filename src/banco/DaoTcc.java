package banco;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

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
