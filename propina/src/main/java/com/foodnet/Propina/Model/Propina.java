package com.foodnet.Propina.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name="Propina")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Propina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_propina;

    @Column(nullable = false)
    private Integer propina;

    @Column(nullable = false)
    private Integer monto;

    @Column(nullable = false, precision = 2, scale = 2)
    private BigDecimal porcentaje;

}