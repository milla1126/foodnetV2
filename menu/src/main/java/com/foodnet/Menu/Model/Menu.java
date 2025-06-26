package com.foodnet.Menu.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Menu")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Menu {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_menu;

    @Column (nullable = false)
    private String productos;

}


