package modeloHce;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Embeddable
public class ArquetipoDatoBasicoId implements Serializable{
	
	@MapsId
	@ManyToOne
	private Arquetipo arquetipo;
	
	@MapsId
	@ManyToOne
    private DatoBasico datobasico;
	
	public ArquetipoDatoBasicoId() {
		arquetipo = new Arquetipo();
		datobasico = new DatoBasico();
	}
	
	public ArquetipoDatoBasicoId(Arquetipo arquetipo, DatoBasico datobasico) {
		this.arquetipo = arquetipo;
		this.datobasico = datobasico;
	}
	
	public double getIdDatoBasico() {
		return datobasico.getId();
	}
	
	public double getIdArquetipo() {
		return arquetipo.getId();
	}
	
	public String getArquetipoNombre(){
		return arquetipo.getDescripcion();
	}
	
	public Arquetipo getArquetipo() {
		return arquetipo;
	}
	
	public DatoBasico getDatoBasico() {
		return datobasico;
	}
}	
	