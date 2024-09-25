package com.example.demo.respone;

import com.example.demo.enums.TableStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor @AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TableResponseDTO {

	String idTable;
	String nameTable;
	boolean isDeleted;
	@Min(0)
	private int maxCapacity;
	@Enumerated(EnumType.STRING)
	private TableStatus status;;
}
