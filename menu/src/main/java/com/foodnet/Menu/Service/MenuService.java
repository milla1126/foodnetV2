package com.foodnet.Menu.Service;

import com.foodnet.Menu.Model.Menu;
import com.foodnet.Menu.Repository.MenuRepository;
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
