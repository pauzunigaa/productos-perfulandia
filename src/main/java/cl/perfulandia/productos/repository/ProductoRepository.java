package cl.perfulandia.productos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.perfulandia.productos.model.Producto;

//Repository – Conexión a la base de datos
//Aquí creas interfaces que le dicen a Spring cómo leer o guardar los datos en la base de datos.
//Sirve para: guardar y buscar datos automáticamente.

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
    List<Producto> findByCategoria_Nombre(String categoria);
    List<Producto> findByMarca_Nombre(String marca);
    
}
