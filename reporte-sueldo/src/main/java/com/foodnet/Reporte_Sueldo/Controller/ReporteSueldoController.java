package com.foodnet.Reporte_Sueldo.Controller;

import com.foodnet.Reporte_Sueldo.Model.ReporteSueldo;
import com.foodnet.Reporte_Sueldo.Service.ReporteSueldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reportes-sueldo")
public class ReporteSueldoController {

    @Autowired
    private ReporteSueldoService reporteSueldoService;

    @GetMapping
    public List<ReporteSueldo> listar() {
        return reporteSueldoService.listarReportes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReporteSueldo> obtener(@PathVariable Integer id) {
        return reporteSueldoService.obtenerReporte(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ReporteSueldo crear(@RequestBody ReporteSueldo reporte) {
        return reporteSueldoService.guardarReporte(reporte);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        reporteSueldoService.eliminarReporte(id);
    }
}

