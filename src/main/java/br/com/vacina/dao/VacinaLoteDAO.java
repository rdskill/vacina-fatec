package br.com.vacina.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.vacina.domain.VacinaLote;
import br.com.vacina.util.HibernateUtil;

public class VacinaLoteDAO {
	public void salvar(VacinaLote vacinaLote) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(vacinaLote);
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
	
	public List<VacinaLote> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<VacinaLote> vacinaLote = null;
		try {
			Criteria consulta = sessao.createCriteria(VacinaLote.class);
			consulta.addOrder(Order.asc("codigo"));
			vacinaLote = consulta.list();
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
		return vacinaLote;
	}
	
	public VacinaLote buscar(Integer codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		VacinaLote vacinaLote = null;
		try {
			Criteria consulta = sessao.createCriteria(VacinaLote.class);
			consulta.add(Restrictions.idEq(codigo));
			vacinaLote = (VacinaLote)consulta.uniqueResult();
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
		return vacinaLote;
	}
}
