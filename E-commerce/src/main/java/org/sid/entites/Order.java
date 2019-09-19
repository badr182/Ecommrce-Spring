package org.sid.entites;

import java.io.Serializable;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	// @Column
	private Date orderDate;
	
	// @Column
	private int orderAmount;
	
	// @Column
	private boolean state;
	
	// User and order
	@ManyToOne()
	private User user;
	//@JoinColumn(name="user")
	
	@OneToMany(mappedBy = "order")
	List <OrderProduct> orderProducts ; // 's' that's mean order have many orderProduct 
	
	// Order and OrderProduct
//	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
//	private Collection <OrderProduct> orderProduct;

	
	public Integer getOrderId() {
		return orderId;
	}

	

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Order(Date orderDate, int orderAmount, boolean state) {
		super();
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
		this.state = state;
	}

//	public Order() {
//		super();
//		this.order_date = new Date();
//		this.order_amount=5;
//	}
	
	

}
