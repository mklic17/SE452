package group3.com.example.retail.cart;

import group3.com.example.retail.product.Product;
import lombok.Data;
import javax.persistence.*;

import group3.com.example.retail.product.Product;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_ID")
    private long cartID;

    @Column(name="customer_ID")
    private long customerID;

    @Column(name="total_price")
    private double totalPrice;

    public void addToTotalPrice(double newPrice) { this.totalPrice += newPrice; }

    public void subtractFromTotalPrice(double priceToSubtract) { this.totalPrice -= priceToSubtract; }

    public void insertCartItem(Product product) { cartProducts.add(product); }

    public void removeCartItem(long productID) {
        for (Product product : cartProducts) {
            if (product.getId() == productID) {
                cartProducts.remove(product);
                return;
            }
        }
    }

    // Cart is the owner in this ManyToMany relationship
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="Cart_Products",
            joinColumns= @JoinColumn(name="cart_ID"),
            inverseJoinColumns=@JoinColumn(name="product_ID")
    )
    private List<Product> cartProducts = new ArrayList<Product>();

    @Override
    public String toString() {
        return String.format("Cart ID: " + this.cartID +
                " Customer ID: " + this.customerID +
                " Total Price: " + this.totalPrice +
                " Product in Cart: " + this.cartProducts.size());
    }
}
