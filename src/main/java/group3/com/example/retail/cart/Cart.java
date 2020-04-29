package group3.com.example.retail.cart;

import group3.com.example.retail.order.Order;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name="totalPrice")
    private double totalPrice;

    /** For each Product in products, find the
     *  product in Product table using the Id
     */
    @OneToMany(
            mappedBy = "Id",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private final List<Product> products;
}
