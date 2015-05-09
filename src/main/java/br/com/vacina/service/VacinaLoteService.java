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

import br.com.vacina.dao.VacinaLoteDAO;
import br.com.vacina.domain.VacinaLote;

@Path("/vacinaLote")
public class VacinaLoteService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		VacinaLoteDAO vacinaLoteDao = new VacinaLoteDAO();
		List<VacinaLote> cartoesVacina = vacinaLoteDao.listar();

		return Response.ok(cartoesVacina).build();
	}

	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("codigo") Integer codigo) {
		VacinaLoteDAO vacinaLoteDao = new VacinaLoteDAO();
		VacinaLote vacinaLote = vacinaLoteDao.buscar(codigo);

		return Response.ok(vacinaLote).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(VacinaLote vacinaLote) {
		VacinaLoteDAO vacinaLoteDao = new VacinaLoteDAO();
		vacinaLoteDao.salvar(vacinaLote);

		return Response.ok(vacinaLote).build();
	}

}
