public class InventoryStock {
    private String name;
    private Supplier supplier;
    private double avgPurchasePrice;
    private double currentSellPrice;
    private double markUpFactor;
    private int stockLevel;
    private int lowStockThreshold;

    public InventoryStock(QuantityItem quantityItem, double priceMarkUpFactor, int lowStockThreshold){
        this.name = quantityItem.getName();
        this.supplier = quantityItem.getSupplier();
        this.stockLevel = 0;
        this.markUpFactor = priceMarkUpFactor;
        this.lowStockThreshold = lowStockThreshold;
        this.calculateAvgPurchasePrice(quantityItem);
        this.calculateCurrentSellPrice();
    }

    private void calculateAvgPurchasePrice(QuantityItem quantityItem){
        double currentTotal = stockLevel * avgPurchasePrice;
        double newTotal = quantityItem.getQuantity() * quantityItem.getUnitPurchasePrice();
        this.avgPurchasePrice = (currentTotal + newTotal) / quantityItem.getQuantity();
    }

     private void calculateCurrentSellPrice(){
        this.currentSellPrice = this.markUpFactor * this.avgPurchasePrice;

    }

    private boolean isLow(){
        return (this.stockLevel > 0 && this.stockLevel <= this.lowStockThreshold);
    }

    private boolean isOut(){
        return (this.stockLevel == 0);
    }

    public void addStock(QuantityItem quantityItem){
        this.stockLevel =+ quantityItem.getQuantity();
    }

    public void removeStock(QuantityItem quantityItem){
        this.stockLevel =- quantityItem.getQuantity();
    }

    public double getCurrentSellPrice(){
        return this.currentSellPrice;
    }

    
}
