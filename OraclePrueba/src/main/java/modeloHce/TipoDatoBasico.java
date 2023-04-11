package modeloHce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SGP_TIPO_DATOBASICO")
public class TipoDatoBasico {
	
	@Id
	@Column(name="TIPO_BASICO", unique = true, nullable = false, precision = 10)
	int id;
	
	@Column(name="DESCRIPCION")
	String descripcion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
