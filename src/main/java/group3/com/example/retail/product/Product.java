package group3.com.example.retail.product;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;


import java.util.HashSet;
import java.util.List;


import java.util.HashSet;
import java.util.List;

import java.util.Set;
import javax.persistence.*;
import group3.com.example.retail.cart.Cart;
import group3.com.example.retail.category.Category;
import lombok.Data;

import lombok.Getter;
import lombok.ToString;
import lombok.ToString.Exclude;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLHStoreType;


@Data
@Entity
@Table(name="Product")

public class Product implements Serializable {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
    
    
    @Column(name="name")
    private String name;
    
    
    @Column(name="price")
    private double price;
    
    
    @Column(name="summary")
    private String summary;
    
    
    @Column(name="description")
    private String description;
    
    
    @Column(name="image")
    private String image;
    


    @ManyToMany(mappedBy = "cartProducts", fetch = FetchType.EAGER)
    private List<Cart> cartAssignments= new ArrayList<>();
 
    @Exclude
    @ManyToMany (mappedBy = "products", fetch = FetchType.EAGER)
    private Set<Category> categoryAssignments = new HashSet<Category>();
    

    
	public boolean equals(Object thatObject) {
		if (thatObject == this) {
			return true;
		}
		if (!(thatObject instanceof Category)) { // Check the type and validate that it's
	    	return false;
	    }
		Product curr = (Product)thatObject;// Cast to the proper Object 
	    if (curr.getId() == (this.Id) 
	    		&& curr.getName() == this.name 
	    		&& curr.getPrice() == (this.price)
	    		&& curr.getSummary().equals(this.summary)
	    		&& curr.getDescription().equals(this.description)
	    ) {
	    	return true;
	    }
	    return false;
	  }
		
	// OVERRIDE HashCode
	  @Transient 
	  private int theHashCode = 0;
	  public int hashCode() {
		  if(theHashCode == 0) {
			  theHashCode = 17;
			  theHashCode = theHashCode * 37 + this.Id.hashCode();
			  theHashCode = theHashCode * 37 + this.name.hashCode(); 
			  theHashCode = theHashCode * 37 + this.summary.hashCode();
			  theHashCode = theHashCode * 37 + this.description.hashCode();
			  theHashCode = theHashCode * 37 + this.image.hashCode();
		  }
		  return theHashCode;
	  }
    

}
