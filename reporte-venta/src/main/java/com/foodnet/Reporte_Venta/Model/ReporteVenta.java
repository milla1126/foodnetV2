package com.foodnet.Reporte_Venta.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ReporteVenta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reporte_venta;

    @Column(nullable = false)
    private String producto;

    @Column(nullable = false)
    private int cantidadVendida;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalVentas;

    @Column(nullable = false)
    private LocalDate fecha;
}

