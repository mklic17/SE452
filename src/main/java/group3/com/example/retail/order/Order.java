package group3.com.example.retail.order;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name="finalPrice")
    private double finalPrice;

    /** For each Product in products, find the
     *  product in Product table using the Id
      */
    @OneToMany(
            mappedBy = "Id",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Product> products;

    @Column(name="datePlaced")
    private Date datePlaced;

    /** TODO: the list of items will be displayed to the user
     *  on the order summary page, along with the total price
     *  and date placed.
     */
}
