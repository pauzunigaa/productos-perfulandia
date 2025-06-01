package cl.perfulandia.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.perfulandia.productos.model.Inventario;
import cl.perfulandia.productos.repository.InventarioRepository;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public Inventario guardarStock(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

     public List<Inventario> listarTodos() {
        return inventarioRepository.findAll();
    }

}
