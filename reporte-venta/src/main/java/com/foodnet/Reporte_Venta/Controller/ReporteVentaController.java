package com.foodnet.Reporte_Venta.Controller;

import com.foodnet.Reporte_Venta.Model.ReporteVenta;
import com.foodnet.Reporte_Venta.Service.ReporteVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reportes-venta")
public class ReporteVentaController {

    @Autowired
    private ReporteVentaService reporteVentaService;

    @GetMapping
    public List<ReporteVenta> listar() {
        return reporteVentaService.listarReportes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReporteVenta> obtener(@PathVariable Integer id) {
        return reporteVentaService.obtenerReporte(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ReporteVenta crear(@RequestBody ReporteVenta reporte) {
        return reporteVentaService.guardarReporte(reporte);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        reporteVentaService.eliminarReporte(id);
    }
}
