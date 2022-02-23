package ec.edu.ups.ppw.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ppw.modelo.Categoria;


@Stateless
public class CategoriaDAO {
	
	@PersistenceContext
	private EntityManager em;
	

	public void insert(Categoria categoria) {

		em.persist(categoria);

	}
	
    public void update(Categoria categoria) {
		
   	 em.merge(categoria);
		
	}
    
    
    public Categoria read(int id) {
 		
   	Categoria categoria = em.find(Categoria.class, id);
		return  categoria;
	}
   
    public void delate (int id) {
   	 Categoria categoria = em.find(Categoria.class, id);
   	 em.remove(categoria);
   	 
    }
    
    public List <Categoria > getList(){
   	 
   	 String jpql ="SELECT p FROM Categoria p" ;
   	 
   	 Query q = em.createQuery(jpql,Categoria.class);
   	 
   	 return q.getResultList();
   	 
    }
	
    
    public List <Categoria> getListNombre(String filtro){
   	 
   	 String jpql ="SELECT p FROM Categoria p "
   	 		+ "WHERE cat_nombre LIKE ?1";
   	 System.out.println(jpql);
   	 
   	 Query q = em.createQuery(jpql,Categoria.class);
   	 
   	 q.setParameter(1,filtro);
   	 
   	 return q.getResultList();
   	 
    }

}
