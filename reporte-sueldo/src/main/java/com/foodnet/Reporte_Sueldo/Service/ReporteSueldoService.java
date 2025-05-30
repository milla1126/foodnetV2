package com.foodnet.Reporte_Sueldo.Service;

import com.foodnet.Reporte_Sueldo.Model.ReporteSueldo;
import com.foodnet.Reporte_Sueldo.Repository.ReporteSueldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReporteSueldoService {

    @Autowired
    private ReporteSueldoRepository reporteSueldoRepository;

    public List<ReporteSueldo> listarReportes() {
        return reporteSueldoRepository.findAll();
    }

    public Optional<ReporteSueldo> obtenerReporte(Integer id) {
        return reporteSueldoRepository.findById(id);
    }

    public ReporteSueldo guardarReporte(ReporteSueldo reporte) {
        return reporteSueldoRepository.save(reporte);
    }

    public void eliminarReporte(Integer id) {
        reporteSueldoRepository.deleteById(id);
    }
}

