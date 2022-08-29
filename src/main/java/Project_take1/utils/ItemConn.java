package Project_take1.utils;

import Project_take1.inventory.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formdev.flatlaf.json.Json;
import kong.unirest.Unirest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ItemConn {
    static String urlE = "https://www.dnd5eapi.co/api/equipment/";
    static String urlP = "https://www.dnd5eapi.co/api/magic-items/";

    static public Item getItem(String name){
        String linkName = name.trim().toLowerCase().replace(' ', '-');
        String urlI = urlE + linkName;
        String urlMI = urlP + linkName;
        JsonNode json;
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.readTree(Unirest.get(urlI).asString().getBody());
            if(json.has("error")) {
                json = mapper.readTree(Unirest.get(urlMI).asString().getBody());
            }
            if(json.has("error")){
                throw new RuntimeException("Il nome dell'item è inesistente");
            }
        } catch (JsonMappingException e) {
            throw new RuntimeException("Errore nel mapping della spell " + name);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Processing error in spell " + name);
        }
        Money cost;
        if(!json.has("cost")){
            cost = new Money(0,0,0,0,0);
        }
        else {
            if (json.get("cost").get("unit").asText().equalsIgnoreCase("cp")){
                cost = new Money(json.get("cost").get("quantity").asInt(), 0,0,0,0);
            } else if (json.get("cost").get("unit").asText().equalsIgnoreCase("sp")) {
                cost = new Money(0, json.get("cost").get("quantity").asInt(),0,0,0);
            } else if (json.get("cost").get("unit").asText().equalsIgnoreCase("ep")) {
                cost = new Money(0,0, json.get("cost").get("quantity").asInt(),0,0);
            } else if (json.get("cost").get("unit").asText().equalsIgnoreCase("gp")) {
                cost = new Money(0,0,0, json.get("cost").get("quantity").asInt(),0);
            } else {
                cost = new Money(0,0,0,0, json.get("cost").get("quantity").asInt());
            }
        }
        int weight = 0;
        if(json.has("weight"))
        {
            weight = json.get("weight").asInt();
        }
        ArrayList<String> desc = new ArrayList<>();
        for(JsonNode n:json.get("desc")){
            desc.add(n.asText());
        }
        String category = json.get("equipment_category").get("name").asText();
        if(category.equalsIgnoreCase("armor")){
            int max_bonus = 0;
            if(json.get("armor_class").has("max_bonus")) {
                max_bonus = json.get("armor_class").get("max_bonus").asInt();
            }
            return new Armor(json.get("name").asText(), 1, weight, desc, category, cost,
                    json.get("armor_class").get("base").asInt(), json.get("armor_class").get("dex_bonus").asBoolean(),
                    json.get("str_minimum").asInt(), max_bonus, json.get("stealth_disadvantage").asBoolean());
        }
        else if(category.equalsIgnoreCase("weapon")){
            String weapon_category = json.get("weapon_category").asText();
            ArrayList<String> properties = new ArrayList<>();
            for(JsonNode n:json.get("properties")){
                properties.add(n.get("name").asText());
            }
            Map<String, Damage> damageMap = new HashMap<>();
            if(properties.contains("Versatile") || properties.contains("versatile")){
                Damage one_hand = new Damage(json.get("damage").get("damage_dice").asText(), json.get("damage").get(
                        "damage_type").get("name").asText());
                damageMap.put("damage", one_hand);
                Damage two_hand = new Damage(json.get("two_handed_damage").get("damage_dice").asText(), json.get("two_handed_damage").get(
                        "damage_type").get("name").asText());
                damageMap.put("two hand", two_hand);
            }
            else{
                Damage one_hand = new Damage(json.get("damage").get("damage_dice").asText(), json.get("damage").get(
                        "damage_type").get("name").asText());
                damageMap.put("damage", one_hand);
            }
            return new Weapon(json.get("name").asText(), 1, weight, desc, category, cost,
                    json.get("weapon_category").asText(), json.get("weapon_range").asText(), json.get("category_range").asText(),
                    properties, damageMap);
        }
        else{
            return new Item(json.get("name").asText(), 1, weight, desc, category, cost);
        }
    }
}
