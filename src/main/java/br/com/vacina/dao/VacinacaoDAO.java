package br.com.vacina.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.vacina.domain.Vacinacao;
import br.com.vacina.util.HibernateUtil;

public class VacinacaoDAO {
	public void salvar(Vacinacao vacinacao) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(vacinacao);
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
	
	public List<Vacinacao> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Vacinacao> vacinacao = null;
		try {
			Criteria consulta = sessao.createCriteria(Vacinacao.class);
			consulta.addOrder(Order.asc("dataVacinacao"));
			vacinacao = consulta.list();
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
		return vacinacao;
	}
	
	public Vacinacao buscar(Integer codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Vacinacao vacinacao = null;
		try {
			Criteria consulta = sessao.createCriteria(Vacinacao.class);
			consulta.add(Restrictions.idEq(codigo));
			vacinacao = (Vacinacao)consulta.uniqueResult();
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
		return vacinacao;
	}
}
