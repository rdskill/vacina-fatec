package br.com.vacina.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.vacina.domain.Lote;
import br.com.vacina.util.HibernateUtil;

public class LoteDAO {
	public void salvar(Lote lote) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(lote);
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
	
	public List<Lote> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Lote> cartaoVacina = null;
		try {
			Criteria consulta = sessao.createCriteria(Lote.class);
			consulta.addOrder(Order.asc("descricao"));
			cartaoVacina = consulta.list();
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
		return cartaoVacina;
	}
	
	public Lote buscar(Integer codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Lote cartaoVacina = null;
		try {
			Criteria consulta = sessao.createCriteria(Lote.class);
			consulta.add(Restrictions.idEq(codigo));
			cartaoVacina = (Lote)consulta.uniqueResult();
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
		return cartaoVacina;
	}
}
