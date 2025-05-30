package com.foodnet.Propina.Repository;

import com.foodnet.Propina.Model.Propina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropinaRepository extends JpaRepository<Propina, Integer> {
}



