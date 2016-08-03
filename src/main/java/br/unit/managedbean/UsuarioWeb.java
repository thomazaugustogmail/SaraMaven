package br.unit.managedbean;

import java.io.Serializable;


public class UsuarioWeb implements Serializable {

	private static final long serialVersionUID = 405426245144541977L;

	private long id;
	private String nome;
	private String cpf;
	private int tipo;

	public UsuarioWeb() {
	}

	public UsuarioWeb(long id, String nome, String cpf, int tipo) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.tipo = tipo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
