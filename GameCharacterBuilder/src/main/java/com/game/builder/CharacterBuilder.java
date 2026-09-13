package com.game.builder;

import com.game.model.ArmorType;
import com.game.model.Character;
import com.game.model.CharacterClass;
import com.game.model.WeaponType;

public interface CharacterBuilder {

    CharacterBuilder setName(String name);

    CharacterBuilder setCharacterClass(CharacterClass characterClass);

    CharacterBuilder setStats(int health, int mana, int strength, int agility, int intelligence);

    CharacterBuilder setWeapon(WeaponType weapon);

    CharacterBuilder setArmor(ArmorType armor);

    CharacterBuilder addSkill(String skill);

    Character build();
}
