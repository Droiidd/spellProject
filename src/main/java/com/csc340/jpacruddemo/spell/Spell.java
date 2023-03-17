package com.csc340.jpacruddemo.spell;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "spell")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Spell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String spellName;
    private String spellEffects;

    public Spell(String spellName, String spellEffects) {
        this.spellName = spellName;
        this.spellEffects = spellEffects;
    }
    
    
}
