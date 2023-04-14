package modeloHce;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="SGP_DEF_LISTAVALORES_DETALLE")
@Data
public class ListaValoresDetalle extends ListaValores{
	
    @Id
	@Column(name="ID_INTERNO", unique = true, nullable = false, precision = 10)
	private double idInterno;

    @Column(name="VALOR")
	private String valor;

    @Column(name="DESCRIPCION")
	private String descripcionDetalle;

    @Column(name="ORDEN")
	private String orden;

    @Column(name="VALOR_DEFECTO")
	private String valorDefecto;

    @Column(name="CAMPO_HL7")
	private String campoHL7;

	public ListaValoresDetalle(double idLista, String descripcion, double idInterno, String valor, String descripcionDetalle,  String orden, String valorDefecto, String campoHL7){
		super(idLista, descripcion);
		this.idInterno = idInterno;
		this.valor = valor;
		this.descripcionDetalle = descripcionDetalle;
		this.orden = orden;
		this.valorDefecto = valorDefecto;
		this.campoHL7 = campoHL7;
	}
}
