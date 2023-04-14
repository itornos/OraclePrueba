package modeloHce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="SGP_TIPO_DATOBASICO")
@Data
public class TipoDatoBasico {
	
	@Id
	@Column(name="TIPO_BASICO", unique = true, nullable = false, precision = 10)
	int id;
	
	@Column(name="DESCRIPCION")
	String descripcion;
}
