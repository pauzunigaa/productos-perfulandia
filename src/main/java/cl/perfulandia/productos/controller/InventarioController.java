package cl.perfulandia.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.perfulandia.productos.model.Inventario;
import cl.perfulandia.productos.service.InventarioService;

@RestController
@RequestMapping ("/api/inventarios")
public class InventarioController {

@Autowired
private InventarioService inventarioService;
@PostMapping
public Inventario guardarStock(@RequestBody Inventario inventario){
    return inventarioService.guardarStock(inventario);
}
@GetMapping
public List <Inventario>listar(){
    return inventarioService.listarTodos();
}

}
