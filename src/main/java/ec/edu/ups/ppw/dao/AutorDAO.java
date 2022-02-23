package ec.edu.ups.ppw.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ec.edu.ups.ppw.modelo.Autor;

@Stateless
public class AutorDAO {

	@PersistenceContext
	private EntityManager em;

	public void insert(Autor autor) {

		em.persist(autor);

	}
	
    public void update(Autor autor) {
		
   	 em.merge(autor);
		
	}
    
    
    public Autor read(int id) {
 		
   	Autor autor = em.find(Autor.class, id);
		return  autor;
	}
   
    public void delate (int id) {
   	 Autor autor = em.find(Autor.class, id);
   	 em.remove(autor);
   	 
    }
    
    public List <Autor > getList(){
   	 
   	 String jpql ="SELECT p FROM Autor p" ;
   	 
   	 Query q = em.createQuery(jpql,Autor.class);
   	 
   	 return q.getResultList();
   	 
    }
	
    
    public List <Autor> getListNombre(String filtro){
   	 
   	 String jpql ="SELECT p FROM Autor p "
   	 		+ "WHERE aut_nombre LIKE ?1";
   	 System.out.println(jpql);
   	 
   	 Query q = em.createQuery(jpql,Autor.class);
   	 
   	 q.setParameter(1,filtro);
   	 
   	 return q.getResultList();
   	 
    }
	

}
