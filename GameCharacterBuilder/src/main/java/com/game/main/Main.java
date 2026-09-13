package com.game.main;

import com.game.builder.CharacterBuilder;
import com.game.builder.HeroBuilder;
import com.game.director.CharacterDirector;
import com.game.model.ArmorType;
import com.game.model.Character;
import com.game.model.CharacterClass;
import com.game.model.WeaponType;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== 1. Manual construction via Builder (method chaining) ===");
        CharacterBuilder manualBuilder = new HeroBuilder();
        Character customHero = manualBuilder
                .setName("Elysia")
                .setCharacterClass(CharacterClass.ARCHER)
                .setStats(95, 45, 9, 20, 10)
                .setWeapon(WeaponType.BOW)
                .setArmor(ArmorType.LEATHER)
                .addSkill("Poison Arrow")
                .addSkill("Camouflage")
                .build();
        System.out.println(customHero);

        System.out.println();
        System.out.println("=== 2. Preset construction via Director ===");
        CharacterDirector director = new CharacterDirector();

        Character warrior = director.makeWarrior(new HeroBuilder(), "Thrain");
        System.out.println(warrior);

        Character mage = director.makeMage(new HeroBuilder(), "Isolde");
        System.out.println(mage);

        Character archer = director.makeArcher(new HeroBuilder(), "Rowan");
        System.out.println(archer);

        System.out.println();
        System.out.println("=== 3. Validation failure demo (Fail-Fast) ===");
        try {
            new HeroBuilder()
                    .setName("")                       // invalid: blank name
                    .setCharacterClass(CharacterClass.WARRIOR)
                    .setStats(0, 10, 5, 5, 5)           // invalid: health <= 0
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }
    }
}
