package cl.perfulandia.productos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cl.perfulandia.productos.model.Inventario;
import cl.perfulandia.productos.model.Producto;
import cl.perfulandia.productos.repository.InventarioRepository;

@SpringBootTest
public class InventarioServiceTest {

@Autowired
private InventarioService inventarioService;

@MockBean
private InventarioRepository inventarioRepository;

@Test

public void testGuardarStock(){
Producto producto = new Producto();
Inventario inventario = new Inventario(1L,producto,10);

// Define el comportamiento del mock: cuando se llame a save(),devuelve el inventario.
when (inventarioRepository.save(inventario)).thenReturn(inventario);

// Llama al método guardarStock() del servicio.
Inventario saved = inventarioService.guardarStock(inventario);

// Verifica que inventario guarda un stock y no este vacio
assertNotNull(saved);
assertEquals(10,saved.getStock());

}

@Test 

public void testListarTodos(){
Producto producto = new Producto();
when(inventarioRepository.findAll()).thenReturn(List.of(new Inventario(1L,producto,10)));

List <Inventario> inventario=inventarioService.listarTodos();

assertNotNull(inventario);
assertEquals(1,inventario.size());

}
}

