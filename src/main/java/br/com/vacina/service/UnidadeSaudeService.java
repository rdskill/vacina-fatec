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

import br.com.vacina.dao.UnidadeSaudeDAO;
import br.com.vacina.domain.UnidadeSaude;

@Path("/unidadeSaude")
public class UnidadeSaudeService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		UnidadeSaudeDAO unidadeSaudeDao = new UnidadeSaudeDAO();
		List<UnidadeSaude> cartoesVacina = unidadeSaudeDao.listar();

		return Response.ok(cartoesVacina).build();
	}

	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("codigo") Integer codigo) {
		UnidadeSaudeDAO unidadeSaudeDao = new UnidadeSaudeDAO();
		UnidadeSaude unidadeSaude = unidadeSaudeDao.buscar(codigo);

		return Response.ok(unidadeSaude).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(UnidadeSaude unidadeSaude) {
		UnidadeSaudeDAO unidadeSaudeDao = new UnidadeSaudeDAO();
		unidadeSaudeDao.salvar(unidadeSaude);

		return Response.ok(unidadeSaude).build();
	}

}
