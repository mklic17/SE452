package group3.com.example.retail;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;

@ToString
@Data public class Cart {

    // TODO: ArrayList<Product>
    private final ArrayList<String> products = new ArrayList<>();
    private double totalPrice;
    // Maybe we don't need this because we have products.size()?
    private int totalQuantity;

    // I don't think Cart will take any params
    public Cart() { }

    // TODO: Take in Product as param instead
    public void addProduct(String product) {
        products.add(product);
        // TODO: totalPrice += product.getPrice()
        totalPrice += 1;
        totalQuantity += 1;
    }

    // TODO: Take in Product as param instead
    public void removeProduct(String product) {
        products.remove(product);
        // TODO: totalPrice -= product.getPrice()
        totalPrice -= 1;
        totalQuantity -= 1;
    }

    // This will happen on the final "Purchase" click
    public Order createOrder() {
        return new Order(this.totalPrice, this.products);
    }
}
