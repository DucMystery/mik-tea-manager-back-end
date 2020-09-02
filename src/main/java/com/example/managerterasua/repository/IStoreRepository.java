package com.example.managerterasua.repository;

import com.example.managerterasua.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStoreRepository extends JpaRepository<Store,Long> {
}
