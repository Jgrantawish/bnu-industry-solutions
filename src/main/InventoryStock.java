 /**
 * The InventoryStock Class holds details about each type of product kept in BNU Industry Solution's Warehouse.
 * It is responsible for monitoring and updating stock levels. 
 * It also uses the average purchase price to calculate a price for re-sale. 
 */
public class InventoryStock {
    private final double DEFAULT_MARK_UP_MULTIPLIER = 1.5;
    private final int DEFAULT_LOW_STOCK_THRESHOLD = 5;
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
        this.markUpMultiplier = DEFAULT_MARK_UP_MULTIPLIER;
        this.lowStockThreshold = DEFAULT_LOW_STOCK_THRESHOLD;
        this.calculateAvgPurchasePrice(quantityItem);
        this.calculateCurrentSellPrice();
    }

    /** Called when a SupplierOrder arrives at the warehouse. Re-evaluates the average amount paid for items of this product type left in stock */
    private void calculateAvgPurchasePrice(QuantityItem quantityItem){
        double currentTotal = stockLevel * avgPurchasePrice;
        double newTotal = quantityItem.getQuantity() * quantityItem.getUnitPurchasePrice();
        this.avgPurchasePrice = (currentTotal + newTotal) / quantityItem.getQuantity();
    }

    /** Called when a SupplierOrder arrives at the warehouse. Uses the avgPurchasePrice to calculate a re-sale price with a cerain profit margin */
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
    
    /** Called when a SupplierOrder is marked as delivered. 
     * Re-evaluates the average amount paid for this product type and updates the sell price to reflect any changes.
     * Increases the stock level by the quantity ordered. i.e. moves the delivered stock into the warehouse. */
    public void addStock(QuantityItem quantityItem){
        this.calculateAvgPurchasePrice(quantityItem);
        this.calculateCurrentSellPrice();
        this.stockLevel += quantityItem.getQuantity();
    }

    /** Called when a CustomerOrder is placed. Reduces the stock levels of a product type by the quantity purchased in the Order i.e. removes stock from the warehouse shelves */
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

    /** Overrides toString method to give a summary of the warehouse product's attributes */
    public String toString(){
        return this.name + " -- " + this.description + " -- Current Stock Level: " + this.stockLevel + " -- Average Purchase Price: " + this.avgPurchasePrice + " -- Current Sell Price:  " + this.currentSellPrice + " -- Supplied by: " + this.supplier.getName();
    }
    
}
