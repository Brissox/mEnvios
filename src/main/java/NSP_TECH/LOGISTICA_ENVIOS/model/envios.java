package NSP_TECH.LOGISTICA_ENVIOS.model;

import java.sql.Timestamp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="ENVIOS")
@AllArgsConstructor
@NoArgsConstructor


public class envios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_ENVIO")
    @Schema(description="aa")
    private Long id_envio;

    @Column(name="TRANSPORTISTA",nullable=false,length=50)
    @Schema(description="aa")
    private String transportista;

    @Column(name="NUMERO_GUIA",nullable=false,precision=10)
    @Schema(description="aa")
    private int numero_guia;

    @Column(name="FECHA_ENVIO",nullable=false)
    @Schema(description="aa")
    private Timestamp fecha_envio;

    @Column(name="FECHA_ENTREGA",nullable=true)
    @Schema(description="aa")
    private Timestamp fecha_entrega;

    @Column(name="ESTADO",nullable=false,length=20)
    @Schema(description="aa")
    private String estado;
    
    @Column(name = "ID_PEDIDO",nullable=false,precision=10)
    @Schema(description="aa")
    private Long id_pedido;


}
