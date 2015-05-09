package br.com.vacina.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Vacinacao {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vacinacaoSequence")
	@SequenceGenerator(name = "vacinacaoSequence", sequenceName = "vacinacaoSequence", allocationSize = 1)
	private Integer codigo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private CartaoVacina cartaoVacina;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Vacina vacina;
	
	@Column
	@Basic(optional = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataVacinacao;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public CartaoVacina getCartaoVacina() {
		return cartaoVacina;
	}

	public void setCartaoVacina(CartaoVacina cartaoVacina) {
		this.cartaoVacina = cartaoVacina;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	public Date getDataVacinacao() {
		return dataVacinacao;
	}

	public void setDataVacinacao(Date dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}

	@Override
	public String toString() {
		return "Vacinacao [codigo=" + codigo + ", cartaoVacina=" + cartaoVacina
				+ ", vacina=" + vacina + ", dataVacinacao=" + dataVacinacao
				+ "]";
	}
}
