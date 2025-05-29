package com.foodnet.Inventario.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name="Inventario")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInventario;

    @Column (nullable = false)
    private String insumos;

    @Column (nullable = false)
    private String producto;


}
