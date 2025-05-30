package com.foodnet.Reporte_Venta.Service;

import com.foodnet.Reporte_Venta.Model.ReporteVenta;
import com.foodnet.Reporte_Venta.Repository.ReporteVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReporteVentaService {

    @Autowired
    private ReporteVentaRepository reporteVentaRepository;

    public List<ReporteVenta> listarReportes() {
        return reporteVentaRepository.findAll();
    }

    public Optional<ReporteVenta> obtenerReporte(Integer id) {
        return reporteVentaRepository.findById(id);
    }

    public ReporteVenta guardarReporte(ReporteVenta reporte) {
        return reporteVentaRepository.save(reporte);
    }

    public void eliminarReporte(Integer id) {
        reporteVentaRepository.deleteById(id);
    }
}

