package cl.perfulandia.productos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cl.perfulandia.productos.model.Categoria;
import cl.perfulandia.productos.model.Marca;
import cl.perfulandia.productos.model.Producto;
import cl.perfulandia.productos.repository.ProductoRepository;

@SpringBootTest
public class ProductoServiceTest {

    @Autowired
    private ProductoService productoService;

    @MockBean
    private ProductoRepository productoRepository;

    @Test
    public void testGuardarProducto() {
        Producto producto = new Producto();
        producto.setId(1L);
        producto.setNombre("Lápiz Labial");
        producto.setMarca(new Marca());
        producto.setCategoria(new Categoria());

        // Simula el comportamiento del save y findById
        when(productoRepository.save(producto)).thenReturn(producto);
        when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));

        Optional<Producto> guardado = productoService.guardarProducto(producto);

        assertTrue(guardado.isPresent());
        assertEquals("Lápiz Labial", guardado.get().getNombre());
    }

    @Test
    public void testListarTodos() {
        Producto producto1 = new Producto();
        producto1.setId(1L);
        producto1.setNombre("Colonia");

        when(productoRepository.findAll()).thenReturn(List.of(producto1));

        List<Producto> lista = productoService.listarTodos();

        assertNotNull(lista);
        assertEquals(1, lista.size());
        assertEquals("Colonia", lista.get(0).getNombre());
    }

    @Test
    public void testBuscarPorId() {
        Producto producto = new Producto();
        producto.setId(2L);
        producto.setNombre("Desodorante");

        when(productoRepository.findById(2L)).thenReturn(Optional.of(producto));

        Optional<Producto> resultado = productoService.buscarPorId(2L);

        assertTrue(resultado.isPresent());
        assertEquals("Desodorante", resultado.get().getNombre());
    }

    @Test
    public void testEliminar() {
        Long id = 3L;

        doNothing().when(productoRepository).deleteById(id);

        productoService.eliminar(id);

        verify(productoRepository, times(1)).deleteById(id);
    }
}
