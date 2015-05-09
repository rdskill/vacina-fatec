package br.com.vacina.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CartaoVacina {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cartaoVacinaSequence")
	@SequenceGenerator(name = "cartaoVacinaSequence", sequenceName = "cartaoVacinaSequence", allocationSize = 1)
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
	
	@Column
	@Basic(optional = false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "CartaoVacina [codigo=" + codigo + ", descricao=" + descricao
				+ ", login=" + login + ", senha=" + senha + ", dataNascimento="
				+ dataNascimento + "]";
	}
	
	
}
