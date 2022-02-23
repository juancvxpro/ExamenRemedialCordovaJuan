package ec.edu.ups.ppw.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_RESERVA")
public class Libro implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="lib_id")
	int id;
	
	@Column(name="lib_titulo")
	String titulo;
	
	@Column(name="lib_editorial")
	String editorial;
	
	@Column(name="lib_pages")
	String pages;
	
	@Column(name="lib_stock")
	String stock;
	
	@OneToOne 
	@JoinColumn (name="cat_codigo")
	private Categoria categoria;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="lib_autores")
	private List<Autor> autores	;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", editorial=" + editorial + ", pages=" + pages + ", stock="
				+ stock + ", categoria=" + categoria + ", autores=" + autores + "]";
	}

   
	
	
   
	
}
