package group3.com.example.retail.category;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import group3.com.example.retail.product.Product;

import javax.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;


@Data
@Entity
@Table(name="Category")
public class Category implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private Long Id;
	
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="parent")
	private Long parent;


	@ManyToMany
	@JoinTable(
			name = "Products_In_Category",
			joinColumns = {
					@JoinColumn( name = "product_Id", referencedColumnName = "Id")
			}, 
			inverseJoinColumns = {
					@JoinColumn( name = "category_Id", referencedColumnName = "Id")
			}
	)
	private Set<Product> products = new HashSet<Product>();


	public Category(String name, long parent) {
		this.name = name;
		this.parent = parent;
	}
	
	public Category() {
	}
	

}

