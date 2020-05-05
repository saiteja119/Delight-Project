package com.CapG.Delight.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CapG.Delight.entity.ProductOrder;
import com.CapG.Delight.repo.ProductRepoInterface;


@Service
public class ProductService implements ProductServiceInterface {
	
	
	@Autowired
	private ProductRepoInterface productOrderRepo;

	
	@Override
	public List<ProductOrder> reterive() {
		// TODO Auto-generated method stub
		List<ProductOrder> list=productOrderRepo.reterive();
		return list;
	}
	
	/*
	 * This method is used to track the particular orderId in the database.
	 * Method 	 : trackById
	 * Type 	 : ProductOrder
	 * parameters: orderId
	 * Author 	 : Sai Teja
	 * Date 	 : 20/04/2020
	 */

	
	@Override
	public ProductOrder trackById(String id) {
		ProductOrder order=productOrderRepo.trackById(id);
		return order;
	}
	
	/*
	 * This method is used to update the DateofDelivery and DeliveryStatus of the particular orderID in the database.
	 * Method 	 : updateOrder
	 * Type 	 : boolean
	 * parameters: orderId,ProductOrder(Class)
	 * Author 	 : Sai Teja
	 * Date 	 : 21/04/2020
	 */

	
//	@Override
//	public boolean update(String id, Date delivery, String status) {
//		// TODO Auto-generated method stub
//		return productOrderRepo.update(id,delivery,status);
//	}
	
	/*
	 * This method is used to update the DeliveryStatus of the particular orderID in the database.
	 * Method 	 : updateOrderIdWithStatus
	 * Type 	 : boolean
	 * parameters: orderId,deliveryStatus
	 * Author 	 : Sai Teja
	 * Date 	 : 21/04/2020
	 */


	@Override
	public boolean updateIdWithStatus(String id, String status,LocalDate dateOfDelivery) {
		// TODO Auto-generated method stub
		return productOrderRepo.updateIdWithStatus(id,status,dateOfDelivery);
	}
	
//	public boolean checkDateOfDelivery(LocalDate dateOfDelivery,LocalDate dateOfOrder)
//	{
//		if(dateOfDelivery==null && dateOfOrder==null)
//		{
//			return false;
//		}
//		LocalDate order;
// 		LocalDate delivery;
// 		if(delivery.isAfter(order))
// 		{
// 			return true;
// 		}
 		
 		
//	}
	
	
	
	
}