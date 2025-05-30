package com.foodnet.Menu.Service;


import com.Foodnet.cl.Foodnet.model.Menu;
import com.Foodnet.cl.Foodnet.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> listarMenu() {
        return menuRepository.findAll();
    }

    public Optional<Menu> obtenerMenu(Integer id) {
        return menuRepository.findById(id);
    }

    public Menu guardarMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public void eliminarMenu(Integer id) {
        menuRepository.deleteById(id);
    }
}
