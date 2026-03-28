import java.util.ArrayList;

public class InventoryManager{
    private ArrayList<InventoryStock> allStock = new ArrayList<>();

    public ArrayList<InventoryStock> getAllItemInStock(){
         ArrayList<InventoryStock> itemsInStock = new ArrayList<>();
        for (InventoryStock stockItem : this.allStock){
            if (!stockItem.isOut()){
                itemsInStock.add(stockItem);
            }
        }
        return itemsInStock;
    }

    public ArrayList<InventoryStock> getItemsLowInStock(){
        ArrayList<InventoryStock> itemsLowInStock = new ArrayList<>();
        for (InventoryStock stockItem : this.allStock){
            if (stockItem.isLow()){
                itemsLowInStock.add(stockItem);
            }
        }
        return itemsLowInStock;
    }

    public ArrayList<InventoryStock> getItemsOutOfStock(){
        ArrayList<InventoryStock> itemsOutOfStock = new ArrayList<>();
        for (InventoryStock stockItem : this.allStock){
            if (stockItem.isOut()){
                itemsOutOfStock.add(stockItem);
            }
        }
        return itemsOutOfStock;
    }


    public InventoryStock findInventoryStockItemByName(String name){
        for (InventoryStock stockItem : this.allStock){
            if (stockItem.getName().equals(name)){
                return stockItem;
            }
        }
        return null;
    } 


}
