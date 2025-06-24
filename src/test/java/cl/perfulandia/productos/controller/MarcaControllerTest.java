package cl.perfulandia.productos.controller;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.perfulandia.productos.model.Marca;
import cl.perfulandia.productos.service.MarcaService;

@WebMvcTest(MarcaController.class)
public class MarcaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MarcaService marcaService;

    @Autowired 
    private ObjectMapper objectMapper;

    private Marca marca;

    @BeforeEach
    void setUp(){
        //configura un objeto marca de ejemplo antes de cada prueba
        marca = new Marca();
        marca.setId(1L);
        marca.setNombre("Dior");
    }
}
