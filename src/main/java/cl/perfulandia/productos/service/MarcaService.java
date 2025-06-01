package cl.perfulandia.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.perfulandia.productos.model.Marca;
import cl.perfulandia.productos.repository.MarcaRepository;

@Service
public class MarcaService {

@Autowired
private MarcaRepository marcaRepository;

public Marca guardarMarca(Marca marca){
    return marcaRepository.save(marca);}

 public List<Marca> listarTodos() {
        return marcaRepository.findAll();
    }    
}