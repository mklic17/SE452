package group3.com.example.retail.product;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import group3.com.example.retail.cart.Cart;
import group3.com.example.retail.category.Category;

import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import lombok.Data;
import lombok.Getter;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLHStoreType;


@Data
@Entity
@Table(name="Product")

public class Product implements Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
    
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
    
 
    @ManyToMany (mappedBy = "products", fetch = FetchType.LAZY)
    private Set<Category> categoryAssignments = new HashSet<Category>();
    

//    @ManyToMany
//    private Set<Cart> cartAssignments;

	
	
    
}
