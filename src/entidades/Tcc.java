package entidades;

import java.util.Arrays;
import java.util.List;

public class Tcc {
	private String autor;
	private String orientador;
	private String[] palavrasChave;
	private int ano;
	private String resumo;
	private String area;
	private String titulo;
	private String caminho;
	private String texto;
	
	

	public Tcc(String autor, String orientador, String[] palavrasChave, int ano, String resumo, String area,
			String titulo, String caminho, String texto) {
		super();
		this.autor = autor;
		this.orientador = orientador;
		this.palavrasChave = palavrasChave;
		this.ano = ano;
		this.resumo = resumo;
		this.area = area;
		this.titulo = titulo;
		this.caminho = caminho;
		this.texto = texto;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getOrientador() {
		return orientador;
	}

	public void setOrientador(String orientador) {
		this.orientador = orientador;
	}

	public String[] getPalavrasChave() {
		return palavrasChave;
	}

	public void setPalavrasChave(String[] palavrasChave) {
		this.palavrasChave = palavrasChave;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((caminho == null) ? 0 : caminho.hashCode());
		result = prime * result + ((orientador == null) ? 0 : orientador.hashCode());
		result = prime * result + Arrays.hashCode(palavrasChave);
		result = prime * result + ((resumo == null) ? 0 : resumo.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tcc other = (Tcc) obj;
		if (ano != other.ano)
			return false;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (caminho == null) {
			if (other.caminho != null)
				return false;
		} else if (!caminho.equals(other.caminho))
			return false;
		if (orientador == null) {
			if (other.orientador != null)
				return false;
		} else if (!orientador.equals(other.orientador))
			return false;
		if (!Arrays.equals(palavrasChave, other.palavrasChave))
			return false;
		if (resumo == null) {
			if (other.resumo != null)
				return false;
		} else if (!resumo.equals(other.resumo))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	
	
}
