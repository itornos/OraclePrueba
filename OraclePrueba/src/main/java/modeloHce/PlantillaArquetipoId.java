package modeloHce;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Data;

@Embeddable
@Data
public class PlantillaArquetipoId implements Serializable{
	
	@MapsId
	@ManyToOne
	private Arquetipo arquetipo;
	
	@MapsId
	@ManyToOne
    private Plantilla plantilla;
	
	public PlantillaArquetipoId() {
		arquetipo = new Arquetipo();
		plantilla = new Plantilla();
	}
	
	public PlantillaArquetipoId(Arquetipo ar, Plantilla plan) {
		arquetipo = ar;
		plantilla = plan;
	}
	
	public double getIdPlantilla() {
		return plantilla.getId();
	}
	
	public double getIdArquetipo() {
		return arquetipo.getId();
	}
	
	public String getArquetipoNombre(){
		return arquetipo.getNombre();
	}
}	
	