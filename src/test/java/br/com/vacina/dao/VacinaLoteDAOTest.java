package br.com.vacina.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.vacina.domain.Lote;
import br.com.vacina.domain.UnidadeSaude;
import br.com.vacina.domain.Vacina;
import br.com.vacina.domain.VacinaLote;

public class VacinaLoteDAOTest {
	@Test
	public void salvar() {
		VacinaDAO vacinaDAO = new VacinaDAO();
		LoteDAO loteDAO = new LoteDAO();
		UnidadeSaudeDAO unidadeSaudeDAO = new UnidadeSaudeDAO();
		
		Vacina vacina = vacinaDAO.buscar(1);
		Lote lote = loteDAO.buscar(1);
		UnidadeSaude unidadeSaude = unidadeSaudeDAO.buscar(2);
		
		VacinaLote vacinaLote = new VacinaLote();
		vacinaLote.setLote(lote);
		vacinaLote.setUnidadeSaude(unidadeSaude);
		vacinaLote.setVacina(vacina);
		
		VacinaLoteDAO vacinaLoteDAO = new VacinaLoteDAO();
		vacinaLoteDAO.salvar(vacinaLote);
	}
	
	@Test
	public void listar() throws Exception {
		VacinaLoteDAO vacinaLoteDAO = new VacinaLoteDAO();
		List<VacinaLote> vacinaLotes = vacinaLoteDAO.listar();
		System.out.println(vacinaLotes);
	}
	
	@Test
	public void buscar() throws Exception {
		VacinaLoteDAO vacinaLoteDAO = new VacinaLoteDAO();
		VacinaLote vacinaLote = vacinaLoteDAO.buscar(4);
		System.out.println(vacinaLote);
		Assert.assertNotNull(vacinaLote);
	}
}
