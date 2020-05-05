package com.CapG.Delight.repo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.CapG.Delight.entity.ProductOrder;


@Transactional
@Repository
public class ProductRepo implements ProductRepoInterface{
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<ProductOrder> reterive() {
		// TODO Auto-generated method stub
		String Qstr="SELECT order from ProductOrder order";
		TypedQuery<ProductOrder> query=em.createQuery(Qstr,ProductOrder.class);
		return query.getResultList();
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
		System.out.println("repo");
		// TODO Auto-generated method stub
		ProductOrder order=em.find(ProductOrder.class, id);
		if(order==null)
		{
			return null;
		}	
		else {
			return order;
		}
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
//		ProductOrder order =em.find(ProductOrder.class, id);
//		if(order != null) {
//			order.setDateOfDelivery(delivery);
//			order.setDeliveryStatus(status);
//			return true;
//		}
//		return false;
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
		ProductOrder order =em.find(ProductOrder.class, id);
		if(order!= null) {
			order.setDeliveryStatus(status);
			order.setDateOfDelivery(dateOfDelivery);
			return true;
		}
		return false;
	}
}