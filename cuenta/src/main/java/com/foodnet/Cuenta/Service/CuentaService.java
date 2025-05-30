package com.foodnet.Cuenta.Service;


import com.foodnet.Cuenta.Model.Cuenta;
import com.foodnet.Cuenta.Repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> listarCuentas() {
        return cuentaRepository.findAll();
    }

    public Optional<Cuenta> obtenerCuenta(Integer id) {
        return cuentaRepository.findById(id);
    }

    public Cuenta guardarCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public void eliminarCuenta(Integer id) {
        cuentaRepository.deleteById(id);
    }
}
