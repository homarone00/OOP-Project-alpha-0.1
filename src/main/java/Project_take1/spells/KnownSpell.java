package Project_take1.spells;

import Project_take1.utils.SavingUtils;

import java.sql.SQLException;
import java.util.*;

public class KnownSpell {
    Set<Spell> spells = new HashSet<>();
    UUID id;

    public KnownSpell(UUID id) {
        this.id = id;
    }

    public void insert(Spell spell) {
        spell.setId(id);
        if(spells.contains(spell)){
            return;
        }
        spells.add(spell);
        try {
            SavingUtils.insertSpell(id, spell);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Set<Spell> getSpells() {
        return spells;
    }
    public ArrayList<Spell> getArraySpells(){
        ArrayList<Spell> arraySpells =new ArrayList<>(spells);
        return  arraySpells;
    }
    public void setSpells(Set<Spell> spells) {
        this.spells = spells;
    }
    public Spell getSpell(String spell){
        Iterator<Spell> s = spells.iterator();
        while (s.hasNext()){
            Spell sp = s.next();
            if(sp.getName().equals(spell)){
                return sp;
            }
        }
        throw new RuntimeException("La spell non c'è");
    }
    public Spell getSpell(Spell s){
        Iterator<Spell> spell = spells.iterator();
        while (spell.hasNext()){
            Spell sp = spell.next();
            if(sp.getName().equals(s)){
                return sp;
            }
        }
        throw new RuntimeException("La spell non c'è");
    }
    public void delete(Spell spell){
        spells.remove(spell);
        try{
            SavingUtils.deleteSpell(id, spell);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
