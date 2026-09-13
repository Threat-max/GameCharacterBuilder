package com.game.model;

import java.util.Collections;
import java.util.List;

public final class  Character {

    private final String name;
    private final CharacterClass characterClass;
    private final Stats stats;
    private final WeaponType weapon;
    private final ArmorType armor;
    private final List<String> skills;

    public Character(String name,
                      CharacterClass characterClass,
                      Stats stats,
                      WeaponType weapon,
                      ArmorType armor,
                      List<String> skills) {
        this.name = name;
        this.characterClass = characterClass;
        this.stats = stats;
        this.weapon = weapon;
        this.armor = armor;
        // Defensive copy + unmodifiable wrapper: callers cannot mutate
        // the character's skill list after construction.
        this.skills = Collections.unmodifiableList(skills);
    }

    public String getName() {
        return name;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public Stats getStats() {
        return stats;
    }

    public WeaponType getWeapon() {
        return weapon;
    }

    public ArmorType getArmor() {
        return armor;
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "Character{"
                + "name='" + name + '\''
                + ", class=" + characterClass
                + ", stats=[" + stats + ']'
                + ", weapon=" + weapon
                + ", armor=" + armor
                + ", skills=" + skills
                + '}';
    }
}
