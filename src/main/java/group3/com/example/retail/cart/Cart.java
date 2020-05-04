package group3.com.example.retail.cart;

import group3.com.example.retail.product.Product;
import lombok.Data;
import javax.persistence.*;

import group3.com.example.retail.product.Product;

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

    public void addToTotalPrice(double newPrice) { this.totalPrice += newPrice; }

    public void subtractFromTotalPrice(double priceToSubtract) { this.totalPrice -= priceToSubtract; }

    public double getTotalPrice() { return this.totalPrice; }

    @ManyToMany
    @JoinTable(
            name="ProductsInCart",
            joinColumns=@JoinColumn(name="cartId"),
            inverseJoinColumns=@JoinColumn(name="productId")
    )
    private List<Product> productsInCart;
}
