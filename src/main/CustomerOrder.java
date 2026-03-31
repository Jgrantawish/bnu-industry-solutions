import java.util.ArrayList;

public class CustomerOrder extends Order {
    private Customer customer;
    private ArrayList<SellItem> basket = new ArrayList<>();; 

    public CustomerOrder(Customer customer, ArrayList<SellItem> basketItems){
        super();
        this.customer = customer;
        this.basket = basketItems;
    }

    }
    
}
