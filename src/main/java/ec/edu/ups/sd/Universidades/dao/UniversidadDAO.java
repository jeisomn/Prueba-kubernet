package ec.edu.ups.sd.Universidades.dao;

import java.util.List;

import ec.edu.ups.sd.Universidades.model.universidad;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class UniversidadDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(universidad Universidad) {
		em.persist(Universidad);
	}
	
	public void update(universidad Universidad) {
		em.merge(Universidad);
	}
	
	public void remove(int codigo) {
		universidad MensajesUsuarios = em.find(universidad.class, codigo);
		em.remove(MensajesUsuarios);
	}
	
	public universidad read(int codigo) {
		universidad MensajesUsuarios = em.find(universidad.class, codigo);
		return MensajesUsuarios;
	}
	
	public List<universidad> getAll(){
		String jpql = "SELECT c FROM MensajesUsuarios c";
		Query q = em.createQuery(jpql, universidad.class);
		return q.getResultList();
	}

}
