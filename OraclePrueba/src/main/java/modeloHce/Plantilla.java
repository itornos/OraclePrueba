package modeloHce;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="SGP_DEF_PLANTILLAS")
public class Plantilla {

	@Id
	@Column(name="id_plantilla", unique = true, nullable = false, precision = 10)
	private double id;
	
	@Column(name="nombre")
	private String nombre;

	@Column(name="editable_SGP")
	private char editableSGP;

	@Column(name="fecha_baja")
	private Date fechaBaja;

	@Column(name="campo_hl7")
	private String campoHL7;

	@Column(name="relacion_epicon")
	private char relacionEpicon;
	
	@Column(name="tipo_cardinalidad")
	private int tipoCardinalidad;

	@Column(name="tiene_estado")
	private char estado;
	
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
}
