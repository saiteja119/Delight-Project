	package com.CapG.Delight.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CapG.Delight.entity.ProductOrder;
import com.CapG.Delight.entity.Users;
import com.CapG.Delight.exception.ProductOrderIdNotFoundException;
import com.CapG.Delight.exception.UserTypeException;
import com.CapG.Delight.service.ProductServiceInterface;
import com.CapG.Delight.service.UserServiceInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductServiceInterface productService;
	private UserServiceInterface userService;

	@GetMapping("/getProduct")
	public ResponseEntity<List<ProductOrder>> getProductList() {
		System.out.println("controller");
		List<ProductOrder> list = productService.reterive();
		return new ResponseEntity<List<ProductOrder>>(list, HttpStatus.OK);
	}

	/*
	 * This is a GetMethod(Http) is used to track the particular orderId in the
	 * database. Method : trackById Type : ResponseEntity<Object> parameters:
	 * orderId Author : Sai Teja Date : 20/04/2020
	 */

	@GetMapping("/view/{id}")
	public ResponseEntity<ProductOrder> trackById(@PathVariable("id") String id)
			throws ProductOrderIdNotFoundException {
		System.out.println("controller");
		ProductOrder order = productService.trackById(id);
		if (order == null)
			throw new ProductOrderIdNotFoundException("Entered Id of " + id + " is not present in the DB");
		return new ResponseEntity<ProductOrder>(order, HttpStatus.OK);
	}

	/*
	 * This is a PutMethod(Http) is used to update the DateofDelivery and
	 * DeliveryStatus of the particular orderID in the database. Method :
	 * updateOrder Type : ResponseEntity<Boolean> parameters:
	 * orderId,ProductOrder(Class) Author : Sai Teja Date : 21/04/2020
	 */

//	@PutMapping("/update1/{id}") 
//	public ResponseEntity<Object> updateOrder(@PathVariable("id") String id,@RequestBody ProductOrder order) throws ProductOrderUpdateNotFoundException
//	{
//		if(!productService.update(id, order.getDateOfDelivery(),order.getDeliveryStatus())) throw new ProductOrderUpdateNotFoundException("you cannot update the order of "+id+" because it is not present in DB");
//		return new ResponseEntity<Object>(productService.update(id, order.getDateOfDelivery(),order.getDeliveryStatus()),HttpStatus.OK);
//	}

	/*
	 * This is a PutMethod(Http) is used to update the DeliveryStatus of the
	 * particular orderID in the database. Method : updateOrderIdWithStatus Type :
	 * ResponseEntity<Boolean> parameters: orderId,deliveryStatus Author : Sai Teja
	 * Date : 21/04/2020
	 */

	@PutMapping("/update/{id}/{status}/{dateOfDelivery}")
	public ResponseEntity<Boolean> updateOrderIdWithStatus(@PathVariable("id") String id, @PathVariable String status,@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate dateOfDelivery)
			throws ProductOrderIdNotFoundException {
		if (!productService.updateIdWithStatus(id, status,dateOfDelivery))
			throw new ProductOrderIdNotFoundException(
					"you cannot update the order of " + id + " because it is not present in DB");
		return new ResponseEntity<Boolean>(productService.updateIdWithStatus(id, status,dateOfDelivery), HttpStatus.OK);
	}
	
	@PostMapping("/userLogin")
	public ResponseEntity<Object> userLogin(@RequestBody Users user1)
	{
		Users user=userService.userLoginService(user1);
		try {
			if(user==null)
			{
				throw new UserTypeException("In-Valid Credentials");
			}
			else
				return new ResponseEntity<Object>(user,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND); 
		}
	}
	
	
}