package group3.com.example.retail.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepo orderRepository;

    public List<Orders> getAllOrders() {
        ArrayList<Orders> orderList = new ArrayList<>();
        for (Orders order : orderRepository.findAll()) {
            orderList.add(order);
        }
        return orderList;
    }

    public Orders getOrder(Integer Id) {
        return orderRepository.findById(Id).orElse(null);
    }

    public void addOrder(Orders order) {
        orderRepository.save(order);
    }
}
