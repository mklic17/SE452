package group3.com.example.retail.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        ArrayList<Order> orderList = new ArrayList<>();
        for (Order order : orderRepository.findAll()) {
            orderList.add(order);
        }
        return orderList;
    }

    public Order getOrder(Long Id) {
        return orderRepository.findById(Id).orElse(null);
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }
}
