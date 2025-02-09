package com.example.cookingapp.Repositories;

import com.example.cookingapp.Model.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Itemrepo  extends JpaRepository<ItemEntity, Integer> {
    List<ItemEntity> findAll();
}
