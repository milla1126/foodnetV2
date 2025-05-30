package com.foodnet.Reporte_Sueldo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "ReporteSueldo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteSueldo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reporte_sueldo;

    @Column(nullable = false)
    private String trabajador;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal sueldoBase;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal propinas;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal sueldoTotal;

    @Column(nullable = false)
    private String periodo;
}

