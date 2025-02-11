package br.com.gestao.rest;

import java.util.List;

import br.com.casodeuso.crudregistro.RegistroDto;
import br.com.casodeuso.crudregistro.RespostaListarTodosProdutos;
import br.com.gestao.service.RegistroService;
import io.netty.handler.codec.http.HttpResponseStatus;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/registro")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Endpoint {

    @Inject
    RegistroService service;

    @GET
    @Path("/listarTodos")
    public Response listarProdutos(@QueryParam("pagina") @DefaultValue("0") int pagina,
            @QueryParam("tamanho") @DefaultValue("18") int tamanho) {

        List<RegistroDto> lista = service.recuperaTodos();
        int inicio = pagina * tamanho;
        int totalItems = lista.size();
        int totalPaginas = (int) Math.ceil((double) totalItems / tamanho);
        int fim = Math.min((pagina + 1) * tamanho, lista.size());

        return Response.ok(new PaginatedResponse<>(new RespostaListarTodosProdutos(lista.subList(inicio, fim)), pagina, tamanho, totalPaginas, totalItems)).build();
    }

    @GET
    @Path("recuperarRegistro/{id}")
    public Response recuperarRegistro(@PathParam("id") int id) {
        return Response.ok(service.recuperarRegistro(id)).build();
    }

    @PUT
    @Path("/alterar")
    public Response alterarRegistro(RegistroDto listaRegistro) {
        service.alterarRegistro(listaRegistro);
        return Response.ok().build();
    }

    @POST
    @Path("/adicionar")
    public Response adicionar(List<RegistroDto> listaRegistro) {
        service.salvarLista(listaRegistro);
        return Response.status(HttpResponseStatus.CREATED.code()).build();
    }

    // private RespostaListarTodosProdutos montarResposta() {
    // List<RegistroDto> lista = service.recuperaTodos();
    // return new RespostaListarTodosProdutos(lista);
    // }

    public static class PaginatedResponse<T> {
        public Object conteudo;
        public int pagina;
        public int tamanho;
        public int totalPaginas;
        public long totalItems;

        public PaginatedResponse(Object conteudo, int pagina, int tamanho, int totalPaginas, int totalItems) {
            this.conteudo = conteudo;
            this.pagina = pagina;
            this.tamanho = tamanho;
            this.totalPaginas = totalPaginas;
            this.totalItems = totalItems;
        }
    }
}