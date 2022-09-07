package Project_take1.spells;

import Project_take1.utils.SavingUtils;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

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
}
