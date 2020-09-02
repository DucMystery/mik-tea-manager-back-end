package com.example.managerterasua.service.Impl;

import com.example.managerterasua.model.Store;
import com.example.managerterasua.repository.IStoreRepository;
import com.example.managerterasua.service.IStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService implements IStore {
    @Autowired
    private IStoreRepository storeRepository;

    @Override
    public Iterable<Store> findAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store findById(Long id) {
        return storeRepository.findById(id).orElse(null);
    }

    @Override
    public Store save(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public void remove(Long id) {
        storeRepository.deleteById(id);

    }
}
