package cl.perfulandia.productos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.perfulandia.productos.model.Categoria;
import cl.perfulandia.productos.repository.CategoriaRepository;

@Service
public class CategoriaService {

@Autowired
private CategoriaRepository categoriaRepository;

public Categoria guardarCategoria(Categoria categoria){
    return categoriaRepository.save(categoria);}

}

