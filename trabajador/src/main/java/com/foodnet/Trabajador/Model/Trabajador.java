package com.foodnet.Trabajador.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Trabajador")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_trabajador;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String rol;

    @Column(nullable = false)
    private String turno;
}
