package NSP_TECH.LOGISTICA_ENVIOS.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor


public class usuario {


    private Long id_usuario;
    private String nombre;
    private String apellido_paterno;
    private String correo;

}
