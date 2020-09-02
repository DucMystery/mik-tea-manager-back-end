package com.example.managerterasua.controller;

import com.example.managerterasua.model.Store;
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
@CrossOrigin("*")
@RequestMapping("api/stores/")
public class StoreController {

    @Autowired
    private IStore storeService;

    @GetMapping()
    public ResponseEntity<List<Store>> getAllStore(){
        List<Store> storeList = (List<Store>) storeService.findAll();
        if (storeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(storeList,HttpStatus.OK);
    }

    @GetMapping("{id}/search")
    public ResponseEntity<Store> getStoreById(@PathVariable Long id){
        Store store = storeService.findById(id);
        if (store == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(store,HttpStatus.OK);
    }
}
