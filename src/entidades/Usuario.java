package entidades;

import java.time.LocalDate;

public class Usuario {
	private String nome;
	private String email;
	private String senha;
	private LocalDate nascimento;
	private String telefone;
	private String sexo;
	private String foto;
	
	public Usuario(String nome, String email, String senha, LocalDate nascimento, String telefone, String sexo,
			String foto) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.nascimento = nascimento;
		this.telefone = telefone;
		this.sexo = sexo;
		this.foto = foto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
}
