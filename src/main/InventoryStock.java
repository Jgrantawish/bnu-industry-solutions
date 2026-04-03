public class InventoryStock {
    private String name;
    private String description;
    private Supplier supplier;
    private double avgPurchasePrice;
    private double currentSellPrice;
    private double markUpMultiplier;
    private int stockLevel;
    private int lowStockThreshold;

    public InventoryStock(QuantityItem quantityItem){
        this.name = quantityItem.getName();
        this.description = quantityItem.getDescription();
        this.supplier = quantityItem.getSupplier();
        this.stockLevel = quantityItem.getQuantity();
        this.markUpMultiplier = 1.5;
        this.lowStockThreshold = 5;
        this.calculateAvgPurchasePrice(quantityItem);
        this.calculateCurrentSellPrice();
    }

    private void calculateAvgPurchasePrice(QuantityItem quantityItem){
        double currentTotal = stockLevel * avgPurchasePrice;
        double newTotal = quantityItem.getQuantity() * quantityItem.getUnitPurchasePrice();
        this.avgPurchasePrice = (currentTotal + newTotal) / quantityItem.getQuantity();
    }

     private void calculateCurrentSellPrice(){
        this.currentSellPrice = this.markUpMultiplier * this.avgPurchasePrice;

    }

    public boolean isLow(){
        return (this.stockLevel > 0 && this.stockLevel <= this.lowStockThreshold);
    }

    public boolean isOut(){
        return (this.stockLevel == 0);
    }

    public boolean enoughInStock(int quantity){
        return (this.stockLevel >= quantity);
    }
    
    public void addStock(QuantityItem quantityItem){
        this.calculateAvgPurchasePrice(quantityItem);
        this.calculateCurrentSellPrice();
        this.stockLevel += quantityItem.getQuantity();
    }

    public void reduceStock(SellItem sellItem){
        this.stockLevel -= sellItem.getQuantity();
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public Supplier getSupplier(){
        return this.supplier;
    }

    public double getAveragePurchasePrice(){
        return this.avgPurchasePrice;
    }

    public int getCurrentStockLevel(){
        return this.stockLevel;
    }

    public double getCurrentSellPrice(){
        return this.currentSellPrice;
    }

    public int getLowStockThreshold(){
        return this.lowStockThreshold;
    }

    public double getMarkUpMultiplier(){
        return this.markUpMultiplier;
    }

    public void setLowInStockThreshold(int newThreshold){
        this.lowStockThreshold = newThreshold;
    }


    public void setMarkUpMultiplier(double newMultiplier){
        this.markUpMultiplier = newMultiplier;
    }

    public String toString(){
        return this.name + " -- " + this.description + " -- Current Stock Level: " + this.stockLevel + " -- Average Purchase Price: " + this.avgPurchasePrice + " -- Current Sell Price:  " + this.currentSellPrice + " -- Supplied by: " + this.supplier;
    }

    
}
