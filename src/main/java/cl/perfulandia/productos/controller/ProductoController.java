package cl.perfulandia.productos.controller;

import cl.perfulandia.productos.assemblers.ProductoModelAssembler;
import cl.perfulandia.productos.model.Producto;
import cl.perfulandia.productos.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController // Controlador REST
@RequestMapping("/api/productos") // Ruta base para este recurso

public class ProductoController {

    @Autowired
    private ProductoModelAssembler assembler;

    @Autowired
    private ProductoService productoService;
    public Object listarProductos;

    @Operation(summary = "Guarda un producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Producto guardado exitosamente", 
            content = @Content(mediaType = "application/json", 
            schema = @Schema(implementation = Producto.class))),
            @ApiResponse(responseCode = "500", description = "El producto no se ha podido guardar,intente nuevamente...") })

    @PostMapping // RECIBE PETICIONES DE TIPO POST
    public Optional<Producto> guardarProducto(@RequestBody Producto producto) { // todo lo del cuerpo de petición se lo
                                                                                // paso a la // variable producto
        return productoService.guardarProducto(producto);
    }

    @Operation(summary = "Obtiene el listado de todos los Productos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida en forma exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Producto.class))),
            @ApiResponse(responseCode = "404", description = "Listado de productos no encontrado") })

    @GetMapping // RECIBE PETICIONES DE TIPO GET
    public List<Producto> listarProductos() { // Devuelve todos los productos
        return productoService.listarTodos();
    }

    @Operation(summary = "Obtiene un producto por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ID Producto encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Producto.class))),
            @ApiResponse(responseCode = "404", description = "ID no encontrado")
    })
    @GetMapping("/{id}") // GET POR ID
    public EntityModel<Producto> obtenerProductoPorId(@PathVariable Long id) {
        Producto producto = productoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return assembler.toModel(producto); // Busca un producto por su ID
    }

    @Operation(summary = "Elimina un producto por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto Eliminado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Producto.class))),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado.")
    })
    @DeleteMapping("/{id}") // PETICIÓN DELETE
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminar(id); // Elimina el producto por ID
        return ResponseEntity.noContent().build();
    }
}
