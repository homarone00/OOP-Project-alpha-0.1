package Project_take1.spells;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class Spell {
    String name;
    String desc;
    String highLv;
    List<String> components;
    String material;
    Boolean ritual;
    String duration;
    Boolean concentration;
    int level;
    String attType;
    String school;
    String url = "https://www.dnd5eapi.co/api/spells/";
    ObjectMapper mapper = new ObjectMapper();

    public Spell(String name, String desc, String highLv, List<String> components, String material, Boolean ritual, String duration, Boolean concentration, int level, String attType, String school) {
        this.name = name;
        this.desc = desc;
        this.highLv = highLv;
        this.components = components;
        this.material = material;
        this.ritual = ritual;
        this.duration = duration;
        this.concentration = concentration;
        this.level = level;
        this.attType = attType;
        this.school = school;
    }

    public Spell(String name)
    {
        String[] words = name.split("\\s");
        StringBuilder capNameBuild = new StringBuilder();
        for(String w:words)
        {
            capNameBuild.append(w.substring(0,1).toUpperCase());
            capNameBuild.append(w.substring(1).toLowerCase()).append(" ");
        }
        this.name = capNameBuild.toString().trim();
        url = this.url + name.toLowerCase().replace(' ', '-');
        String json = Unirest.get(url).asString().getBody();
        System.out.println(json);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setHighLv(String highLv) {
        this.highLv = highLv;
    }

    public void setComponents(List<String> components) {
        this.components = components;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setRitual(Boolean ritual) {
        this.ritual = ritual;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setConcentration(Boolean concentration) {
        this.concentration = concentration;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setAttType(String attType) {
        this.attType = attType;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getHighLv() {
        return highLv;
    }

    public List<String> getComponents() {
        return components;
    }

    public String getMaterial() {
        return material;
    }

    public Boolean getRitual() {
        return ritual;
    }

    public String getDuration() {
        return duration;
    }

    public Boolean getConcentration() {
        return concentration;
    }

    public int getLevel() {
        return level;
    }

    public String getAttType() {
        return attType;
    }

    public String getSchool() {
        return school;
    }

    public String getUrl() {
        return url;
    }
}
