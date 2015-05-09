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
public class Lote {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loteSequence")
	@SequenceGenerator(name = "loteSequence", sequenceName = "loteSequence", allocationSize = 1)
	private Integer codigo;
	
	@Column(length = 50)
	@Basic(optional = false)
	private String descricao;
	
	@Column
	@Basic(optional = false)
	private Integer quantidade;
	
	@Column
	@Basic(optional = false)
	private Integer ordem;
	
	@Column
	@Basic(optional = false)
	@Temporal(TemporalType.DATE)
	private Date data;

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

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Lote [codigo=" + codigo + ", descricao=" + descricao
				+ ", quantidade=" + quantidade + ", ordem=" + ordem + ", data="
				+ data + "]";
	}
}
