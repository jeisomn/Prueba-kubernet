package ec.edu.ups.sd.Universidades.GestionUniversidad;

import java.util.List;
import ec.edu.ups.sd.Universidades.dao.UniversidadDAO;
import ec.edu.ups.sd.Universidades.model.universidad;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionUniversidad {
	
	@Inject
	private UniversidadDAO daoUniversidad;
	
	public void guardarUniversidad(universidad Universidad) {
		universidad men = daoUniversidad.read(Universidad.getCodigo());
		if (men != null) {
			daoUniversidad.update(Universidad);
		} else {
			System.out.println("MENSAJEEEEEEEEEEEES: " + Universidad);
			daoUniversidad.insert(Universidad);
			
		}
	}
	
	public void actualizarUniversidad(universidad Universidad) throws Exception {
		universidad men = daoUniversidad.read(Universidad.getCodigo());
		if (men != null) {
			daoUniversidad.update(Universidad);
		} else {
			throw new Exception("MensajesUsuarios no existe");
		}
	}
	
	public void borrarUniversidad(int codigo) {

		daoUniversidad.remove(codigo);
	}

	public List<universidad> getUniversidad() {
		return daoUniversidad.getAll();
	}
	
	

}
