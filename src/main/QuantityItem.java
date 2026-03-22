public class QuantityItem extends Item{
    private int quantity;

    public QuantityItem(Item item, int quantity){
        super(item);
        this.quantity = quantity;
    }

    // Copy constructor used by SellItems
    protected QuantityItem(QuantityItem itemToCopy){
        super(itemToCopy);
        this.quantity = itemToCopy.quantity;
    }
    
}
