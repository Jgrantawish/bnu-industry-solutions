public class QuantityItem extends Item{
    private int quantity;

    public QuantityItem(Item item, int quantity){
        super(item);
        this.quantity = quantity;
    }

    // Constructor used by SellItems
    protected QuantityItem(String itemName, String description, double purchasePrice, Supplier supplier, int quantity){
        super(itemName, description, purchasePrice, supplier);
        this.quantity = quantity;
    }

    public int getQuantity(){
        return this.quantity;
    }

}
