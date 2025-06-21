package NSP_TECH.LOGISTICA_ENVIOS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import NSP_TECH.LOGISTICA_ENVIOS.model.envios;
import NSP_TECH.LOGISTICA_ENVIOS.repository.enviosRepository;
import jakarta.transaction.Transactional;


@Service
@Transactional

public class enviosServices {

    @Autowired
    private enviosRepository enviosrepository;

    public List<envios> BuscarTodoEnvios(){
        return enviosrepository.findAll();
    }
        public envios BuscarUnEnvio(Long ID_ENVIO){
        return enviosrepository.findById(ID_ENVIO).get();
    }

    public envios GuardarEnvios(envios envios){
        return enviosrepository.save(envios);

    }

}

/*  /*public List<envios> listarEnvios() {
        return enviosrepository.findAll().stream()
            .collect(Collectors.toList());
    }
    public List<envioUsuarioDTO> listarEnviosConUsuarios() {
        return enviosrepository.findAll().stream()
            .map(envioUsuarioDTO::new)
            .collect(Collectors.toList());
    }*/

