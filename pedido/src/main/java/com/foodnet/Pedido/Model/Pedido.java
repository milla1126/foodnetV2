package com.foodnet.Pedido.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Pedidos")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Pedido;

    @Column (nullable = false)
    private int mesa;

    @Column(nullable = false)
    private String Pedido;

}