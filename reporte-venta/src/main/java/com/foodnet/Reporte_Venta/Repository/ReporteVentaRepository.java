package com.foodnet.Reporte_Venta.Repository;

import com.foodnet.Reporte_Venta.Model.ReporteVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReporteVentaRepository extends JpaRepository<ReporteVenta, Integer> {
}

