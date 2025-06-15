package NSP_TECH.LOGISTICA_ENVIOS.DTO;

import java.sql.Timestamp;

import NSP_TECH.LOGISTICA_ENVIOS.model.envios;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class envioUsuarioDTO {
    private Long idEnvio;
    private String estado;
    private String transportista;
    private int numeroGuia;
    private String nombreUsuario;
    private String correoUsuario;
    private Timestamp FECHA_ENVIO;
    private Timestamp FECHA_ENTREGA;
    private String ESTADO;


    public envioUsuarioDTO(envios envio) {
        this.idEnvio = envio.getID_ENVIO();
        this.estado = envio.getESTADO();
        this.transportista = envio.getTRANSPORTISTA();
        this.numeroGuia = envio.getNUMERO_GUIA();
        this.nombreUsuario = envio.getPedido().getUsuario().getNombre();
        this.correoUsuario = envio.getPedido().getUsuario().getCorreo();
        this.FECHA_ENVIO = envio.getFECHA_ENVIO();
        this.FECHA_ENTREGA = envio.getFECHA_ENTREGA();
        this.ESTADO = envio.getESTADO();
    }

}
