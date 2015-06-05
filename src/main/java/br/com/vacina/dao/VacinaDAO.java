package br.com.vacina.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.vacina.domain.Vacina;
import br.com.vacina.util.HibernateUtil;

public class VacinaDAO {
	public void salvar(Vacina vacina) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(vacina);
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
	
	public Vacina editar(Vacina categoria) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(categoria);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return categoria;
	}
	
	public Vacina excluir(Vacina categoria) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(categoria);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return categoria;
	}
	
	public List<Vacina> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Vacina> vacina = null;
		try {
			Criteria consulta = sessao.createCriteria(Vacina.class);
			consulta.addOrder(Order.asc("descricao"));
			vacina = consulta.list();
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
		return vacina;
	}
	
	public Vacina buscar(Integer codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Vacina vacina = null;
		try {
			Criteria consulta = sessao.createCriteria(Vacina.class);
			consulta.add(Restrictions.idEq(codigo));
			vacina = (Vacina)consulta.uniqueResult();
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
		return vacina;
	}
}
