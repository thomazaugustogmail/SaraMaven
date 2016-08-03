package br.unit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_projetos")
public class Projeto implements Serializable {

	private static final long serialVersionUID = -460749298671731820L;

	@Id
	@GeneratedValue
	private long id;
	@Column
	private String cod_projeto;
	@Column
	private String url_projeto;
	@Column
	private String titulo ;
	@Column
	private String modalidade;
	@Column
	private String vinculacao;
	@Column
	private Date per_ini;
	@Column
	private Date per_fim;
	@Column
	private boolean bolsista;
	@Column
	private boolean aprovado;
	@Column
	private String cpf;
	@Column
	private int cod_area;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCod_projeto() {
		return cod_projeto;
	}
	public void setCod_projeto(String cod_projeto) {
		this.cod_projeto = cod_projeto;
	}
	public String getUrl_projeto() {
		return url_projeto;
	}
	public void setUrl_projeto(String url_projeto) {
		this.url_projeto = url_projeto;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	public String getVinculacao() {
		return vinculacao;
	}
	public void setVinculacao(String vinculacao) {
		this.vinculacao = vinculacao;
	}
	public Date getPer_ini() {
		return per_ini;
	}
	public void setPer_ini(Date per_ini) {
		this.per_ini = per_ini;
	}
	public Date getPer_fim() {
		return per_fim;
	}
	public void setPer_fim(Date per_fim) {
		this.per_fim = per_fim;
	}
	public boolean isBolsista() {
		return bolsista;
	}
	public void setBolsista(boolean bolsista) {
		this.bolsista = bolsista;
	}
	public boolean isAprovado() {
		return aprovado;
	}
	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getCod_area() {
		return cod_area;
	}
	public void setCod_area(int cod_area) {
		this.cod_area = cod_area;
	}
}
