public class InventoryItem{
    private String name;
    private String description;
    private int purchasePrice;
    private int sellPrice;
    private int currentStock;
    private int restockThreshold;

    public InventoryItem(String itemName, String description, int purchasePrice, int sellPrice, int stock, int restockThreshold){
        this.name = itemName;
        this.description = description;
        this.purchasePrice = purchasePrice;
        this.sellPrice = sellPrice;
        this.currentStock = stock;
        this.restockThreshold = restockThreshold;
    }

    public String getName(){
        return this.name;
    }

    public void addStock(int quantity){
        this.currentStock += quantity;
    }

    public void reduceStock(int quantity){
        this.currentStock -= quantity;
    }

    public boolean isStockLow(){
        return (this.currentStock <= this.restockThreshold);
    }

}