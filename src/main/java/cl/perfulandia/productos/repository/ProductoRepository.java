package cl.perfulandia.productos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.perfulandia.productos.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
    List<Producto> findbyCategoria_Nombre(String categoria);
    List<Producto> finbyMarca_Nombre(String marca);
    
}
