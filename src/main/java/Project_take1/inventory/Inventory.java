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
        item.setId(id);
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
    public Item getItem(int i){
        if(i >= items.size()){
            throw new RuntimeException("Non ci sono abbastanza elementi");
        } else{
            return items.get(i);
        }
    }
    public Item getItem(Item i){
        if(!items.contains(i)){
            throw new RuntimeException("Non è qui dentro");
        } else{
            return items.get(items.indexOf(i));
        }
    }
    public void removeItem(int i){
        Item o = items.get(i);
        items.remove(i);
        try{
            SavingUtils.deleteItem(id, o);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void removeItem(Item i){
        if(items.contains(i)){
            items.remove(i);
            try{
                SavingUtils.deleteItem(id, i);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    public void init(){
        try {
            for(Item i:SavingUtils.getAllItems(id)){
                items.add(i);
                weight += i.getTotalWeight();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
