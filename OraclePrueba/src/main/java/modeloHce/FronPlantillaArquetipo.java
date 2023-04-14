package modeloHce;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="HCE_FRONT_PLANT_ARQUET")
@Data
public class FronPlantillaArquetipo extends PlantillaArquetipo{

	@Column(name="ORDEN")
	private int orden;

	@Column(name="OBLIGATORIO")
	private char obligatorio;

	@Column(name="NOMBRE_MOSTRADO")
	private String nomrbreMostrado;
    
	@Column(name="VER_NOMBRE")
	private char verNombre;

	@Column(name="VER_EN_DETALLE")
	private char verDetalle;

	@Column(name="VER_EN_DETALLE_SIN_INST")
	private char verDetalleSinInst;

	@Column(name="VER_EN_EDICION")
	private char verEdicion;

	@Column(name="VER_EN_IMPRESION")
	private char verImpresion;

	@Column(name="VER_EN_IMPRESION_SIN_INST")
	private char verImpresionSinInst;
	
	@Column(name="CLASES_CSS")
	private String clasesCSS;

	@Column(name="ESTILOS_CSS")
	private String estilosCSS;

	@Column(name="PRE_HEADER_HTML")
	private double preHeaderHTML;

	@Column(name="POST_HEADER_HTML")
	private double postHeaderHTML;

	@Column(name="PRE_FOOTER_HTML")
	private double preFooterHTML;

	@Column(name="POST_FOOTER_HTML")
	private double postFooterHTML;  
}
