public class Item{
    private String name;
    private String description;
    private Supplier supplier;
    private double purchasePrice;

    public Item(String itemName, String description, double purchasePrice, Supplier supplier){
        this.name = itemName;
        this.description = description;
        this.purchasePrice = purchasePrice;
        this.supplier = supplier;
    }

    // Copy constructor used by QuantityItems
    protected Item(Item itemToCopy){
        this.name = itemToCopy.name;
        this.description = itemToCopy.description;
        this.purchasePrice = itemToCopy.purchasePrice;
        this.supplier = itemToCopy.supplier;
    }

    public String getName(){
        return this.name;
    }


}