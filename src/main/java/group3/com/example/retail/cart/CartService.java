package group3.com.example.retail.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    // Don't think this will be used outside of testing
    public List<Cart> getAllCarts() {
        ArrayList<Cart> cartList = new ArrayList<>();
        for (Cart cart : cartRepository.findAll()) {
            cartList.add(cart);
        }
        return cartList;
    }

    //    public void addProductToCart(Product product, long userId) {
    //        Cart cart = cartRepository.findById(userId);
    //        // TODO: totalPrice += product.getPrice()
    //
    //        totalPrice += 1;
    //        totalQuantity += 1;
    //    }
    //
    //    public void removeProductFromCart(Product product) {
    //        products.remove(product);
    //        // TODO: totalPrice -= product.getPrice()
    //        totalPrice -= 1;
    //        totalQuantity -= 1;
    //    }
}
