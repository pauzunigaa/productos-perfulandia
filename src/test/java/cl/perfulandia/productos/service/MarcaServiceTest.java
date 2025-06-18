package cl.perfulandia.productos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cl.perfulandia.productos.model.Marca;
import cl.perfulandia.productos.repository.MarcaRepository;

@SpringBootTest
public class MarcaServiceTest {


@Autowired
private MarcaService marcaService;

@MockBean
private MarcaRepository marcaRepository;

@Test

public void testGuardarMarca(){
Marca marca = new Marca(1L,"Hugo Boss");

// Define el comportamiento del mock: cuando se llame a save(),devuelve el inventario.
when (marcaRepository.save(marca)).thenReturn(marca);

// Llama al método guardarStock() del servicio.
Marca saved = marcaService.guardarMarca(marca);

// Verifica que inventario guarda un stock y no este vacio
assertNotNull(saved);
assertEquals("Hugo Boss",saved.getNombre());

}

@Test 

public void testListarTodos(){
when(marcaRepository.findAll()).thenReturn(List.of(new Marca(1L,"Hugo Boss")));

List <Marca> marcas= marcaService.listarTodos();

assertNotNull(marcas);
assertEquals(1,marcas.size());

}
}


