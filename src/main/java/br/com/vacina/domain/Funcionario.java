package br.com.vacina.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionarioSequence")
	@SequenceGenerator(name = "funcionarioSequence", sequenceName = "funcionarioSequence", allocationSize = 1)
	private Integer codigo;
		
	@Column(length = 50)
	@Basic(optional = false)
	private String descricao;
		
	@Column(length = 20)
	@Basic(optional = false)
	private String login;
		
	@Column(length = 20)
	@Basic(optional = false)
	private String senha;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Funcionario [codigo=" + codigo + ", descricao=" + descricao
				+ ", login=" + login + ", senha=" + senha + "]";
	}
}
