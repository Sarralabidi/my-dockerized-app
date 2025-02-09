package com.example.cookingapp.Service;

import com.example.cookingapp.Model.ItemEntity;
import com.example.cookingapp.Repositories.Itemrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ItemService {
    @Autowired

    Itemrepo itemrepo;
    public List<ItemEntity> getAllItems() {
        return itemrepo.findAll();
    }
}
