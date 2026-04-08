import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Copy;

/**
 * The Item Class is the base class defining the common attributes of goods in the system.
 * Instances of this class hold the details of items sold by Suppliers.
 * The name is the unique identifier for an Item.
 */
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

    /** Copy constructor used by QuantityItems */
    protected Item(Item itemToCopy){
        this.name = itemToCopy.name;
        this.description = itemToCopy.description;
        this.unitPurchasePrice = itemToCopy.unitPurchasePrice;
        this.supplier = itemToCopy.supplier;
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

    public double getUnitPurchasePrice(){
        return this.unitPurchasePrice;
    }

}