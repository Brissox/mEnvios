package NSP_TECH.LOGISTICA_ENVIOS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name="usuarios")
@AllArgsConstructor
@NoArgsConstructor


public class usuario {

    @Id
    private Long id_usuario;
    private String nombre;
    private String apellido_paterno;
    private String correo;

}
