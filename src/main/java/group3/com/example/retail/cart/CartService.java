package group3.com.example.retail.cart;

import group3.com.example.retail.product.Product;
import group3.com.example.retail.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

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
        Cart cart = cartRepository.findById(userID).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setCustomerID(userID);
            newCart.setCartProducts(new ArrayList<>());
            return cartRepository.save(newCart);
        });

        // get the product object with productID
        Product product = productRepository.findById(productID);
        double productPrice = product.getPrice();
        cart.addToTotalPrice(productPrice);
        cart.insertCartItem(product);
        cartRepository.save(cart);
    }

    public void removeProductFromCart(long productID, long userID) {
        // get user's cart with userId
        // TODO: change this orElse()
        Cart cart = cartRepository.findById(userID).orElse(null);
        // get the product with productId and its price
        Product product = productRepository.findById(productID);
        double productPrice = product.getPrice();
        System.out.println(productPrice);
        cart.subtractFromTotalPrice(productPrice);
        System.out.println(product.getPrice());
        System.out.println(cart);
        cart.removeCartItem(productID);
        cartRepository.save(cart);
    }

    public void clearCart(long userID) {
        Cart cart = cartRepository.findByCustomerID(userID);
        cart.getCartProducts().clear();
        cart.setTotalPrice(0);
        cartRepository.save(cart);
    }
}
