package NSP_TECH.LOGISTICA_ENVIOS.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class pedidos {

    private Long ID_USUARIO;
    private char ESTADO;
    private int SUBTOTAL;
    private Date FECHA_PEDIDO;
    private int METODO_PAGO;
    private String DIRECCION_ENVIO;
    private Long ID_SUCURSAL;
    private Long ID_ENVIO;

}
