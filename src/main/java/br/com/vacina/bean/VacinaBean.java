package br.com.vacina.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.vacina.dao.VacinaDAO;
import br.com.vacina.domain.Vacina;

@ManagedBean
@ViewScoped
public class VacinaBean {
	private Vacina vacina;
	private List<Vacina> vacinas;

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
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
			vacina = new Vacina();

			// Cria um objeto para ter acesso as operações de banco de dados
			VacinaDAO vacinaDAO = new VacinaDAO();
			
			// Recupera os registros do banco de dados e armazena o resultado em uma lista
			vacinas = vacinaDAO.listar();
		} catch (RuntimeException runtimeException) {
			// Exibe uma mensagem de erro
			Messages.addGlobalError(runtimeException.getMessage());
		}
	}

	public void incluir() {
		try {
			// Cria um objeto para ter acesso as operações de banco de dados
			VacinaDAO vacinaDAO = new VacinaDAO();

			// Invoca o método que efetua a inserção de um objeto
			vacinaDAO.salvar(this.vacina);

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
			if(vacina.getCodigo() == null){
				// Exibe uma mensagem de erro
				Messages.addGlobalError("Selecione uma vacina");
				
				// Interrompe a execução do método
				return;
			}
			
			// Cria um objeto para ter acesso as operações de banco de dados
			VacinaDAO vacinaDAO = new VacinaDAO();

			// Invoca o método que efetua a exclusão de um objeto
			vacinaDAO.excluir(this.vacina);

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
			if(vacina.getCodigo() == null){
				// Exibe uma mensagem de erro
				Messages.addGlobalError("Selecione uma vacina");
				
				// Interrompe a execução do método
				return;
			}
			
			// Cria um objeto para ter acesso as operações de banco de dados
			VacinaDAO vacinaDAO = new VacinaDAO();

			// Invoca o método que efetua a edição de um objeto
			vacinaDAO.editar(this.vacina);

			// Reinicializa os objetos de tela
			this.iniciar();

			// Exibe uma mensagem de sucesso
			Messages.addGlobalInfo("Edição Realizada com Sucesso");
		} catch (RuntimeException runtimeException) {
			// Exibe uma mensagem de erro
			Messages.addGlobalError(runtimeException.getMessage());
		}
	}
}
