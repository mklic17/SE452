package group3.com.example.retail.cart;

import group3.com.example.retail.product.Product;
import lombok.Data;
import javax.persistence.*;

import group3.com.example.retail.product.Product;
import java.util.Set;

@Data
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_ID")
    private long cartID;

    @Column(name="customer_ID")
    private String customerID;

    @Column(name="total_price")
    private double totalPrice;

    public void addToTotalPrice(double newPrice) { this.totalPrice += newPrice; }

    public void subtractFromTotalPrice(double priceToSubtract) { this.totalPrice -= priceToSubtract; }

    public double getTotalPrice() { return this.totalPrice; }

    // Cart is the owner in this ManyToMany relationship
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="Cart_Products",
            joinColumns= @JoinColumn(name="cart_ID") ,
            inverseJoinColumns=@JoinColumn(name="product_ID")
    )
    private Set<Product> cartProducts;
}
