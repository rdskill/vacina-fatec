package br.com.vacina.bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.vacina.dao.CartaoVacinaDAO;
import br.com.vacina.dao.VacinaDAO;
import br.com.vacina.dao.VacinacaoDAO;
import br.com.vacina.domain.CartaoVacina;
import br.com.vacina.domain.Vacina;
import br.com.vacina.domain.Vacinacao;

@ManagedBean
@ViewScoped
public class VacinacaoBean {
	private Vacinacao vacinacao;
	private List<Vacinacao> vacinacoes;
	private List<CartaoVacina> cartoesVacina;
	private List<Vacina> vacinas;

	public Vacinacao getVacinacao() {
		return vacinacao;
	}

	public void setVacinacao(Vacinacao vacinacao) {
		this.vacinacao = vacinacao;
	}

	public List<Vacinacao> getVacinacoes() {
		return vacinacoes;
	}

	public void setVacinacaos(List<Vacinacao> vacinacaos) {
		this.vacinacoes = vacinacaos;
	}

	public List<Vacina> getVacinas() {
		return vacinas;
	}

	public void setVacinas(List<Vacina> vacinas) {
		this.vacinas = vacinas;
	}

	@PostConstruct
	public void iniciar() {
		try {
			// Cria um objeto para armazenar os dados da tela
			vacinacao = new Vacinacao();

			// Cria um objeto para ter acesso as operações de banco de dados
			VacinacaoDAO vacinacaoDAO = new VacinacaoDAO();

			// Recupera os registros do banco de dados e armazena o resultado em
			// uma lista
			vacinacoes = vacinacaoDAO.listar();

			// Cria um objeto para ter acesso as operações de banco de dados
			VacinaDAO vacinaDAO = new VacinaDAO();

			// Recupera os registros do banco de dados e armazena o resultado em
			// uma lista
			vacinas = vacinaDAO.listar();
			
			// Cria um objeto para ter acesso as operações de banco de dados
			CartaoVacinaDAO cartaoVacinaDAO = new CartaoVacinaDAO();

			// Recupera os registros do banco de dados e armazena o resultado em
			// uma lista
			cartoesVacina = cartaoVacinaDAO.listar();
		} catch (RuntimeException runtimeException) {
			// Exibe uma mensagem de erro
			Messages.addGlobalError(runtimeException.getMessage());
		}
	}

	public void incluir() {
		try {
			// Cria um objeto para ter acesso as operações de banco de dados
			VacinacaoDAO vacinacaoDAO = new VacinacaoDAO();
			
			// Colocar data atual na vacinação
			vacinacao.setDataVacinacao(new Date());

			// Invoca o método que efetua a inserção de um objeto
			vacinacaoDAO.salvar(this.vacinacao);

			// Reinicializa os objetos de tela
			this.iniciar();

			// Exibe uma mensagem de sucesso
			Messages.addGlobalInfo("Inclusão Realizada com Sucesso");
		} catch (RuntimeException runtimeException) {
			// Exibe uma mensagem de erro
			Messages.addGlobalError(runtimeException.getMessage());
		}
	}

	public void excluir() {
		try {
			if (vacinacao.getCodigo() == null) {
				// Exibe uma mensagem de erro
				Messages.addGlobalError("Selecione uma vacinacao");

				// Interrompe a execução do método
				return;
			}

			// Cria um objeto para ter acesso as operações de banco de dados
			VacinacaoDAO vacinacaoDAO = new VacinacaoDAO();

			// Invoca o método que efetua a exclusão de um objeto
			vacinacaoDAO.excluir(this.vacinacao);

			// Reinicializa os objetos de tela
			this.iniciar();

			// Exibe uma mensagem de sucesso
			Messages.addGlobalInfo("Exclusão Realizada com Sucesso");
		} catch (RuntimeException runtimeException) {
			// Exibe uma mensagem de erro
			Messages.addGlobalError(runtimeException.getMessage());
		}
	}

	public void editar() {
		try {
			if (vacinacao.getCodigo() == null) {
				// Exibe uma mensagem de erro
				Messages.addGlobalError("Selecione uma vacinacao");

				// Interrompe a execução do método
				return;
			}

			// Cria um objeto para ter acesso as operações de banco de dados
			VacinacaoDAO vacinacaoDAO = new VacinacaoDAO();

			// Invoca o método que efetua a edição de um objeto
			vacinacaoDAO.editar(this.vacinacao);

			// Reinicializa os objetos de tela
			this.iniciar();

			// Exibe uma mensagem de sucesso
			Messages.addGlobalInfo("Edição Realizada com Sucesso");
		} catch (RuntimeException runtimeException) {
			// Exibe uma mensagem de erro
			Messages.addGlobalError(runtimeException.getMessage());
		}
	}

	public List<CartaoVacina> getCartoesVacina() {
		return cartoesVacina;
	}

	public void setCartoesVacina(List<CartaoVacina> cartoesVacina) {
		this.cartoesVacina = cartoesVacina;
	}
}
