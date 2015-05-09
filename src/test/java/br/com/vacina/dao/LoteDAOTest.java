package br.com.vacina.dao;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.vacina.domain.Lote;

public class LoteDAOTest {
	@Test
	public void salvar() {
		Lote lote = new Lote();
		lote.setDescricao("Juliano Rosa");
		lote.setQuantidade(10);
		lote.setOrdem(1);
		lote.setData(new Date());
		
		LoteDAO categoriaDAO = new LoteDAO();
		categoriaDAO.salvar(lote);
	}
	
	@Test
	public void listar() throws Exception {
		LoteDAO loteDAO = new LoteDAO();
		List<Lote> lotes = loteDAO.listar();
		System.out.println(lotes);
	}
	
	@Test
	public void buscar() throws Exception {
		LoteDAO loteDAO = new LoteDAO();
		Lote lote = loteDAO.buscar(1);
		System.out.println(lote);
		Assert.assertNotNull(lote);
	}
}
