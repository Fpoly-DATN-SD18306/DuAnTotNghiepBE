package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.request.TableRequestDTO;
import com.example.demo.respone.ApiRespone;
import com.example.demo.respone.TableResponseDTO;

public interface TableService {
	TableResponseDTO saveTables(TableRequestDTO request);

	TableResponseDTO updateTable(TableRequestDTO request, int idTable);

	ApiRespone<?> deleteTable(int idTable);

	List<TableResponseDTO> getAllTables();

	Page<TableResponseDTO> getAllPages(int page, int size);

	ApiRespone<TableResponseDTO> getTable(int idtable);
}
