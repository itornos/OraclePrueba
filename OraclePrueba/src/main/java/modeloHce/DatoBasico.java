package modeloHce;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SGP_DEF_DATOBASICO")
public class DatoBasico {

	@Id
	@Column(name="ID_DATOBASICO", unique = true, nullable = false, precision = 10)
	private double id;
	
	@Column(name="TIPO_BASICO")
	private String tipo_basico;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.datobasico", cascade=CascadeType.ALL)
	private Set<ArquetipoDatoBasico> arquetipoDatoBasico;
	
	public DatoBasico() {
		this.id = 0;
		this.nombre = "";
		this.arquetipoDatoBasico = new HashSet<ArquetipoDatoBasico>(0);
	}
	
	public DatoBasico(double id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.arquetipoDatoBasico = new HashSet<ArquetipoDatoBasico>(0);
	}
	
	public DatoBasico(double id) {
		this.id = id;
		this.nombre = "";
		this.arquetipoDatoBasico = new HashSet<ArquetipoDatoBasico>(0);
	}
	
	public void annadirArqPlant(ArquetipoDatoBasico p) {
		arquetipoDatoBasico.add(p);
	}
	
	public double getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<ArquetipoDatoBasico> getArquetipoDatoBasico() {
		return arquetipoDatoBasico;
	}

	public void setArquetipoDatoBasico(Set<ArquetipoDatoBasico> arquetipoDatobasico) {
		this.arquetipoDatoBasico = arquetipoDatobasico;
	}
}
