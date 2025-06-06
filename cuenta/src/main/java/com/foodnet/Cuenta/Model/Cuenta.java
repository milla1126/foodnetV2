package com.foodnet.Cuenta.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table (name="Cuenta")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false )
    private String usuario;

    @Column (nullable = false)
    private int contrasena;

    @Column (nullable = false)
    private String roles;

}


