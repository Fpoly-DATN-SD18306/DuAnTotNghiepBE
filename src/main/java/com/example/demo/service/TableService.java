package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.enums.TableStatus;

import com.example.demo.request.TableRequestDTO;
import com.example.demo.request.TableStatusRequestDTO;
import com.example.demo.respone.ApiRespone;
import com.example.demo.respone.TableResponseDTO;
import com.example.demo.respone.TableStatusResponeDTO;

public interface TableService {
	TableResponseDTO saveTables(TableRequestDTO request);

	TableResponseDTO updateTable(TableRequestDTO request, int idTable);

	ApiRespone<?> deleteTable(int idTable);

	List<TableResponseDTO> getAllTables();

	Page<TableResponseDTO> getAllPages(int page, int size);

	ApiRespone<TableResponseDTO> getTable(int idtable);

	// Find table not deleted
	List<TableResponseDTO> findAllTableNotDelete();

	List<TableStatusResponeDTO> getAllStatuses();

	TableResponseDTO searchTable(String name);

	Page<TableResponseDTO> findTablesByStatus(TableStatus status, int page, int size);

	public ApiRespone<?> updateStatus(int idTable, TableStatusRequestDTO request);
	// Page<TableResponseDTO> findAvailableTables(int numberOfGuests, int page, int
	// size);
}
