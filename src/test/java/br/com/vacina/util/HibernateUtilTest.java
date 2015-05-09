package br.com.vacina.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import br.com.vacina.util.HibernateUtil;

public class HibernateUtilTest {
	@Test
	public void conectar() {
		// Captura a fábrica de sessões
		SessionFactory  fabrica = HibernateUtil.getSessionFactory();
		
		// Captura uma sessão
		Session sessao = fabrica.openSession();
		
		// Finaliza a sessão aberta
		sessao.close();
		
		// Finaliza a fábriga de sessões
		fabrica.close();
	}
}
