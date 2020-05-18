package group3.com.example.retail.product;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import group3.com.example.retail.cart.Cart;
import group3.com.example.retail.category.Category;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

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
    
//    @ManyToMany
//    @JoinTable(
//    		name="ProductsInCategory",
//    		joinColumns=@JoinColumn(name="productId"),
//    		inverseJoinColumns=@JoinColumn(name="categoryId")
//    )
//    private Set<Category> categoryAssignments;

    @ManyToMany(mappedBy = "cartProducts", fetch = FetchType.EAGER)
    private List<Cart> cartAssignments;

    public double getPrice() { return this.price; }
	
	
//	public Product(String name, String description, double price) {
//		_name = name;
//		_description = description;
//		_price = price;
//	}

    //
    
}
