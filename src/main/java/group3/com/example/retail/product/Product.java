package group3.com.example.retail.product;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
//@TypeDefs({
//	@TypeDef(name = "hstore", typeClass = PostgreSQLHStoreType.class)
//})
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
    
//    @Column(name="shortsummary")
//    private double shortsummary;
     
//    @Column(name="")
//    private double ;
    
    
    @ManyToMany
    @JoinTable(
    		name="ProductsInCategory",
    		joinColumns=@JoinColumn(name="productId"),
    		inverseJoinColumns=@JoinColumn(name="categoryId")
    )
    private Set<Category> categoryAssignments;
    
//    @Type(type = "hstore")
//    @Column(columnDefinition = "hstore")
//    private Map<String, String> image = new HashMap<String, String>(); // ID --> image URL
    

//    @ManyToMany
//    private Set<Cart> cartAssignments;

//    public double getPrice() { return this.price; }
	
	
//	public Product(String name, String description, double price) {
//		_name = name;
//		_description = description;
//		_price = price;
//	}

    //
    
}
