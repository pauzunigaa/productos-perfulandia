package cl.perfulandia.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cl.perfulandia.productos.model.Marca;
import cl.perfulandia.productos.service.MarcaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @Operation(summary = "Guarda una marca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Marca guardada exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Marca.class))),
            @ApiResponse(responseCode = "500", description = "La marca no se ha guardado, intente  nuevamente...") })

    @PostMapping // RECIBE PETICIONES DE TIPO POST
    public Marca guardarMarca(@RequestBody Marca marca) {
        return marcaService.guardarMarca(marca);
    }

    @Operation(summary = "Obtiene el listado de todas las marcas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida de forma exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Marca.class))),
            @ApiResponse(responseCode = "400", description = "Listado de Marcas no encontrado") })
    @GetMapping // RECIBE PETICIONES DE TIPO GET
    public List<Marca> listar() {
        return marcaService.listarTodos();
    }

}