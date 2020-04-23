package group3.com.example.retail.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

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
	
	
//	public Product(String name, String description, double price) {
//		_name = name;
//		_description = description;
//		_price = price;
//	}

}
