package cl.perfulandia.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.perfulandia.productos.model.Categoria;
import cl.perfulandia.productos.service.CategoriaService;

@RestController
@RequestMapping ("/api/categorias")
public class CategoriaController {

@Autowired
private CategoriaService categoriaService;
@PostMapping //RECIBE PETICIONES DE TIPO POST
public Categoria guardarCategoria(@RequestBody Categoria categoria){
    return categoriaService.guardarCategoria(categoria);
}
@GetMapping
public List <Categoria>listar(){
    return categoriaService.listarTodos();
}

}