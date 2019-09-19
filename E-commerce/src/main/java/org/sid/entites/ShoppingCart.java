package org.sid.entites;

import java.io.Serializable;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ShoppingCart{ //  implements Serializable
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int cart;
	
	private boolean active;
	
	private Date expiration;
	
	
	@ManyToOne
	private UserSession userSession;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name="cart_detail",
		joinColumns = @JoinColumn(name="cart_details_product_id",referencedColumnName="cart"), // ,referencedColumnName="product" 
		inverseJoinColumns = @JoinColumn(name="cart_details_shopping_cart_id",referencedColumnName="productId") // ,referencedColumnName="cart"
	)
	private List<Product> products ;
	
	// association between product and ShoppingCart
//	@ManyToMany
//	@JoinTable(
//	  name = "CartDetails", 
//	  joinColumns = @JoinColumn( name ="shoppingCart_id" ), 
//	  inverseJoinColumns = @JoinColumn( name = "product_id" ))
//	 private Collection <Product> product;

	public int getCart() {
		return cart;
	}

	public void setCart(int cart) {
		this.cart = cart;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public ShoppingCart(boolean active, Date expiration) {
		super();
		this.active = active;
		this.expiration = expiration;
	}

	public ShoppingCart() {
		super();
	}
	
	
	
	
}
