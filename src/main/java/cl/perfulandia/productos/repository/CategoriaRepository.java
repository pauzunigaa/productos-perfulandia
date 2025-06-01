package cl.perfulandia.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.perfulandia.productos.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Long>{

}