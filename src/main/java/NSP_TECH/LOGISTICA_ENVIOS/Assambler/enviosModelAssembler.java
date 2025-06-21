package NSP_TECH.LOGISTICA_ENVIOS.Assambler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;

import NSP_TECH.LOGISTICA_ENVIOS.controller.enviosController;
import NSP_TECH.LOGISTICA_ENVIOS.model.envios;

@Component
public class enviosModelAssembler implements RepresentationModelAssembler<envios, EntityModel<envios>>{

    @Override
    public EntityModel<envios> toModel(envios e) {
        return EntityModel.of(
            e,
            linkTo(methodOn(enviosController.class).BuscarEnvio(e.getID_ENVIO())).withRel("LINKS"),
            linkTo(methodOn(enviosController.class).ListarTodo()).withRel("todas-los-envios"),
            linkTo(methodOn(enviosController.class).ActualizarEnvio(e.getID_ENVIO(), e)).withRel("actualiza-un-envio")
        );
    }

}
/* linkTo(methodOn(enviosController.class).EliminarEnvio(p.getID_PRODUCTO())).withRel("elimina-una-venta"), */