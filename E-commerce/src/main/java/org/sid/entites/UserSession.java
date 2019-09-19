package org.sid.entites;

import java.io.Serializable;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
//@Table(name="UserSession")
public class UserSession implements Serializable{
	
	@Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int session;
	
	//@Column(name="@IP")
	private String IPAdd;
	
	//@Column
	private Date timestamp;
	
	// association between UserSession and User
//	@ManyToOne
//	@JoinColumn(name="User_Id")
//	private User user;
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy = "userSession")
	private List<ShoppingCart> shoppingCarts ;

	// Association between UserSession and ShoppingCart
//	@OneToMany(mappedBy = "session", fetch = FetchType.LAZY)
//	private Collection <ShoppingCart> shoppingCart;


	// getters and setters
	public int getSesseion() {
		return session;
	}

	public void setSesseion(int sesseion) {
		this.session = sesseion;
	}

	public String getIPAdd() {
		return IPAdd;
	}

	public void setIPAdd(String iPAdd) {
		IPAdd = iPAdd;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	
	public UserSession( String iPAdd, Date timestamp) {
		super();
		this.IPAdd = iPAdd;
		this.timestamp = new Date();
	}
	
//	public UserSession() {
//		super();
//		this.IPAdd= "192.11.3.1";
//		this.timestamp=new Date();	
//	}
	
}
 