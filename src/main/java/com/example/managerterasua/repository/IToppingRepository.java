package com.example.managerterasua.repository;

import com.example.managerterasua.model.Product;
import com.example.managerterasua.model.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IToppingRepository extends JpaRepository<Topping,Long> {
    List<Topping> findAllByProductsEquals(Product product);
}
