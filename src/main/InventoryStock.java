public class InventoryStock {
    private String name;
    private String description;
    private Supplier supplier;
    private double avgPurchasePrice;
    private double currentSellPrice;
    private double markUpFactor;
    private int stockLevel;
    private int lowStockThreshold;

    public InventoryStock(QuantityItem quantityItem, double priceMarkUpFactor, int lowStockThreshold){
        this.name = quantityItem.getName();
        this.description = quantityItem.getDescription();
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

    public boolean isLow(){
        return (this.stockLevel > 0 && this.stockLevel <= this.lowStockThreshold);
    }

    public boolean isOut(){
        return (this.stockLevel == 0);
    }
    
    public void addStock(QuantityItem quantityItem){
        this.calculateAvgPurchasePrice(quantityItem);
        this.calculateCurrentSellPrice();
        this.stockLevel =+ quantityItem.getQuantity();
    }

    public void reduceStock(QuantityItem quantityItem){
        this.stockLevel =- quantityItem.getQuantity();
    }

    public String getName(){
        return this.name;
    }

    public int getCurrentStockLevel(){
        return this.stockLevel;
    }

    public double getCurrentSellPrice(){
        return this.currentSellPrice;
    }

    public String toString(){
        return this.name + " -- " + this.description + " -- Current Stock Level: " + this.stockLevel + " -- Average Purchase Price: " + this.avgPurchasePrice + " -- Current Sell Price:  " + this.currentSellPrice + " -- Supplied by: " + this.supplier;
    }

    
}
