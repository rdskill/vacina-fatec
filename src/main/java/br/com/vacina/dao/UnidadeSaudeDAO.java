package br.com.vacina.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.vacina.domain.UnidadeSaude;
import br.com.vacina.util.HibernateUtil;

public class UnidadeSaudeDAO {
	public void salvar(UnidadeSaude unidadeSaude) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(unidadeSaude);
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
	
	public List<UnidadeSaude> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<UnidadeSaude> unidadesSaude = null;
		try {
			Criteria consulta = sessao.createCriteria(UnidadeSaude.class);
			consulta.addOrder(Order.asc("descricao"));
			unidadesSaude = consulta.list();
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
		return unidadesSaude;
	}
	
	public UnidadeSaude buscar(Integer codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		UnidadeSaude unidadeSaude = null;
		try {
			Criteria consulta = sessao.createCriteria(UnidadeSaude.class);
			consulta.add(Restrictions.idEq(codigo));
			unidadeSaude = (UnidadeSaude)consulta.uniqueResult();
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
		return unidadeSaude;
	}
}
