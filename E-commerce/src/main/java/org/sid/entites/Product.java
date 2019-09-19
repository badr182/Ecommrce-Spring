package org.sid.entites;

import java.io.Serializable;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Product {// implements Serializable 

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	private String title;
	
	private int price;
	
	private Date timestamp;
	/**
	 * 
	 * by amine : association between Product and OrderProduct 
	 * By badr : fetch = FetchType.LAZY , we return to this option 'fetch' and pick the right one
	 * By badr : Why you chose Collection instead of List ??
	 * By badr : the name of attribute in side of 'One' should finish with letter 's'
	 *  
	 */
	@OneToMany(mappedBy="product") 
	private List<OrderProduct> orderProducts;  
	
	@ManyToMany(mappedBy = "products")
	private List<ShoppingCart> shoppingCarts;
	
//	// association between product and ShoppingCart
//	@ManyToMany(mappedBy="product")
//	private Collection <ShoppingCart> shoppingCart;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}
	
	/**
	 * 
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * 
	 * @return
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	
	/**
	 * 
	 * @param timestamp
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	/**
	 * 
	 * 
	 * @param title
	 * @param price
	 * @param timestamp
	 */
	public Product(String title, int price, Date timestamp) {
		super();
		this.title = title;
		this.price = price;
		this.timestamp = timestamp;
	}

//	public Product() {
//		super();
//		this.title = "PC HP";
//		this.price = 3000;
//		this.timestamp = new Date();
//		
//	}
	
	
	
}
