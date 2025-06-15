package NSP_TECH.LOGISTICA_ENVIOS.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name="PEDIDOS")
@AllArgsConstructor
@NoArgsConstructor

public class pedidos {
    @Id
    @Column(name = "ID_PEDIDO")
    private Long ID_PEDIDO;

    @OneToOne
    @JoinColumn(name = "ID_ENVIO")
    @JsonBackReference
    private envios envios;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private usuario usuario;


}
