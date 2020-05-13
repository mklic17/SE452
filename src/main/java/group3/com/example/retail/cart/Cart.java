package group3.com.example.retail.cart;

import group3.com.example.retail.product.Product;
import lombok.Data;
import javax.persistence.*;

import group3.com.example.retail.product.Product;

import java.util.List;

@Data
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_ID")
    private long cartID;

    @Column(name="customerid")
    private String customerid;

    @Column(name="totalprice")
    private double totalPrice;

    public void addToTotalPrice(double newPrice) { this.totalPrice += newPrice; }

    public void subtractFromTotalPrice(double priceToSubtract) { this.totalPrice -= priceToSubtract; }

    public double getTotalPrice() { return this.totalPrice; }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="ProductsInCart",
            joinColumns=@JoinColumn(name="cart_ID"),
            inverseJoinColumns=@JoinColumn(name="product_ID")
    )
    private List<Product> productsInCart;
}
