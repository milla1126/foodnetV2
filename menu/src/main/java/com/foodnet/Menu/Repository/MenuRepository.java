package com.foodnet.Menu.Repository;

import com.foodnet.Menu.Model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
