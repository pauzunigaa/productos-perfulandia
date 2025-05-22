package cl.perfulandia.productos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.perfulandia.productos.model.Marca;
import cl.perfulandia.productos.service.MarcaService;

@RestController
@RequestMapping ("/marcas")
public class MarcaController {

@Autowired
private MarcaService marcaService;
@PostMapping
public Marca guardarMarca(@RequestBody Marca marca){
    return marcaService.guardarMarca(marca);
}

}
