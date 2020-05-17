package group3.com.example.retail.cart;

import group3.com.example.retail.product.Product;
import group3.com.example.retail.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group3.com.example.retail.product.ProductRepository;
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

    public void addProductToCart(long productId, String userId) {
        // get user's cart with userId
//        Cart cart = cartRepository.findById(userId);
        // get the product with productId and its price
        // double productPrice = productRepository.findById(productId).getPrice();
       // cart.addToTotalPrice(productPrice);
//        cartRepository.save(cart);
    }

    public void removeProductFromCart(long productId, String userId) {
        // get user's cart with userId
//        Cart cart = cartRepository.findById(userId);
        // get the product with productId and its price
        // double productPrice = productRepository.findById(productId).getPrice();
        // cart.subtractFromTotalPrice(productPrice);
//        cartRepository.save(cart);
    }
}
