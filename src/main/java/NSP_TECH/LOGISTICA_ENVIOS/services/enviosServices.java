package NSP_TECH.LOGISTICA_ENVIOS.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import NSP_TECH.LOGISTICA_ENVIOS.DTO.envioUsuarioDTO;
import NSP_TECH.LOGISTICA_ENVIOS.model.envios;
import NSP_TECH.LOGISTICA_ENVIOS.repository.enviosRepository;
import jakarta.transaction.Transactional;


@Service
@Transactional
@SpringBootApplication
public class enviosServices {

@Autowired
    private enviosRepository enviosrepository;

    public List<envioUsuarioDTO> listarEnviosConUsuarios() {
        return enviosrepository.findAll().stream()
            .map(envioUsuarioDTO::new)
            .collect(Collectors.toList());
    }

    public envios BuscarUnEnvio(Long ID_ENVIO){
        return enviosrepository.findById(ID_ENVIO).get();

    }

    
    public envios GuardarEnvios(envios envios){
        return enviosrepository.save(envios);

    }

    

}
