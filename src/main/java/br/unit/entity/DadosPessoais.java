package br.unit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Entity
@Table(name="tb_dados_pessoais")
public class DadosPessoais implements Serializable{

	private static final long serialVersionUID = -1704122684519551354L;
	
	@Column@GeneratedValue
	private long id;
	@Id
	@PrimaryKeyJoinColumn
	@Column(length = 15, nullable=true, unique=true)	
	private String cpf;
	@Column(length = 13, unique=true)
	private String rg;
	@Column (length = 10)
	private String orgao_exp;
	@Column(length = 50, nullable=true)
	private String nome;
	@Column(length=1)
	private int sexo;
	@Column(length=12)
	private String telefone;
	@Column(length=100)
	private String email;
	@Column(length=100)
	private String endereco;
	@Column(length=2)
	private String uf;
	@Column(length=30)
	private String cidade;
	@Column(length=30)
	private String bairro;
	@Column(length=9)
	private String cep;
	@Column(length=32)
	private String senha;
	@Column(length=30)
	private String matricula;
	@Column(length=1)
	private int tipo;
	@Column(length=100)
	private String url_comp_res;
	
	public DadosPessoais() {
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getOrgao_exp() {
		return orgao_exp;
	}
	public void setOrgao_exp(String orgao_exp) {
		this.orgao_exp = orgao_exp;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getUrl_comp_res() {
		return url_comp_res;
	}
	public void setUrl_comp_res(String url_comp_res) {
		this.url_comp_res = url_comp_res;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((orgao_exp == null) ? 0 : orgao_exp.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + sexo;
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		result = prime * result + ((url_comp_res == null) ? 0 : url_comp_res.hashCode());
		return result;
	}	
}
