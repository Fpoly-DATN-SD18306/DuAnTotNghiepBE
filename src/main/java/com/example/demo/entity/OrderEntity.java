package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderEntity extends BaseEntity {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idOrder;
	
	
	
	@OneToOne
	@JoinColumn(name = "id_table")
	TableEntity tableEntity;
	
	@ManyToOne
	@JoinColumn(name = "id_User")
	UserEnitty userEnitty;
	
	
	
	@OneToMany(mappedBy = "orderEntity")
	List<OrderDetailEntity> listOrderDetail;
	
	
	String statusOrder;
	
}
