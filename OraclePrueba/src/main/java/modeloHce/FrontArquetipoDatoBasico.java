package modeloHce;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="SGP_DEF_ARQUETIPOS")
@Data
public class FrontArquetipoDatoBasico extends ArquetipoDatoBasico{

	@Column(name="ORDEN")
	private String orden;

	@Column(name="OBLIGATORIO")
	private String obligatorio;

	@Column(name="VER_NOMBRE")
	private String verNombre;

	@Column(name="NOMBRE_MOSTRADO")
	private String nomrbreMostrado;

	@Column(name="TITLE")
	private String titulo;

	@Column(name="CLASES_CSS")
	private String clasesCSS;

	@Column(name="ESTILOS_CSS")
	private String estilosCSS;

	@Column(name="MAXLENGTH")
	private String maxLenght;

	@Column(name="ENABLE_RTF")
	private String enableRTF;

	@Column(name="ENABLE_VALORES_PREVIOS")
	private double enableValoresPrevios;

	@Column(name="ENABLE_PREREDACTADOS")
	private double enablePreradactados;

	@Column(name="VER_EN_DETALLE")
	private double verDetalle;

	@Column(name="VER_EN_EDICION")
	private double verEdicion;

	@Column(name="VER_EN_DETALLE_SIN_INST")
	private double verDetalleSinInst;

	@Column(name="VER_EN_IMPRESION")
	private double verImpresion;

	@Column(name="VER_EN_IMPRESION_SIN_INST")
	private double verImpresionSinInst;
	
	@Column(name="PRE_HEADER_HTML")
	private double preHeaderHTML;

	@Column(name="POST_HEADER_HTML")
	private double postHeaderHTML;

	@Column(name="PRE_FOOTER_HTML")
	private double preFooterHTML;

	@Column(name="POST_FOOTER_HTML")
	private double postFooterHTML;

	@Column(name="OPTIONS_JS")
	private double opcionJS;	
}
