package cl.perfulandia.productos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.perfulandia.productos.model.Categoria;
import cl.perfulandia.productos.service.CategoriaService;

@RestController
@RequestMapping ("/categorias")
public class CategoriaController {

@Autowired
private CategoriaService categoriaService;
@PostMapping
public Categoria guardarCategoria(@RequestBody Categoria categoria){
    return categoriaService.guardarCategoria(categoria);
}
}
