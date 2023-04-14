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

import lombok.Data;

@Entity
@Table(name="SGP_DEF_ARQUETIPOS")
@Data
public class Arquetipo {

	@Id
	@Column(name="ID_ARQUETIPO", unique = true, nullable = false, precision = 10)
	private double id;
	
	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="TIPO_CARDINALIDAD")
	private String cardinalidad;

	@Column(name="ESTATICO")
	private String estatico;

	@Column(name="ID_TILE")
	private String idTitle;

	@Column(name="FECHA_BAJA")
	private String fechaBaja;

	@Column(name="CAMPO_HL7")
	private String campoHL7;

	@Column(name="NOMBRE_MOSTRADO")
	private String nombreMostrado;

	@Column(name="OCULTAR_NOMBRE")
	private String ocultarNombre;

	@Column(name="NIVEL_TITULO")
	private String nivelTitulo;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.arquetipo", cascade=CascadeType.ALL)
	private Set<PlantillaArquetipo> arquetipoPlantilla;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.arquetipo")
	private Set<ArquetipoDatoBasico> arquetipoDatobasico;
	
	public Arquetipo() {
		this.id = 0;
		this.nombre = "";
		this.arquetipoPlantilla = new HashSet<PlantillaArquetipo>(0);
	}
	
	public Arquetipo(double id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.arquetipoPlantilla = new HashSet<PlantillaArquetipo>(0);
	}
	
	public Arquetipo(double id) {
		this.id = id;
		this.nombre = "";
		this.arquetipoPlantilla = new HashSet<PlantillaArquetipo>(0);
	}
	
	public void annadirArqPlant(PlantillaArquetipo p) {
		arquetipoPlantilla.add(p);
	}
}
