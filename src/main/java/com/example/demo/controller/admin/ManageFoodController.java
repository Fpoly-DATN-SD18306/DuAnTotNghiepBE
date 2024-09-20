package com.example.demo.controller.admin;

import com.example.demo.request.FoodRequestDTO;
import com.example.demo.respone.ApiRespone;
import com.example.demo.service.FoodService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/foods")
public class ManageFoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping
    public ApiRespone<?> getAllFoods(@RequestParam(required = false, defaultValue = "0") int page,
                                     @RequestParam(required = false, defaultValue = "10") int size  ) {
         return ApiRespone.builder()
                .result(foodService.getAllFood(page,size))
                .build();
    }
    @PostMapping
    public ApiRespone<?> postFood(@ModelAttribute FoodRequestDTO requestDTO, @RequestParam(name = "file",required = false) MultipartFile file  ) {
        return ApiRespone.builder()
                .result(foodService.saveFood(requestDTO,file))
                .build();
    }
    @PutMapping("{id}")
    public ApiRespone<?> putFood(@PathVariable("id") int idFood ,@ModelAttribute FoodRequestDTO requestDTO, @RequestParam(name = "file",required = false) MultipartFile file  ) {
        return ApiRespone.builder()
                .result(foodService.updateFood(idFood,requestDTO,file))
                .build();
    }

}
