package modeloHce;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="SGP_DEF_REL_ARQUET_DATOBASIC")
@AssociationOverrides({
	@AssociationOverride(name = "pk.arquetipo", joinColumns = @JoinColumn(name = "ID_ARQUETIPO")),
	@AssociationOverride(name = "pk.datobasico", joinColumns = @JoinColumn(name = "ID_DATOBASICO")) 
})
public class ArquetipoDatoBasico {
	@EmbeddedId
	private ArquetipoDatoBasicoId pk;
	
	@Column(name="ID_INTERNO")
	private double idInterno;
	
	public ArquetipoDatoBasico() {
		pk = new ArquetipoDatoBasicoId();
		this.idInterno = 0;
	}
	
	public ArquetipoDatoBasico(DatoBasico datoBasico, Arquetipo arquetipo, double id) {
		pk = new ArquetipoDatoBasicoId(arquetipo, datoBasico);
		this.idInterno = id;
	}
	
	public double getIdDatoBasico(){
		return pk.getIdDatoBasico();
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
	
	public DatoBasico getDatoBasico() {
		return pk.getDatoBasico();
	}

	public ArquetipoDatoBasicoId getpk() {
		return pk;
	}
}
