package br.com.vacina.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Vacina {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vacinaSequence")
	@SequenceGenerator(name = "vacinaSequence", sequenceName = "vacinaSequence", allocationSize = 1)
	private Integer codigo;
	
	@Column(length = 50)
	@Basic(optional = false)
	private String descricao;
	
	@Column(length = 100)
	@Basic(optional = true)
	private String observacao;

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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "Vacina [codigo=" + codigo + ", descricao=" + descricao
				+ ", observacao=" + observacao + "]";
	}
}
