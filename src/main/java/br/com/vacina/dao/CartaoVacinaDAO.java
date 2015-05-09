package br.com.vacina.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.vacina.domain.CartaoVacina;
import br.com.vacina.util.HibernateUtil;

public class CartaoVacinaDAO {
	public void salvar(CartaoVacina cartaoVacina) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(cartaoVacina);
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
	
	public List<CartaoVacina> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<CartaoVacina> cartaoVacina = null;
		try {
			Criteria consulta = sessao.createCriteria(CartaoVacina.class);
			consulta.addOrder(Order.asc("descricao"));
			cartaoVacina = consulta.list();
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
		return cartaoVacina;
	}
	
	public CartaoVacina buscar(Integer codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		CartaoVacina cartaoVacina = null;
		try {
			Criteria consulta = sessao.createCriteria(CartaoVacina.class);
			consulta.add(Restrictions.idEq(codigo));
			cartaoVacina = (CartaoVacina)consulta.uniqueResult();
		} catch (RuntimeException excecao) {
			throw excecao;
		} finally {
			sessao.close();
		}
		return cartaoVacina;
	}
}
