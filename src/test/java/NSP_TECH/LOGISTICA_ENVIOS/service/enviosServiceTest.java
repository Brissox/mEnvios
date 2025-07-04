package NSP_TECH.LOGISTICA_ENVIOS.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import NSP_TECH.LOGISTICA_ENVIOS.model.envios;
import NSP_TECH.LOGISTICA_ENVIOS.repository.enviosRepository;
import NSP_TECH.LOGISTICA_ENVIOS.services.enviosServices;

public class enviosServiceTest {

    @Mock
    private enviosRepository enviorepository;
    
    @InjectMocks
    private enviosServices enviosservices;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }



    
    @Test
    public void testBuscarTodo(){
    java.util.List<envios> lista = new  ArrayList<>();

    envios envio1 = new envios();
    envios envio2 = new envios();

    envio1.setId_envio(11L);
    envio1.setEstado("estado");
    envio1.setFecha_entrega(LocalDateTime.now());
    envio1.setFecha_envio(LocalDateTime.now().minusDays(1));
    envio1.setId_pedido(11L);
    envio1.setNumero_guia(123123);
    envio1.setTransportista("bastian");

    envio2.setId_envio(12L);
    envio2.setEstado("estado");
    envio2.setFecha_entrega(LocalDateTime.now().minusHours(4));
    envio2.setFecha_envio(LocalDateTime.now().minusDays(1));
    envio2.setId_pedido(12L);
    envio2.setNumero_guia(1323123);
    envio2.setTransportista("Maryanne");
    

    lista.add(envio1);
    lista.add(envio2);

    when(enviorepository.findAll()).thenReturn(lista);

    java.util.List<envios> resultadoBusqueda = enviosservices.BuscarTodoEnvios();

    assertEquals(2,resultadoBusqueda.size());
    verify(enviorepository, times(1)).findAll();

}

    @Test
    public void testBuscarunenvio(){
    envios envio1 = new envios();

    envio1.setId_envio(11L);
    envio1.setEstado("estado");
    envio1.setFecha_entrega(LocalDateTime.now());
    envio1.setFecha_envio(LocalDateTime.now().minusDays(1));
    envio1.setId_pedido(11L);
    envio1.setNumero_guia(123123);
    envio1.setTransportista("bastian");

    when(enviorepository.findById(11L)).thenReturn(Optional.of(envio1));

    envios envioBuscado = enviosservices.BuscarUnEnvio(11L);
    assertEquals(11L,envioBuscado.getId_envio());
    verify(enviorepository, times(1)).findById(11L);

    }



    @Test
    public void testGuardarEnvio(){
        envios v = new envios();
        v.setEstado("estado");
        v.setFecha_entrega(LocalDateTime.now());
        v.setFecha_envio(LocalDateTime.now().minusDays(1));
        v.setId_envio(11L);
        v.setId_pedido(11L);
        v.setNumero_guia(123123);
        v.setTransportista("transportista");
        
        when(enviorepository.save(any())).thenReturn(v);

        envios enviosGuardados = enviosservices.GuardarEnvios(v);
        assertEquals("estado", enviosGuardados.getEstado());
        verify(enviorepository, times(1)).save(v);

    }


    @Test
    public void testEditarEnvio(){

        envios enviosO = new envios();
        enviosO.setId_envio(11L);
        enviosO.setNumero_guia(1);
        enviosO.setTransportista("Santiago");

        envios enviosE = new envios();
        enviosE.setId_envio(11L);
        enviosE.setNumero_guia(12);
        enviosE.setTransportista("Josue");


        when(enviorepository.save(any(envios.class))).thenReturn(enviosE);
        when(enviorepository.existsById(11L)).thenReturn(true);
        envios resultado = enviosservices.GuardarEnvios(enviosE);

        assertNotNull(resultado);
        assertEquals(11L, resultado.getId_envio());
        assertEquals(12, resultado.getNumero_guia());
        assertEquals("Josue", resultado.getTransportista());

        verify(enviorepository, times(1)).save(enviosE);
    }

    @Test
    public void testEliminarEnvio(){
        Long id = 11L;
        doNothing().when(enviorepository).deleteById(id);

        enviosservices.EliminarEnvio(11L);

        verify(enviorepository, times(1)).deleteById(id);

    }
}