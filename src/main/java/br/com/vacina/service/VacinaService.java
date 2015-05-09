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

import br.com.vacina.dao.VacinaDAO;
import br.com.vacina.domain.Vacina;

@Path("/vacina")
public class VacinaService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		VacinaDAO vacinaDao = new VacinaDAO();
		List<Vacina> cartoesVacina = vacinaDao.listar();

		return Response.ok(cartoesVacina).build();
	}

	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("codigo") Integer codigo) {
		VacinaDAO vacinaDao = new VacinaDAO();
		Vacina vacina = vacinaDao.buscar(codigo);

		return Response.ok(vacina).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(Vacina vacina) {
		VacinaDAO vacinaDao = new VacinaDAO();
		vacinaDao.salvar(vacina);

		return Response.ok(vacina).build();
	}

}
