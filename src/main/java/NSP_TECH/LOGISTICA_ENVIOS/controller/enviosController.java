package NSP_TECH.LOGISTICA_ENVIOS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import NSP_TECH.LOGISTICA_ENVIOS.DTO.envioUsuarioDTO;
import NSP_TECH.LOGISTICA_ENVIOS.model.envios;
import NSP_TECH.LOGISTICA_ENVIOS.services.enviosServices;



@RestController
@RequestMapping("api/v1/Envios")
public class enviosController {

    @Autowired
    private enviosServices enviosservice;

    @GetMapping
    public ResponseEntity<List<envioUsuarioDTO>> listar() {
        return ResponseEntity.ok(enviosservice.listarEnviosConUsuarios());
    }

    @GetMapping("/{ID_ENVIO}")
    public ResponseEntity<?> BuscarProducto(@PathVariable Long ID_ENVIO){

        try {
            envios enviosBuscado = enviosservice.BuscarUnEnvio(ID_ENVIO);
            return ResponseEntity.ok(enviosBuscado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentran Usuario");
        }
    }

}
