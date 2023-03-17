package com.csc340.jpacruddemo.spell;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SpellService {
    @Autowired
    SpellRepository repo;
    List<Spell> getAllSpells() {
        return repo.findAll();
    }

    Object getSpell(long id) {
        return repo.getSpellById(id);
    }

    void deleteSpell(long id) {
        repo.deleteSpellById(id);
    }

    void saveSpell(Spell spell) {
        repo.saveSpell(spell);
    }

    void updateSpell(Spell spell) {
        repo.updateSpell(spell);
    }

}
