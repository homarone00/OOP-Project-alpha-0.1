package Project_take1.inventory;

import Project_take1.utils.SavingUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Item {
    UUID idi = UUID.randomUUID();

    public UUID getIdi() {
        return idi;
    }

    public void setIdi(UUID idi) {
        this.idi = idi;
    }

    UUID id;
    String name;
    int quantity;
    double weight;
    ArrayList<String> description;
    String category;
    Money price;
    boolean weapon;

    public Item(String name, int quantity, double weight, ArrayList<String> description, String category, Money price) {
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        try{
            SavingUtils.updateItem(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        try{
            SavingUtils.updateItem(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
        try{
            SavingUtils.updateItem(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
        if(id != null){
            try{
                SavingUtils.updateItem(this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public double getTotalWeight() {
        return weight * (double) quantity;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public void setDescription(ArrayList<String> description) {
        this.description = description;
        if(id != null){
            try{
                SavingUtils.updateItem(this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
        if(id != null){
            try{
                SavingUtils.updateItem(this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
        if(id != null){
            try{
                SavingUtils.updateItem(this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Item item = (Item) o;
        if(id == null || item.id == null){
            return name.equals(item.name);
        }
        else{
            return name.equals(item.name) && id.equals(item.id);
        }
    }

    @Override
    public String toString() {
        return "Item{" + "name='" + name + '\'' + ", quantity=" + quantity + ", weight=" + weight + ", description='" + description + '\'' + ", category='" + category + '\'' + ", price=" + price + '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isWeapon(){
        if(category.equals("weapon")){
            return true;
        }
        else{
            return false;
        }
    }


}
