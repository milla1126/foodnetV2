package com.foodnet.Menu.Controller;

import com.Foodnet.cl.Foodnet.model.Menu;
import com.Foodnet.cl.Foodnet.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public List<Menu> listar() {
        return menuService.listarMenu();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> obtener(@PathVariable Integer id) {
        return menuService.obtenerMenu(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Menu crear(@RequestBody Menu menu) {
        return menuService.guardarMenu(menu);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        menuService.eliminarMenu(id);
    }
}
