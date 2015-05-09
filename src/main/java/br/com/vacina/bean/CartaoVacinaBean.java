package br.com.vacina.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.vacina.dao.CartaoVacinaDAO;
import br.com.vacina.domain.CartaoVacina;

@ManagedBean
@ViewScoped
public class CartaoVacinaBean {

	private CartaoVacina cartaoVacina;
	private List<CartaoVacina> cartaoVacinas;

	public void salvar() {
		CartaoVacinaDAO cartaoVacinaDAO = new CartaoVacinaDAO();
		cartaoVacinaDAO.salvar(cartaoVacina);

		Messages.addGlobalInfo("CartaoVacina salva com sucesso");

		cartaoVacina = new CartaoVacina();

		iniciar();
	}

	@PostConstruct
	public void iniciar() {
		cartaoVacina = new CartaoVacina();

		CartaoVacinaDAO cartaoVacinaDAO = new CartaoVacinaDAO();

		cartaoVacinas = cartaoVacinaDAO.listar();
	}

	public CartaoVacina getCartaoVacina() {
		return cartaoVacina;
	}

	public void setCartaoVacina(CartaoVacina cartaoVacina) {
		this.cartaoVacina = cartaoVacina;
	}

	public List<CartaoVacina> getCartaoVacinas() {
		return cartaoVacinas;
	}

	public void setCartaoVacinas(List<CartaoVacina> cartaoVacinas) {
		this.cartaoVacinas = cartaoVacinas;
	}
}
