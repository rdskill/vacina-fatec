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

import br.com.vacina.dao.LoteDAO;
import br.com.vacina.domain.Lote;

@Path("/lote")
public class LoteService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		LoteDAO loteDao = new LoteDAO();
		List<Lote> cartoesVacina = loteDao.listar();

		return Response.ok(cartoesVacina).build();
	}

	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("codigo") Integer codigo) {
		LoteDAO loteDao = new LoteDAO();
		Lote lote = loteDao.buscar(codigo);

		return Response.ok(lote).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(Lote lote) {
		LoteDAO loteDao = new LoteDAO();
		loteDao.salvar(lote);

		return Response.ok(lote).build();
	}

}
