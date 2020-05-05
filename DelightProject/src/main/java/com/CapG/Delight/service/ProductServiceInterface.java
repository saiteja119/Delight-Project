package com.CapG.Delight.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.CapG.Delight.entity.ProductOrder;

public interface ProductServiceInterface {
	
	public ProductOrder trackById(String id);
    	
   	public List<ProductOrder> reterive();

//	public boolean update(String id, Date delivery, String status);

	public boolean updateIdWithStatus(String id, String status,LocalDate dateOfDelivery);

}