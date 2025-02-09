package com.example.cookingapp.Controller;
import com.example.cookingapp.Model.ItemEntity;
import com.example.cookingapp.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://172.18.0.4:4200")  // Allow CORS from the Angular app
@RequestMapping("/api")
public class ItemController {
    @Autowired
    private ItemService itemService;



    @GetMapping("/items")
    public List<ItemEntity> getItems() {
        // Assuming you have a service that returns a list of items from the database
        return itemService.getAllItems();
    }
}
