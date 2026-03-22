public class SellItem extends QuantityItem{
    private double unitSellPrice;
    
    public SellItem(QuantityItem quantityItem, double unitSellPrice){
        super(quantityItem);
        this.unitSellPrice = unitSellPrice;
    }
}
