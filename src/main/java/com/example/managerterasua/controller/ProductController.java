package com.example.managerterasua.controller;

import com.example.managerterasua.model.Product;
import com.example.managerterasua.model.Store;
import com.example.managerterasua.service.IProduct;
import com.example.managerterasua.service.IStore;
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
@RequestMapping("api/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private IProduct productService;
    @Autowired
    private IStore storeService;

    @GetMapping()
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> products = (List<Product>) productService.findAll();
        if (products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{storeId}/list")
    public ResponseEntity<List<Product>> getAllProductByStoreId(@PathVariable Long storeId){
        Store store = storeService.findById(storeId);
        if (store == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<Product> productList = productService.findAllByStoresEquals(store);
        return new ResponseEntity<>(productList,HttpStatus.OK);

    }

    @GetMapping("/{storeId}/listNameAsc")
    public ResponseEntity<List<Product>> getAllProductByStoreIdOrderByNameAsc(@PathVariable Long storeId){
        Store store = storeService.findById(storeId);
        if (store == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<Product> productList = productService.findAllByStoresEqualsOrderByNameAsc(store);
        return new ResponseEntity<>(productList,HttpStatus.OK);

    }
    @GetMapping("/{storeId}/listNameDesc")
    public ResponseEntity<List<Product>> getAllProductByStoreIdOrderByNameDesc(@PathVariable Long storeId){
        Store currentStore = storeService.findById(storeId);
        if (currentStore == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<Product> productList = productService.findAllByStoresEqualsOrderByNameDesc(currentStore);
        return new ResponseEntity<>(productList,HttpStatus.OK);

    }
    @GetMapping("/{storeId}/listPriceAsc")
    public ResponseEntity<List<Product>> getAllProductByStoreIdOrderByPriceAsc(@PathVariable Long storeId){
        Store store = storeService.findById(storeId);
        if (store == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<Product> productList = productService.findAllByStoresEqualsOrderByPriceAsc(store);
        return new ResponseEntity<>(productList,HttpStatus.OK);

    }
    @GetMapping("/{storeId}/listPriceDesc")
    public ResponseEntity<List<Product>> getAllProductByStoreIdOrderByPriceDesc(@PathVariable Long storeId){
        Store store = storeService.findById(storeId);
        if (store == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<Product> productList = productService.findAllByStoresEqualsOrderByPriceDesc(store);
        return new ResponseEntity<>(productList,HttpStatus.OK);

    }



}
