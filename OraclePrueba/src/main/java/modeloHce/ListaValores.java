package modeloHce;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="SGP_DEF_LISTAVALORES")
@Data
public class ListaValores {

	@Id
	@Column(name="ID_LISTA", unique = true, nullable = false, precision = 10)
	private double id;
	
	@Column(name="DESCRIPCION")
	private String descripcion;

	@OneToMany(mappedBy = "listaValores", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<DatoBasico> listaValores;

	public ListaValores(double id, String descripcion){
		this.id = id;
		this.descripcion = descripcion;
	}
}
