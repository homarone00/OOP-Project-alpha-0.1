package Project_take1.spells;

import Project_take1.MyCharacter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import Project_take1.utils.SavingUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import kong.unirest.Unirest;

public class Spell {
    UUID id;
    String name;
    ArrayList<String> desc = new ArrayList<>();
    ArrayList<String> highLv = new ArrayList<>();
    String range;
    ArrayList<String> components = new ArrayList<>();
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

    public Spell(String name, ArrayList<String> desc, ArrayList<String> highLv, String range, ArrayList<String> components,
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

    public Spell(String name, String desc, String highLv, String range, ArrayList<String> components, String material,
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
        if(id != null){
            try{
                SavingUtils.updateSpell(id, this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addHighLv(String highLv) {
        this.highLv.add(highLv);
        if(id != null){
            try{
                SavingUtils.updateSpell(id, this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void resetDesc(String desc) {
        this.desc.clear();
        this.desc.add(desc);
        if(id != null){
            try{
                SavingUtils.updateSpell(id, this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void resetHighLv(String highLv) {
        this.highLv.clear();
        this.highLv.add(highLv);
        if(id != null){
            try{
                SavingUtils.updateSpell(id, this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getDesc() {
        return desc;
    }

    public void setDesc(ArrayList<String> desc) {
        this.desc = desc;
        if(id != null){
            try{
                SavingUtils.updateSpell(id, this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<String> getHighLv() {
        return highLv;
    }

    public void setHighLv(ArrayList<String> highLv) {
        this.highLv = highLv;
        if(id != null){
            try{
                SavingUtils.updateSpell(id, this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
        if(id != null){
            try{
                SavingUtils.updateSpell(id, this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<String> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<String> components) {
        this.components = components;
        if(id != null){
            try{
                SavingUtils.updateSpell(id, this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
        if(id != null){
            try{
                SavingUtils.updateSpell(id, this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Boolean getRitual() {
        return ritual;
    }

    public void setRitual(Boolean ritual) {
        this.ritual = ritual;
        if(id != null){
            try{
                SavingUtils.updateSpell(id, this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
        if(id != null){
            try{
                SavingUtils.updateSpell(id, this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Boolean getConcentration() {
        return concentration;
    }

    public void setConcentration(Boolean concentration) {
        this.concentration = concentration;
        if(id != null){
            try{
                SavingUtils.updateSpell(id, this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        if(id != null){
            try{
                SavingUtils.updateSpell(id, this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getAttType() {
        return attType;
    }

    public void setAttType(String attType) {
        this.attType = attType;
        if(id != null){
            try{
                SavingUtils.updateSpell(id, this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
        if(id != null){
            try{
                SavingUtils.updateSpell(id, this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
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


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Spell spell = (Spell) o;
        if(id == null){
            return name.equals(spell.name);
        } else {
            return name.equals(spell.name) && id.equals(spell.id);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    public String getDc() {
        return dc;
    }

    public int getDcInt() {
        return dcInt;

    }

    public void setDcInt(int dcInt) {
        if(dcInt < 0 || dcInt > 6){
            throw new IllegalArgumentException("dcInt deve essere tra 0 e 6");
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
        try{
            SavingUtils.updateSpell(id, this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
