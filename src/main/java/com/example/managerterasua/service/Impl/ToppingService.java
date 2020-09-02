package com.example.managerterasua.service.Impl;

import com.example.managerterasua.model.Product;
import com.example.managerterasua.model.Topping;
import com.example.managerterasua.repository.IToppingRepository;
import com.example.managerterasua.service.ITopping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToppingService implements ITopping {
    @Autowired
    private IToppingRepository toppingRepository;
    @Override
    public Iterable<Topping> findAll() {
        return toppingRepository.findAll();
    }

    @Override
    public Topping findById(Long id) {
        return toppingRepository.findById(id).orElse(null);
    }

    @Override
    public Topping save(Topping topping) {
        return toppingRepository.save(topping);
    }

    @Override
    public void remove(Long id) {
        toppingRepository.deleteById(id);
    }

    @Override
    public List<Topping> findAllByProductsEquals(Product product) {
        return toppingRepository.findAllByProductsEquals(product);
    }
}
