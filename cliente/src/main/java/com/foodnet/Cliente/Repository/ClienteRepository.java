package com.Foodnet.cl.Foodnet.repository;

import com.Foodnet.cl.Foodnet.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
