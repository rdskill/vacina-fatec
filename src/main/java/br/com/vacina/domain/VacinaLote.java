package br.com.vacina.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class VacinaLote {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vacinaLoteSequence")
	@SequenceGenerator(name = "vacinaLoteSequence", sequenceName = "vacinaLoteSequence", allocationSize = 1)
	private Integer codigo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Vacina vacina;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Lote lote;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private UnidadeSaude unidadeSaude;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public UnidadeSaude getUnidadeSaude() {
		return unidadeSaude;
	}

	public void setUnidadeSaude(UnidadeSaude unidadeSaude) {
		this.unidadeSaude = unidadeSaude;
	}

	@Override
	public String toString() {
		return "VacinaLote [codigo=" + codigo + ", vacina=" + vacina
				+ ", lote=" + lote + ", unidadeSaude=" + unidadeSaude
				+ ", getCodigo()=" + getCodigo() + ", getVacina()="
				+ getVacina() + ", getLote()=" + getLote()
				+ ", getUnidadeSaude()=" + getUnidadeSaude() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
