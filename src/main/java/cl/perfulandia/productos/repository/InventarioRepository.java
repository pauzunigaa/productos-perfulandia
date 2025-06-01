package cl.perfulandia.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.perfulandia.productos.model.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario,Long> {

}
