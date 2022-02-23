package ec.edu.ups.ppw.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.ppw.modelo.Autor;

@Stateless
public class AutorDAO {

	@PersistenceContext
	private EntityManager em;

	public void insert(Autor autor) {

		em.persist(autor);

	}
	
	

}
