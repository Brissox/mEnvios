package NSP_TECH.LOGISTICA_ENVIOS.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private Long ID_ENVIO;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private pedidos pedido;

    @Column(name="TRANSPORTISTA")
    private String TRANSPORTISTA;

    @Column(name="NUMERO_GUIA")
    private int NUMERO_GUIA;

    @Column(name="FECHA_ENVIO")
    private Timestamp FECHA_ENVIO;

    @Column(name="FECHA_ENTREGA")
    private Timestamp FECHA_ENTREGA;

    @Column(name="ESTADO")
    private String ESTADO;


}
