package com.example.managerterasua.service;

import com.example.managerterasua.model.Product;
import com.example.managerterasua.model.Topping;

import java.util.List;

public interface ITopping extends GenericService<Topping> {
    List<Topping> findAllByProductsEquals(Product product);
}
