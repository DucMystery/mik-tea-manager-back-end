package com.example.managerterasua.controller;

import com.example.managerterasua.model.Product;
import com.example.managerterasua.model.Topping;
import com.example.managerterasua.service.IProduct;
import com.example.managerterasua.service.ITopping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("api/toppings")
public class ToppingController {

    @Autowired
    public ITopping toppingService;
    @Autowired
    private IProduct productService;

    @GetMapping("{productId}/list")
    public ResponseEntity<List<Topping>> getToppingListByProductId(@PathVariable Long productId){
        Product product = productService.findById(productId);
        List<Topping> toppingList = toppingService.findAllByProductsEquals(product);
        if (toppingList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(toppingList,HttpStatus.OK);
    }
}
