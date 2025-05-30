import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public List<Cuenta> listar() {
        return cuentaService.listarCuentas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> obtener(@PathVariable Integer id) {
        return cuentaService.obtenerCuenta(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cuenta crear(@RequestBody Cuenta cuenta) {
        return cuentaService.guardarCuenta(cuenta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        cuentaService.eliminarCuenta(id);
    }
}
