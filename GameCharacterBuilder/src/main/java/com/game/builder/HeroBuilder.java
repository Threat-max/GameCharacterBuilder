package com.game.builder;

import com.game.model.ArmorType;
import com.game.model.Character;
import com.game.model.CharacterClass;
import com.game.model.GameConstants;
import com.game.model.Stats;
import com.game.model.WeaponType;

import java.util.ArrayList;
import java.util.List;


public class HeroBuilder implements CharacterBuilder {

    private String name;
    private CharacterClass characterClass;
    private Stats stats;
    private WeaponType weapon = WeaponType.NONE;
    private ArmorType armor = ArmorType.NONE;
    private final List<String> skills = new ArrayList<>();

    @Override
    public CharacterBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public CharacterBuilder setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
        return this;
    }

    @Override
    public CharacterBuilder setStats(int health, int mana, int strength, int agility, int intelligence) {
        this.stats = new Stats(health, mana, strength, agility, intelligence);
        return this;
    }

    @Override
    public CharacterBuilder setWeapon(WeaponType weapon) {
        this.weapon = weapon;
        return this;
    }

    @Override
    public CharacterBuilder setArmor(ArmorType armor) {
        this.armor = armor;
        return this;
    }

    @Override
    public CharacterBuilder addSkill(String skill) {
        this.skills.add(skill);
        return this;
    }

    @Override
    public Character build() {
        validateName();
        validateCharacterClass();
        validateStats();

        return new Character(name, characterClass, stats, weapon, armor, new ArrayList<>(skills));
    }

    private void validateName() {
        if (name == null || name.isBlank()) {
            throw new IllegalStateException("Cannot build a Character: name must not be empty.");
        }
    }

    private void validateCharacterClass() {
        if (characterClass == null) {
            throw new IllegalStateException("Cannot build a Character: characterClass must be set.");
        }
    }

    private void validateStats() {
        if (stats == null) {
            throw new IllegalStateException("Cannot build a Character: stats must be set.");
        }
        if (!stats.hasValidHealth()) {
            throw new IllegalStateException(
                    "Cannot build a Character: health must be at least "
                            + GameConstants.MIN_VALID_HEALTH + ", but was " + stats.getHealth() + ".");
        }
        if (!stats.hasNoNegativeAttributes()) {
            throw new IllegalStateException(
                    "Cannot build a Character: mana/strength/agility/intelligence must not be negative.");
        }
    }
}
