package ec.edu.ups.sd.Universidades.services;

import java.util.List;

import ec.edu.ups.sd.Universidades.GestionUniversidad.GestionUniversidad;
import ec.edu.ups.sd.Universidades.model.universidad;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("universidad")
public class UniversidadService {
	
	@Inject
	private GestionUniversidad gsUniversidad;
	

	@POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(universidad Universidad) {
        try {
            gsUniversidad.guardarUniversidad(Universidad); // Suponiendo que esta línea guarda el mensaje de usuario
            ErrorMessage error = new ErrorMessage(1, "Mensaje creado y correo enviado correctamente");
            return Response.status(Response.Status.CREATED).entity(error).build();
        } catch (Exception e) {
            ErrorMessage error = new ErrorMessage(99, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(error)
                    .build();
        }
    }
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(universidad Universidad) {
		try{
			gsUniversidad.actualizarUniversidad(Universidad);
			return Response.ok(Universidad).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response borrar(@QueryParam("id") int codigo) {
		try{
			gsUniversidad.borrarUniversidad(codigo);
			ErrorMessage error = new ErrorMessage(1, "OK");
			//return Response.ok(cliente).build();
			return Response.status(Response.Status.CREATED).entity(error).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getClientes(){
		List<universidad> peliculas = gsUniversidad.getUniversidad();
		if(peliculas.size()>0)
			return Response.ok(peliculas).build();
		ErrorMessage error = new ErrorMessage(6, "No se registran peliculas");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
}
