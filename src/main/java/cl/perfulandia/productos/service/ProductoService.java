package cl.perfulandia.productos.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.perfulandia.productos.model.Producto;
import cl.perfulandia.productos.repository.ProductoRepository;

//Service – La lógica del negocio
//Aquí haces los cálculos o reglas de la app.
//Sirve para: hacer todo el “cerebro” de la app (precios, reglas, validaciones).
//Aquí decides cómo se gestionan los productos.

@Service
public class ProductoService {

    @Autowired //crea una instancia automatica manejada por spring
    private ProductoRepository productoRepository;

    // Save : Guarda el producto
    // Guarda un nuevo producto en la base de datos.

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Método Listar todos los productos
    // Devuelve todos los productos guardados en la base de datos.
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    // BUSCAR POR ID
    // Busca un producto por su id
    public Optional<Producto> buscarPorId(Long id) {
        return productoRepository.findById(id);
    }

    // Eliminar
    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}
