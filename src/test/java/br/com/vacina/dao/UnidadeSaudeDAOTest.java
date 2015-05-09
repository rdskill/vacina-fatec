package br.com.vacina.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.vacina.domain.UnidadeSaude;

public class UnidadeSaudeDAOTest {
	@Test
	public void salvar() {
		UnidadeSaude unidadeSaude = new UnidadeSaude();
		unidadeSaude.setDescricao("Juliano Rosa");
		unidadeSaude.setLatitude("-12939231");
		unidadeSaude.setLongitude("-123312132");
		
		UnidadeSaudeDAO categoriaDAO = new UnidadeSaudeDAO();
		categoriaDAO.salvar(unidadeSaude);
	}
	
	@Test
	public void listar() throws Exception {
		UnidadeSaudeDAO unidadeSaudeDAO = new UnidadeSaudeDAO();
		List<UnidadeSaude> unidadeSaudes = unidadeSaudeDAO.listar();
		System.out.println(unidadeSaudes);
	}
	
	@Test
	public void buscar() throws Exception {
		UnidadeSaudeDAO unidadeSaudeDAO = new UnidadeSaudeDAO();
		UnidadeSaude unidadeSaude = unidadeSaudeDAO.buscar(2);
		System.out.println(unidadeSaude);
		Assert.assertNotNull(unidadeSaude);
	}
}
