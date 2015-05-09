package br.com.vacina.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.vacina.dao.VacinacaoDAO;
import br.com.vacina.domain.Vacinacao;

@Path("/vacinacao")
public class VacinacaoService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		VacinacaoDAO vacinacaoDao = new VacinacaoDAO();
		List<Vacinacao> cartoesVacina = vacinacaoDao.listar();

		return Response.ok(cartoesVacina).build();
	}

	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("codigo") Integer codigo) {
		VacinacaoDAO vacinacaoDao = new VacinacaoDAO();
		Vacinacao vacinacao = vacinacaoDao.buscar(codigo);

		return Response.ok(vacinacao).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(Vacinacao vacinacao) {
		VacinacaoDAO vacinacaoDao = new VacinacaoDAO();
		vacinacaoDao.salvar(vacinacao);

		return Response.ok(vacinacao).build();
	}

}
