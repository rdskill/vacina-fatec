package br.com.vacina.dao;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.vacina.domain.CartaoVacina;
import br.com.vacina.domain.Vacina;
import br.com.vacina.domain.Vacinacao;

public class VacinacaoDAOTest {
	@Test
	public void salvar() {
		VacinaDAO vacinaDAO = new VacinaDAO();
		CartaoVacinaDAO cartaoVacinaDAO = new CartaoVacinaDAO();
		
		Vacina vacina = vacinaDAO.buscar(1);
		CartaoVacina cartaoVacina = cartaoVacinaDAO.buscar(1);
		
		Vacinacao vacinacao = new Vacinacao();
		vacinacao.setCartaoVacina(cartaoVacina);
		vacinacao.setVacina(vacina);
		vacinacao.setDataVacinacao(new Date());
		
		VacinacaoDAO categoriaDAO = new VacinacaoDAO();
		categoriaDAO.salvar(vacinacao);
	}
	
	@Test
	public void listar() throws Exception {
		VacinacaoDAO vacinacaoDAO = new VacinacaoDAO();
		List<Vacinacao> vacinacaos = vacinacaoDAO.listar();
		System.out.println(vacinacaos);
	}
	
	@Test
	public void buscar() throws Exception {
		VacinacaoDAO vacinacaoDAO = new VacinacaoDAO();
		Vacinacao vacinacao = vacinacaoDAO.buscar(2);
		System.out.println(vacinacao);
		Assert.assertNotNull(vacinacao);
	}
}
