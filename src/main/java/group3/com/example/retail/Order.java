package group3.com.example.retail;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;

@ToString
@Data public class Order {

    private final double finalPrice;
    private final ArrayList<String> products;
    private final Date datePlaced;

    public Order(double finalPrice, ArrayList<String> products) {
        this.finalPrice = finalPrice;
        this.products = products;
        this.datePlaced = new Date();
    }

    /** TODO: the list of items will be displayed to the user
     *  on the order summary page, along with the total price
     *  and date placed.
     */
}
