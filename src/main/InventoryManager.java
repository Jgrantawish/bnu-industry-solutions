import java.util.ArrayList;

 /**
 * The InventoryManager Class is responsible for maintaining a list of products kept in BNU Industry Solution's Warehouse.
 * It provides the methods to filter products based on their stock levels.
 * It also provides the method to find a given product.
 */
public class InventoryManager{
    private ArrayList<InventoryStock> allStock = new ArrayList<>();

    public InventoryManager(){
    }

    public void addInventoryStock(InventoryStock stockItem){
        this.allStock.add(stockItem);
    }

    /** Returns an array of products that still have available stock left */
    public ArrayList<InventoryStock> getAllItemsInStock(){
         ArrayList<InventoryStock> itemsInStock = new ArrayList<>();
        for (InventoryStock stockItem : this.allStock){
            if (!stockItem.isOut()){
                itemsInStock.add(stockItem);
            }
        }
        return itemsInStock;
    }

    /** Returns an array of products that are low in stock */
    public ArrayList<InventoryStock> getItemsLowInStock(){
        ArrayList<InventoryStock> itemsLowInStock = new ArrayList<>();
        for (InventoryStock stockItem : this.allStock){
            if (stockItem.isLow()){
                itemsLowInStock.add(stockItem);
            }
        }
        return itemsLowInStock;
    }

    /** Returns an array of products that have no stock left */
    public ArrayList<InventoryStock> getItemsOutOfStock(){
        ArrayList<InventoryStock> itemsOutOfStock = new ArrayList<>();
        for (InventoryStock stockItem : this.allStock){
            if (stockItem.isOut()){
                itemsOutOfStock.add(stockItem);
            }
        }
        return itemsOutOfStock;
    }

    /** Iterates through the list of products and returns the InventoryStock object that matches the specified item name. 
     * Returns null if no product with the specified name exists.
     * */
    public InventoryStock findInventoryStockItemByName(String name){
        for (InventoryStock stockItem : this.allStock){
            if (stockItem.getName().equals(name)){
                return stockItem;
            }
        }
        return null;
    } 


}
