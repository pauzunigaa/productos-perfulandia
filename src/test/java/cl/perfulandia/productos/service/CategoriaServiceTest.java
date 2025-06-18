package cl.perfulandia.productos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cl.perfulandia.productos.model.Categoria;
import cl.perfulandia.productos.repository.CategoriaRepository;

@SpringBootTest
public class CategoriaServiceTest {

@Autowired
private CategoriaService categoriaService;

@MockBean
private CategoriaRepository categoriaRepository;

@Test
public void testGuardarCategoria(){
Categoria categoria = new Categoria(1L, "cremas");

// Define el comportamiento del mock: cuando se llame a save(), devuelve la categoria proporcionada.
when(categoriaRepository.save(categoria)).thenReturn(categoria);


// Llama al método guardarCategoria() del servicio.
Categoria saved = categoriaService.guardarCategoria(categoria);


// Verifica que la categoria guardada no sea nula "cremas" y que su nombre coincida con el nombre esperado.
assertNotNull(saved);
assertEquals("cremas", saved.getNombre());

}
 

@Test

public void testListarTodos(){
when(categoriaRepository.findAll()).thenReturn(List.of(new Categoria(1L, "cremas")));

List<Categoria> categorias =categoriaService.listarTodos();

assertNotNull(categorias);
assertEquals(1, categorias.size());
}

}
