package group3.com.example.retail.product;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import group3.com.example.retail.category.Category;

import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import lombok.Data;


@Data
@Entity
@Table(name="Product")
public class Product {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="description")
    private String description;
    
    @Column(name="price")
    private double price;
//    
//    @Column(name="isActive")
//    private String isActive;
    
    @ManyToMany
    @JoinTable(
    		name="ProductsInCategory",
    		joinColumns=@JoinColumn(name="productId"),
    		inverseJoinColumns=@JoinColumn(name="categoryId")
    )
    private Set<Category> categoryAssignments;
	
	
	
//	public Product(String name, String description, double price) {
//		_name = name;
//		_description = description;
//		_price = price;
//	}

    
    
}
//