package NSP_TECH.LOGISTICA_ENVIOS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentran el envio");
        }
    }

    
    @PostMapping
    public ResponseEntity<?> GuardarEnvio(@RequestBody envios envioGuardar){
    try {
            envios enviosRegistrar = enviosservice.GuardarEnvios(envioGuardar);
            return ResponseEntity.ok(enviosRegistrar);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("No se puede registrar el envio");
    }
    }
    @PutMapping("/{ID_ENVIO}") //SOLO PERMITE ACTUALIZAR ESCRIBIENDO TODOS LOS DATOS
        
    public ResponseEntity<?> ActualizarEnvio(@PathVariable Long ID_ENVIO, @RequestBody envios enviosActualizar){
        try {
            envios enviosActualizado = enviosservice.BuscarUnEnvio(ID_ENVIO);
            enviosActualizado.setID_ENVIO(enviosActualizar.getID_ENVIO());
            enviosActualizado.setNUMERO_GUIA(enviosActualizar.getNUMERO_GUIA());
            enviosActualizado.setESTADO(enviosActualizar.getESTADO());
            enviosActualizado.setFECHA_ENTREGA(enviosActualizar.getFECHA_ENTREGA());
            enviosActualizado.setFECHA_ENVIO(enviosActualizar.getFECHA_ENVIO());
            enviosActualizado.setPedido(enviosActualizar.getPedido());
            enviosActualizado.setTRANSPORTISTA(enviosActualizar.getTRANSPORTISTA());
            enviosservice.GuardarEnvios(enviosActualizado);
            return ResponseEntity.ok(enviosActualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El envio no esta registrado");
        }
    }
    



}
