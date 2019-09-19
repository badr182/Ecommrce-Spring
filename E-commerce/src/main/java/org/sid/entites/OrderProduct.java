package org.sid.entites;

import java.io.Serializable;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OrderProduct implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderProduct;
	
	private int qte;
	
	// Order and OrderProduct
	@ManyToOne
	//@JoinColumn(name="OrderID")
	private Order order;
	
	@ManyToOne
	private Product product;
	// Product and OrderProduct
//	@ManyToOne
//	@JoinColumn(name="Product_ID")
//	private Product product;
	
	public OrderProduct() {
		super();
	}

	public OrderProduct(int qte) {
		super();
		this.qte = qte;
	}

	public int getOrderProduct() {
		return orderProduct;
	}

	

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	
}
