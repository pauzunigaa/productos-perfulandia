package cl.perfulandia.productos.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.perfulandia.productos.model.Categoria;
import cl.perfulandia.productos.service.CategoriaService;
import org.springframework.http.MediaType;

@WebMvcTest(CategoriaController.class)
public class CategoriaControllerTest {

    @Autowired
    private MockMvc mockMvc; //reemplaza objetos con simulaciones

    @MockBean
    private CategoriaService categoriaService;

    @Autowired
    private ObjectMapper objectMapper;

    private Categoria categoria;

    @BeforeEach
    void setUp() {
        // Configura un objeto categoria de ejemplo antes de cada prueba
        categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNombre("cremas");
    }

    @Test

    public void testCrearCategoria() throws Exception {
        // Define el comportamiento del mock: cuando se llame a save(), devuelve el
        // objeto Categoria
        when(categoriaService.guardarCategoria(any(Categoria.class))).thenReturn(categoria);

        // Realiza una petición POST a /api/categorias con el objeto Categoria en
        // formato JSON y verifica que la respuesta sea correcta
        mockMvc.perform(post("/api/categorias")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(categoria))) // Convierte el objeto Categoria a JSON
                .andExpect(status().isOk()) // Verifica que el estado de la respuesta sea 200 OK
                .andExpect(jsonPath("$.nombre").value("cremas")); // Verifica que el nombre del objeto devuelto sea
                                                                  // cremas"

    }

    @Test
    public void testListar() throws Exception {
        // Define el comportamiento del mock: cuando se llame a findAll(), devuelve una
        // lista con una Categoria
        when(categoriaService.listarTodos()).thenReturn(List.of(categoria));

        // Realiza una petición GET a /api/categorias y verifica que la respuesta sea
        // correcta
        mockMvc.perform(get("/api/categorias"))
                .andExpect(status().isOk()) // Verifica que el estado de la respuesta sea 200 OK
                .andExpect(jsonPath("$[0].nombre").value("cremas")); // Verifica que el primer elemento tenga el nombre
                                                                     // "Juan Pérez"
    }

}
