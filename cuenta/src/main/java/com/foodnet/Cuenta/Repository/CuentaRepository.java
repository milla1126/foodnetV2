package com.Foodnet.cl.Foodnet.repository;

import com.Foodnet.cl.Foodnet.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

}
