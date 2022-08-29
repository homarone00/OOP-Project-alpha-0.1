package Project_take1.spells;

import Project_take1.MyCharacter;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import kong.unirest.Unirest;

public class Spell {
    String name;
    List<String> desc = new ArrayList<>();
    List<String> highLv = new ArrayList<>();
    String range;
    List<String> components = new ArrayList<>();
    String material;
    Boolean ritual;
    String duration;
    Boolean concentration;
    String dc;
    int dcInt;
    int level;
    String attType;
    String school;
    String url = "https://www.dnd5eapi.co/api/spells/";
    ObjectMapper mapper = new ObjectMapper();
    JsonNode json;

    public Spell(String name, List<String> desc, List<String> highLv, String range, List<String> components,
                 String material, Boolean ritual, String duration, Boolean concentration, int dcInt, int level,
                 String attType, String school) {
        if(dcInt>=7 || dcInt < 0) {
            throw new IndexOutOfBoundsException("The index must be lower than 7");
        }
        this.dcInt = dcInt;
        switch (this.dcInt)
        {
            case 0 -> dc = "None";
            case MyCharacter.STRENGTH -> dc = "STR";
            case MyCharacter.DEXTERITY -> dc = "DEX";
            case MyCharacter.CONSTITUTION -> dc = "CON";
            case MyCharacter.INTELLIGENCE -> dc = "INT";
            case MyCharacter.WISDOM -> dc = "WIS";
            case MyCharacter.CHARISMA -> dc = "CHA";
        }
        this.name = name;
        this.desc = desc;
        this.highLv = highLv;
        this.range = range;
        this.components = components;
        this.material = material;
        this.ritual = ritual;
        this.duration = duration;
        this.concentration = concentration;
        this.level = level;
        this.attType = attType;
        this.school = school;
    }

    public Spell(String name, String desc, String highLv, String range, List<String> components, String material,
                 Boolean ritual, String duration, Boolean concentration, int dcInt, int level, String attType,
                 String school) {
        this.dcInt = dcInt;
        switch (this.dcInt)
        {
            case 0 -> dc = "None";
            case MyCharacter.STRENGTH -> dc = "STR";
            case MyCharacter.DEXTERITY -> dc = "DEX";
            case MyCharacter.CONSTITUTION -> dc = "CON";
            case MyCharacter.INTELLIGENCE -> dc = "INT";
            case MyCharacter.WISDOM -> dc = "WIS";
            case MyCharacter.CHARISMA -> dc = "CHA";
        }
        this.name = name;
        this.desc.add(desc);
        this.highLv.add(highLv);
        this.range = range;
        this.components = components;
        this.material = material;
        this.ritual = ritual;
        this.duration = duration;
        this.concentration = concentration;
        this.level = level;
        this.attType = attType;
        this.school = school;
    }

    public Spell(String name) {
        String[] words = name.split("\\s");
        StringBuilder capNameBuild = new StringBuilder();
        for (String w : words) {
            capNameBuild.append(w.substring(0, 1).toUpperCase());
            capNameBuild.append(w.substring(1).toLowerCase()).append(" ");
        }
        this.name = capNameBuild.toString().trim();
        url = this.url + name.toLowerCase().replace(' ', '-');
        try {
            json = mapper.readTree(Unirest.get(url).asString().getBody());
        } catch (JsonMappingException e) {
            throw new RuntimeException("Errore nel mapping della spell " + name);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Processing error in spell " + name);
        }
        this.name = json.get("name").asText();
        System.out.println(json.get("desc").toString() + "\n\n\n");
        for (JsonNode n : json.get("desc")) {
            this.desc.add(n.asText());
        }
        for (JsonNode n : json.get("higher_level")) {
            this.highLv.add(n.asText());
        }
        for (JsonNode n : json.get("components")) {
            this.components.add(n.asText());
        }
        try{
            this.material = json.get("material").asText();
        } catch (NullPointerException e){
            this.material = "None";
        }
        try {
            this.range = json.get("range").asText();
        } catch (NullPointerException e){
            this.range = "None";
        }
        this.ritual = json.get("ritual").asBoolean();
        this.duration = json.get("duration").asText();
        this.concentration = json.get("concentration").asBoolean();
        try{
            this.dc = json.get("dc").get("dc_type").get("name").asText();
            if(this.dc.equalsIgnoreCase("STR"))
            {
                this.dcInt = 1;
            }
            if(this.dc.equalsIgnoreCase("DEX"))
            {
                this.dcInt = 2;
            }
            if(this.dc.equalsIgnoreCase("CON"))
            {
                this.dcInt = 3;
            }
            if(this.dc.equalsIgnoreCase("INT"))
            {
                this.dcInt = 4;
            }
            if(this.dc.equalsIgnoreCase("WIS"))
            {
                this.dcInt = 5;
            }
            if(this.dc.equalsIgnoreCase("CHA"))
            {
                this.dcInt = 6;
            }
        } catch (NullPointerException e) {
            this.dcInt = 0;
            this.dc = "None";
        }
        this.level = json.get("level").asInt();
        try{
            this.attType = json.get("attack_type").asText();
        } catch (NullPointerException e){
            this.attType = "None";
        }
        this.school = json.get("school").get("name").asText();
    }

    public void addDesc(String desc) {
        this.desc.add(desc);
    }

    public void addHighLv(String highLv) {
        this.highLv.add(highLv);
    }

    public void resetDesc(String desc) {
        this.desc.clear();
        this.desc.add(desc);
    }

    public void resetHighLv(String highLv) {
        this.highLv.clear();
        this.highLv.add(highLv);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDesc() {
        return desc;
    }

    public void setDesc(List<String> desc) {
        this.desc = desc;
    }

    public List<String> getHighLv() {
        return highLv;
    }

    public void setHighLv(List<String> highLv) {
        this.highLv = highLv;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public List<String> getComponents() {
        return components;
    }

    public void setComponents(List<String> components) {
        this.components = components;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Boolean getRitual() {
        return ritual;
    }

    public void setRitual(Boolean ritual) {
        this.ritual = ritual;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Boolean getConcentration() {
        return concentration;
    }

    public void setConcentration(Boolean concentration) {
        this.concentration = concentration;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAttType() {
        return attType;
    }

    public void setAttType(String attType) {
        this.attType = attType;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Spell{" + "name='" + name + '\'' + ",\ndesc=" + desc + ",\nhighLv=" + highLv + ",\nrange='" + range + '\''
                + ",\ncomponents=" + components + ",\nmaterial='" + material + '\'' + ",\nritual=" + ritual + ", \nduration='"
                + duration + '\'' + ", \nconcentration=" + concentration +",\ndc=" + dc + ",\nlevel=" + level +
                ",\nattType='" + attType + '\''
                + ",\nschool='" + school + '\'' + ",\nurl='" + url + '\'' + '}';
    }
}
