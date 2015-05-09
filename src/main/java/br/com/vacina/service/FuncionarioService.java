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

import br.com.vacina.dao.FuncionarioDAO;
import br.com.vacina.domain.Funcionario;

@Path("/funcionario")
public class FuncionarioService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		FuncionarioDAO funcionarioDao = new FuncionarioDAO();
		List<Funcionario> cartoesVacina = funcionarioDao.listar();

		return Response.ok(cartoesVacina).build();
	}

	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("codigo") Integer codigo) {
		FuncionarioDAO funcionarioDao = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDao.buscar(codigo);

		return Response.ok(funcionario).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(Funcionario funcionario) {
		FuncionarioDAO funcionarioDao = new FuncionarioDAO();
		funcionarioDao.salvar(funcionario);

		return Response.ok(funcionario).build();
	}

}
