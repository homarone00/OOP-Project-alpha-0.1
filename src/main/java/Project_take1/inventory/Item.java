package Project_take1.inventory;

import java.util.ArrayList;
import java.util.Objects;

public class Item {
    String name;
    int quantity;
    double weight;
    ArrayList<String> description;
    String category;
    Money price;

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
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getTotalWeight() {
        return weight * (double) quantity;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Item item = (Item) o;
        return name.equals(item.name);
    }

    @Override
    public String toString() {
        return "Item{" + "name='" + name + '\'' + ", quantity=" + quantity + ", weight=" + weight + ", description='" + description + '\'' + ", category='" + category + '\'' + ", price=" + price + '}';
    }
}
