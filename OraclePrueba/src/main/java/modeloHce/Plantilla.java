package modeloHce;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SGP_DEF_PLANTILLAS")
public class Plantilla {

	@Id
	@Column(name="id_plantilla", unique = true, nullable = false, precision = 10)
	private double id;
	
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.plantilla")
	private Set<PlantillaArquetipo> arquetipoPlantilla;
	
	public Plantilla() {
		this.id = 0;
		this.nombre = "";
		this.arquetipoPlantilla = new HashSet<PlantillaArquetipo>(0);
	}
	
	public Plantilla(double id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.arquetipoPlantilla = new HashSet<PlantillaArquetipo>(0);
	}
	
	public Plantilla(double id) {
		this.id = id;
		this.nombre = "";
		this.arquetipoPlantilla = new HashSet<PlantillaArquetipo>(0);
	}
	
	public void annadirArqPlant(PlantillaArquetipo p) {
		arquetipoPlantilla.add(p);
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

	public Set<PlantillaArquetipo> getArquetipoPlantilla() {
		return arquetipoPlantilla;
	}

	public void setArquetipoPlantilla(Set<PlantillaArquetipo> arquetipoPlantilla) {
		this.arquetipoPlantilla = arquetipoPlantilla;
	}
}
