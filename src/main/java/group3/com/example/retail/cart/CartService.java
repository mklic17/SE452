package group3.com.example.retail.cart;

import group3.com.example.retail.product.Product;
import group3.com.example.retail.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    // Don't think this will be used outside of testing
    public List<Cart> getAllCarts() {
        ArrayList<Cart> cartList = new ArrayList<>();
        for (Cart cart : cartRepository.findAll()) {
            cartList.add(cart);
        }
        return cartList;
    }

    public void addProductToCart(long productID, long userID) {
        // get user's cart object with userID,
        // if there is no user cart yet, make one
        Cart cart = cartRepository.findById(userID).orElse(new Cart());

        // get the product object with productID
        Product product = productRepository.findById(productID);
        double productPrice = product.getPrice();
        cart.addToTotalPrice(productPrice);
        cart.insertCartItem(product);
        cartRepository.save(cart);
    }

    public void removeProductFromCart(long productID, long userID) {
        // get user's cart with userId
        Optional<Cart> cart = cartRepository.findById(userID);
        // get the product with productId and its price
        Product product = productRepository.findById(productID);
        double productPrice = product.getPrice();
        cart.get().subtractFromTotalPrice(productPrice);
        cart.get().removeCartItem(product);
        cartRepository.save(cart.get());
    }
}
