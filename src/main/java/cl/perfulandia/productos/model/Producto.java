package cl.perfulandia.productos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto")
@Data   //Getter and Setter 
@NoArgsConstructor //Constructor sin parametros
@AllArgsConstructor // Constructor con parametros



// Model – Los datos
//Aquí defines las clases que representan las cosas del mundo real
//Sirve para: decirle al sistema qué datos existen.

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // incremen
    private Integer id;
    private String nombre;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;
    private Double precio;
    private boolean disponible;
}
