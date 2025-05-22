package cl.perfulandia.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.perfulandia.productos.model.Producto;
import cl.perfulandia.productos.service.ProductoService;

@RestController
@RequestMapping ("/productos")
public class ProductoController {

@Autowired //primero instancio el servicio con esta anotacion
private ProductoService productoService ;
@GetMapping
public List<Producto>listar() { //listar todos los productos
return productoService.listarTodos();
}

//GUARDAR PRODUCTO
@PostMapping // RECIBE PETICIONES DE TIPO POST
public Producto guardarProducto(@RequestBody Producto producto){ // todo lo del cuerpo de peticion se lo paso a la variable producto
    return productoService.guardarProducto(producto);
}

}
