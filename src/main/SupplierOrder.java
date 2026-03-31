import java.util.ArrayList;

public class SupplierOrder extends Order{
    private Supplier supplier;
    private ArrayList<QuantityItem> basket = new ArrayList<>();; 

    public SupplierOrder(Supplier supplier, ArrayList<QuantityItem> basketItems){
        super();
        this.supplier = supplier;
        this.basket = basketItems;
    }

    }
    
}
