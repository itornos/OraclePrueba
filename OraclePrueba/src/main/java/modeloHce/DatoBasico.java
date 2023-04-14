package modeloHce;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="SGP_DEF_DATOBASICO")
@Data
public class DatoBasico {

	@Id
	@Column(name="ID_DATOBASICO", unique = true, nullable = false, precision = 10)
	private double id;
	
	@Column(name="TIPO_BASICO")
	private TipoDatoBasico tipobasico;
	
	@Column(name="TIPO_CARDINALIDAD")
	private String tipoCardinalidad;
	
	@Column(name="nombre")
	private String nombre;

	@Column(name="FECHA_BAJA")
	private String fechaBaja;

	@Column(name="CAMPO_HL7")
	private String campoHL7;

	@Column(name="NOMBRE_MOSTRADO")
	private String nombreMostrado;

	@Column(name="OCULTAR_NOMBRE")
	private String ocultarNombre;

	@Column(name="ID_TILE")
	private String idTitle;

	@Column(name="UNIDAD")
	private String unidad;

	@Column(name="VER_FECHA")
	private String verFecha;
	
	@Column(name="ESTATICO")
	private String estatico;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.datobasico", cascade=CascadeType.ALL)
	private Set<ArquetipoDatoBasico> arquetipoDatoBasico;
	
	@ManyToOne()
    @JoinColumn(name = "LISTA_VALORES")
	private ListaValores listaValores;

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
}
