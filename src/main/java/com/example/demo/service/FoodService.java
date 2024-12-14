package com.example.demo.service;

import com.example.demo.entity.FoodEntity;
import com.example.demo.request.FoodRequestDTO;
import com.example.demo.respone.FoodResponeDTO;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface FoodService {
    public Page<FoodResponeDTO> getAllFood();

    public FoodResponeDTO saveFood(FoodRequestDTO requestDTO, MultipartFile file) throws IOException;

    public FoodResponeDTO updateFood(int idFood, FoodRequestDTO requestDTO, MultipartFile file);

    public FoodResponeDTO getFoodById(int idFood);

    public Page<FoodResponeDTO> getFoodFromFilter(String nameFood, String idCategory, String isSelling,
            Pageable pageable);

    Page<FoodResponeDTO> getFoodFromFilter(String nameFood, String idCategory, Pageable pageable);

    public List<FoodResponeDTO> getFoodByIdCategory(int idCategory);

    List<FoodEntity> searchByName(String nameFood);
}
