import java.util.ArrayList;

public class Inventory{
    private ArrayList<InventoryItem> stock; 


    // should be run when an customer order is placed or a delivery arrives to update the items low in stock
    public ArrayList<InventoryItem> getItemsLowInStock(){
        ArrayList<InventoryItem> itemsLowInStock = new ArrayList<InventoryItem>();
        for (InventoryItem item : stock){
            if (item.isStockLow()){
                itemsLowInStock.add(item);
            }
        }
        return itemsLowInStock;
    }

    



}
