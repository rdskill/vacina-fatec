package br.com.vacina.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.vacina.domain.Funcionario;

public class FuncionarioDAOTest {
	@Test
	public void salvar() {
		Funcionario funcionario = new Funcionario();
		funcionario.setDescricao("Juliano Rosa");
		funcionario.setLogin("ju");
		funcionario.setSenha("rosa123");
		
		FuncionarioDAO categoriaDAO = new FuncionarioDAO();
		categoriaDAO.salvar(funcionario);
	}
	
	@Test
	public void listar() throws Exception {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> funcionarios = funcionarioDAO.listar();
		System.out.println(funcionarios);
	}
	
	@Test
	public void buscar() throws Exception {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1);
		System.out.println(funcionario);
		Assert.assertNotNull(funcionario);
	}
}
