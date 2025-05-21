package cl.perfulandia.productos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.perfulandia.productos.model.Producto;
import cl.perfulandia.productos.repository.ProductoRepository;

@Service
public class ProductoService {

@Autowired
private ProductoRepository productoRepository;

// Método Obtener producto
public List<Producto> obtenerProducto(){
return productoRepository.findAll();
}

// Save : Guarda el producto
public Producto guardarProducto(Producto producto){ 
    return productoRepository.save(producto);}

// Método Listar todos los productos
public List<Producto> listarTodos(Producto producto){
    return productoRepository.findAll();
}

// BUSCAR POR ID

public Optional<Producto> buscarporId(Integer id){
    return productoRepository.findById(id);
}

}
