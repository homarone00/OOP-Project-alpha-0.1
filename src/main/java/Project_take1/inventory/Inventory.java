package Project_take1.inventory;

import Project_take1.utils.SavingUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class Inventory {
    UUID id;
    ArrayList<Item> items = new ArrayList<>();
    double weight = 0.;
    public Inventory(UUID id) {
        this.id = id;
    }

    public void insertItem(Item item){
        if(items.contains(item)){
            items.get(items.indexOf(item)).addQuantity(item.getQuantity());
            try{
                SavingUtils.updateItem(id, item);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            items.add(item);
            try{
                SavingUtils.insertItem(id, item);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        weight += item.getTotalWeight();
    }

    public double getWeight() {
        return weight;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Inventory{" + "items=" + items + ", weight=" + weight + '}';
    }
}
