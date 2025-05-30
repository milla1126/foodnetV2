package com.foodnet.Reporte_Sueldo.Repository;

import com.foodnet.Reporte_Sueldo.Model.ReporteSueldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReporteSueldoRepository extends JpaRepository<ReporteSueldo, Integer> {
}

