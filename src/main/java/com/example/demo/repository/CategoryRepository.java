package com.example.demo.repository;

import com.example.demo.entity.CategoryFoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryFoodEntity,Integer> {
}
