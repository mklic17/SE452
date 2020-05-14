package group3.com.example.retail.cart;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {

//    Cart findByCustomer_ID(String id);
}
