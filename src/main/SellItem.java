public class SellItem extends QuantityItem{
    private double unitSellPrice;
    
    public SellItem(String itemName, String description, double avgPurchasePrice, Supplier supplier, int quantity, double unitSellPrice){
        super(itemName, description, avgPurchasePrice, supplier, quantity);
        this.unitSellPrice = unitSellPrice;
    }

    public double getUnitSellPrice(){
        return this.unitSellPrice;
    }
}
