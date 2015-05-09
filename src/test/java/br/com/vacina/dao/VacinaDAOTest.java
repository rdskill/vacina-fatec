package br.com.vacina.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.vacina.domain.Vacina;

public class VacinaDAOTest {
	@Test
	public void salvar() {
		Vacina vacina = new Vacina();
		vacina.setDescricao("Juliano Rosa");
		vacina.setObservacao("ju");
		
		VacinaDAO categoriaDAO = new VacinaDAO();
		categoriaDAO.salvar(vacina);
	}
	
	@Test
	public void listar() throws Exception {
		VacinaDAO vacinaDAO = new VacinaDAO();
		List<Vacina> vacinas = vacinaDAO.listar();
		System.out.println(vacinas);
	}
	
	@Test
	public void buscar() throws Exception {
		VacinaDAO vacinaDAO = new VacinaDAO();
		Vacina vacina = vacinaDAO.buscar(1);
		System.out.println(vacina);
		Assert.assertNotNull(vacina);
	}
}
