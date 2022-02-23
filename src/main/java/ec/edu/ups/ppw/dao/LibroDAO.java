package ec.edu.ups.ppw.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ppw.modelo.Libro;


@Stateless
public class LibroDAO {
	
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Libro libro) {

		em.persist(libro);

	}
	
    public void update(Libro libro) {
		
   	 em.merge(libro);
		
	}
    
    
    public Libro read(int id) {
 		
   	Libro libro = em.find(Libro.class, id);
		return  libro;
	}
   
    public void delate (int id) {
   	 Libro libro = em.find(Libro.class, id);
   	 em.remove(libro);
   	 
    }
    
    public List <Libro > getList(){
   	 
   	 String jpql ="SELECT p FROM Libro p" ;
   	 
   	 Query q = em.createQuery(jpql,Libro.class);
   	 
   	 return q.getResultList();
   	 
    }
	
    
    public List <Libro> getListNombre(String filtro){
   	 
   	 String jpql ="SELECT p FROM Libro p "
   	 		+ "WHERE lib_titulo LIKE ?1";
   	 System.out.println(jpql);
   	 
   	 Query q = em.createQuery(jpql,Libro.class);
   	 
   	 q.setParameter(1,filtro);
   	 
   	 return q.getResultList();
   	 
    }


}
