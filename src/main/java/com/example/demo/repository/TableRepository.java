package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TableEntity;
@Repository
public interface TableRepository extends JpaRepository<TableEntity, Integer> {

	TableEntity findByNameTable(String nameTable);
	
}
