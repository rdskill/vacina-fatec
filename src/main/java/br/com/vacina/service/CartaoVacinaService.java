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

import br.com.vacina.dao.CartaoVacinaDAO;
import br.com.vacina.domain.CartaoVacina;

@Path("/cartaoVacina")
public class CartaoVacinaService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		CartaoVacinaDAO cartaoVacinaDao = new CartaoVacinaDAO();
		List<CartaoVacina> cartoesVacina = cartaoVacinaDao.listar();

		return Response.ok(cartoesVacina).build();
	}

	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("codigo") Integer codigo) {
		CartaoVacinaDAO cartaoVacinaDao = new CartaoVacinaDAO();
		CartaoVacina cartaoVacina = cartaoVacinaDao.buscar(codigo);

		return Response.ok(cartaoVacina).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(CartaoVacina cartaoVacina) {
		CartaoVacinaDAO cartaoVacinaDao = new CartaoVacinaDAO();
		cartaoVacinaDao.salvar(cartaoVacina);

		return Response.ok(cartaoVacina).build();
	}

}
