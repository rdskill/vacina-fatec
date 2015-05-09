package br.com.vacina.dao;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.vacina.domain.CartaoVacina;

public class CartaoVacinaDAOTest {
	@Test
	public void salvar() {
		CartaoVacina cartaoVacina = new CartaoVacina();
		cartaoVacina.setDataNascimento(new Date());
		cartaoVacina.setDescricao("Juliano Rosa");
		cartaoVacina.setLogin("ju");
		cartaoVacina.setSenha("rosa123");
		
		CartaoVacinaDAO categoriaDAO = new CartaoVacinaDAO();
		categoriaDAO.salvar(cartaoVacina);
	}
	
	@Test
	public void listar() throws Exception {
		CartaoVacinaDAO cartaoVacinaDAO = new CartaoVacinaDAO();
		List<CartaoVacina> cartoesVacina = cartaoVacinaDAO.listar();
		System.out.println(cartoesVacina);
	}
	
	@Test
	public void buscar() throws Exception {
		CartaoVacinaDAO cartaoVacinaDAO = new CartaoVacinaDAO();
		CartaoVacina cartaoVacina = cartaoVacinaDAO.buscar(1);
		System.out.println(cartaoVacina);
		Assert.assertNotNull(cartaoVacina);
	}
}
