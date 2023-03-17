package com.csc340.jpacruddemo.spell;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class SpellRepository {
    @Autowired
    NamedParameterJdbcTemplate template;

    List<Spell> findAll() {

        String query = "select id, spell_name,spell_effects from spell";
        return template.query(query,
                (result, rowNum)
                -> new Spell(result.getLong("id"),
                        result.getString("spell_name"), result.getString(
                        "spell_effects")));
    }

    public Spell getSpellById(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "id", id);
        String query = "select * from spell where id=:id ";
        return template.queryForObject(query, namedParameters,
                BeanPropertyRowMapper.newInstance(Spell.class));
    }

    public int saveSpell(Spell spell) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("spell_name", spell.getSpellName());
        paramMap.put("spell_effects", spell.getSpellEffects());
        String query = "INSERT INTO spell(spell_name,spell_effects) VALUES(:spell_name, :spell_effects)";
        return template.update(query, paramMap);
    }

    void deleteSpellById(long id) {

        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "id", id);
        String query = "delete from spell where id=:id";
        template.update(query, namedParameters);
    }

    void updateSpell(Spell spell) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", spell.getId());
        paramMap.put("spell_name", spell.getSpellName());
        paramMap.put("spell_effects", spell.getSpellEffects());
        String query = "update spell set spell_name=:spell_name, spell_effects=:spell_effects where id=:id ";
        template.update(query, paramMap);
    }
}
