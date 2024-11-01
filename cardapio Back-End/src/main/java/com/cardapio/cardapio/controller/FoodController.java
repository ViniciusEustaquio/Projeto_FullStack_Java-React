package com.cardapio.cardapio.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardapio.cardapio.model.Food;
import com.cardapio.cardapio.model.FoodRequestDTO;
import com.cardapio.cardapio.model.FoodResponseDTO;
import com.cardapio.cardapio.repository.FoodRepository;

@RestController
@RequestMapping("/food")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FoodController {
    
    
    
    @Autowired
    private FoodRepository foodController;
    
    @GetMapping
    public List<FoodResponseDTO> getAll(){
        
       
        List<FoodResponseDTO> foodList = (List<FoodResponseDTO>) foodController.findAll().stream().map(FoodResponseDTO::new).collect(Collectors.toList());
        
        return foodList;
        
    }
    
    
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data ){
        
        Food fooddata = new Food(data);
        
        foodController.save(fooddata);
        
        
        return;
        
        
    }
    

}
