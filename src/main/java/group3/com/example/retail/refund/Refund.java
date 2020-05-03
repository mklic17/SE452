package group3.com.example.retail.refund;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import lombok.Data;

@Data
@Entity
public class Refund {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String refundid;
	private String ordernumber; 
	private String productname;
//	private String reason;
//	private String other;
	
	
	

}
