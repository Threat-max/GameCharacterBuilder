package com.game.director;

import com.game.builder.CharacterBuilder;
import com.game.model.ArmorType;
import com.game.model.Character;
import com.game.model.CharacterClass;
import com.game.model.GameConstants;
import com.game.model.WeaponType;


public class CharacterDirector {

    public Character makeWarrior(CharacterBuilder builder, String name) {
        return builder
                .setName(name)
                .setCharacterClass(CharacterClass.WARRIOR)
                .setStats(
                        GameConstants.WARRIOR_BASE_HEALTH,
                        GameConstants.WARRIOR_BASE_MANA,
                        GameConstants.WARRIOR_BASE_STRENGTH,
                        GameConstants.WARRIOR_BASE_AGILITY,
                        GameConstants.WARRIOR_BASE_INTELLIGENCE)
                .setWeapon(WeaponType.SWORD)
                .setArmor(ArmorType.PLATE)
                .addSkill("Shield Bash")
                .addSkill("Whirlwind Strike")
                .build();
    }

    public Character makeMage(CharacterBuilder builder, String name) {
        return builder
                .setName(name)
                .setCharacterClass(CharacterClass.MAGE)
                .setStats(
                        GameConstants.MAGE_BASE_HEALTH,
                        GameConstants.MAGE_BASE_MANA,
                        GameConstants.MAGE_BASE_STRENGTH,
                        GameConstants.MAGE_BASE_AGILITY,
                        GameConstants.MAGE_BASE_INTELLIGENCE)
                .setWeapon(WeaponType.STAFF)
                .setArmor(ArmorType.ROBE)
                .addSkill("Fireball")
                .addSkill("Arcane Shield")
                .build();
    }

    public Character makeArcher(CharacterBuilder builder, String name) {
        return builder
                .setName(name)
                .setCharacterClass(CharacterClass.ARCHER)
                .setStats(
                        GameConstants.ARCHER_BASE_HEALTH,
                        GameConstants.ARCHER_BASE_MANA,
                        GameConstants.ARCHER_BASE_STRENGTH,
                        GameConstants.ARCHER_BASE_AGILITY,
                        GameConstants.ARCHER_BASE_INTELLIGENCE)
                .setWeapon(WeaponType.BOW)
                .setArmor(ArmorType.LEATHER)
                .addSkill("Rapid Shot")
                .addSkill("Eagle Eye")
                .build();
    }
}
