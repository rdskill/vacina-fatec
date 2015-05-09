package br.com.vacina.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class UnidadeSaude {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loteSequence")
	@SequenceGenerator(name = "loteSequence", sequenceName = "loteSequence", allocationSize = 1)
	private Integer codigo;
	
	@Column(length = 50)
	@Basic(optional = false)
	private String descricao;
	
	@Column(length = 20)
	@Basic(optional = false)
	private String latitude;
	
	@Column(length = 20)
	@Basic(optional = false)
	private String longitude;

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

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "UnidadeSaude [codigo=" + codigo + ", descricao=" + descricao
				+ ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
}
