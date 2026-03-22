public class Item{
    private String name;
    private String description;
    private Supplier supplier;
    private double unitPurchasePrice;

    public Item(String itemName, String description, double purchasePrice, Supplier supplier){
        this.name = itemName;
        this.description = description;
        this.unitPurchasePrice = purchasePrice;
        this.supplier = supplier;
    }

    // Copy constructor used by QuantityItems
    protected Item(Item itemToCopy){
        this.name = itemToCopy.name;
        this.description = itemToCopy.description;
        this.unitPurchasePrice = itemToCopy.unitPurchasePrice;
        this.supplier = itemToCopy.supplier;
    }

    public String getName(){
        return this.name;
    }

    public Supplier getSupplier(){
        return this.supplier;
    }

    public double getUnitPurchasePrice(){
        return this.unitPurchasePrice;
    }


}