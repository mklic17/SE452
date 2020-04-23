package group3.com.example.retail.product;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import lombok.Data;

import group3.com.example.retail.catalog.Catalog;


@Data
@Entity
@Table(name="Product")
public class Product {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long _Id;
    
    @Column(name="name")
    private String _name;
    
    @Column(name="description")
    private String _description;
    
    @Column(name="price")
    private double _price;
    
    @ManyToMany
    @JoinTable(
    		name="ProductsInCategory",
    		joinColumns=@JoinColumn(name="productId"),
    		inverseJoinColumns=@JoinColumn(name="categoryId")
    )
    private Set<Catalog> _catalogAssignments;
	
	
	
//	public Product(String name, String description, double price) {
//		_name = name;
//		_description = description;
//		_price = price;
//	}

}
