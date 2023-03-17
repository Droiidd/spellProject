package com.csc340.jpacruddemo.spell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/spell")
public class SpellController {

    @Autowired
    private SpellService service;

    @GetMapping("/all")
    public String getAllSpells(Model model) {
        model.addAttribute("spellList", service.getAllSpells());
        return "spell/list-spells";
    }

    @GetMapping("/id={id}")
    public String getSpell(@PathVariable long id, Model model) {
        model.addAttribute("spell", service.getSpell(id));
        return "spell/spell-detail";
    }

    @GetMapping("/delete/id={id}")
    public String deleteSpell(@PathVariable long id, Model model) {
        service.deleteSpell(id);
        return "redirect:/spell/all";
    }

    @PostMapping("/create")
    public String createSpell(Spell spell) {
        service.saveSpell(spell);
        return "redirect:/spell/all";
    }

    @PostMapping("/update")
    public String updateSpell(Spell spell) {
        service.updateSpell(spell);
        return "redirect:/spell/all";
    }

    @GetMapping("/new-spell")
    public String newSpellForm(Model model) {
        return "spell/new-spell";
    }

    @GetMapping("/update/id={id}")
    public String updateSpellForm(@PathVariable long id, Model model) {
        model.addAttribute("spell", service.getSpell(id));
        return "spell/update-spell";
    }
}
