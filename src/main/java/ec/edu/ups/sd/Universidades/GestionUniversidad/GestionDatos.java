package ec.edu.ups.sd.Universidades.GestionUniversidad;
import ec.edu.ups.sd.Universidades.model.universidad;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {
	
	@Inject
	GestionUniversidad gUniversidad;

	@PostConstruct
	public void init() {
		System.out.println("iniciando");
		
		universidad uni = new universidad();
		uni.setCodigo(1);
		uni.setNombre("Universidad Politecnica Salesiana");
		uni.setDireccion("Cuenca");
		uni.setTelefono("09999999999");
		
		gUniversidad.guardarUniversidad(uni);
		
	}

}
