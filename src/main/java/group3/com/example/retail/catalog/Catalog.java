package group3.com.example.retail.catalog;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;


@Data
@Entity
@Table(name="Catalog")
public class Catalog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
	private Long _Id;
	
	@Column(name="name")
	private String _name;
	
	// LIST
	
	public Catalog(String name) {
		_name = name;
	}
	
	
}