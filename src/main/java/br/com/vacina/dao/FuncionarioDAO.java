package br.com.vacina.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.vacina.domain.Funcionario;
import br.com.vacina.util.HibernateUtil;

public class FuncionarioDAO {
	public void salvar(Funcionario funcionario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(funcionario);
			transacao.commit();
		} catch (RuntimeException excecao) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw excecao;
		} finally {
			sessao.close();
		}
	}
	
	public List<Funcionario> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Funcionario> funcionarios = null;
		try {
			Criteria consulta = sessao.createCriteria(Funcionario.class);
			consulta.addOrder(Order.asc("descricao"));
			funcionarios = consulta.list();
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
		return funcionarios;
	}
	
	public Funcionario buscar(Integer codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Funcionario funcionario = null;
		try {
			Criteria consulta = sessao.createCriteria(Funcionario.class);
			consulta.add(Restrictions.idEq(codigo));
			funcionario = (Funcionario)consulta.uniqueResult();
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
		return funcionario;
	}
}
