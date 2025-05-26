package cl.perfulandia.productos.controller;

import cl.perfulandia.productos.model.Producto;
import cl.perfulandia.productos.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Controlador REST
@RequestMapping("/api/productos") // Ruta base para este recurso

public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping // RECIBE PETICIONES DE TIPO POST
    public Optional<Producto> guardarProducto(@RequestBody Producto producto) { // todo lo del cuerpo de petición se lo paso a la // variable producto
        return productoService.guardarProducto(producto);
    }

    @GetMapping // RECIBE PETICIONES DE TIPO GET
    public List<Producto> listarProductos() { // Devuelve todos los productos
        return productoService.listarTodos();
    }

    @GetMapping("/{id}") // GET POR ID
    public Optional<Producto> obtenerProductoPorId(@PathVariable Long id) {
        return productoService.buscarPorId(id); // Busca un producto por su ID
    }

    @DeleteMapping("/{id}") // PETICIÓN DELETE
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminar(id); // Elimina el producto por ID
    }
}
