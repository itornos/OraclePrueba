package modeloHce;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="SGP_DEF_REL_PLANT_ARQUET")
@AssociationOverrides({
	@AssociationOverride(name = "pk.plantilla", joinColumns = @JoinColumn(name = "ID_PLANTILLA")),
	@AssociationOverride(name = "pk.arquetipo", joinColumns = @JoinColumn(name = "ID_ARQUETIPO")) 
})
public class PlantillaArquetipo {
	@EmbeddedId
	private PlantillaArquetipoId pk;
	
	@Column(name="ID_INTERNO")
	private double idInterno;
	
	public PlantillaArquetipo() {
		pk = new PlantillaArquetipoId();
		this.idInterno = 0;
	}
	
	public PlantillaArquetipo(Plantilla plantilla, Arquetipo arquetipo, double id) {
		pk = new PlantillaArquetipoId(arquetipo, plantilla);
		this.idInterno = id;
	}
	
	public double getIdPlantilla(){
		return pk.getIdPlantilla();
	}
	
	public double getIdArquetipo(){
		return pk.getIdArquetipo();
	}
	
	public String getArquetipoNombre() {
		return pk.getArquetipoNombre();
	}
	
	public Arquetipo getArquetipo() {
		return pk.getArquetipo();
	}
	
	public Plantilla getPlantilla() {
		return pk.getPlantilla();
	}

	public PlantillaArquetipoId getpk() {
		return pk;
	}
}
