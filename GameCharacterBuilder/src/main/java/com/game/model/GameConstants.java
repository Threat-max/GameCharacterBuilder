package com.game.model;


public final class GameConstants {

    // Preset base stats for the Warrior archetype.
    public static final int WARRIOR_BASE_HEALTH = 150;
    public static final int WARRIOR_BASE_MANA = 20;
    public static final int WARRIOR_BASE_STRENGTH = 18;
    public static final int WARRIOR_BASE_AGILITY = 8;
    public static final int WARRIOR_BASE_INTELLIGENCE = 5;

    // Preset base stats for the Mage archetype.
    public static final int MAGE_BASE_HEALTH = 80;
    public static final int MAGE_BASE_MANA = 120;
    public static final int MAGE_BASE_STRENGTH = 4;
    public static final int MAGE_BASE_AGILITY = 7;
    public static final int MAGE_BASE_INTELLIGENCE = 20;

    // Preset base stats for the Archer archetype.
    public static final int ARCHER_BASE_HEALTH = 100;
    public static final int ARCHER_BASE_MANA = 40;
    public static final int ARCHER_BASE_STRENGTH = 10;
    public static final int ARCHER_BASE_AGILITY = 18;
    public static final int ARCHER_BASE_INTELLIGENCE = 8;

    // Validation thresholds.
    public static final int MIN_VALID_HEALTH = 1;
    public static final int MIN_VALID_STAT_VALUE = 0;

    // Default preset names, used by the Director when none is supplied explicitly.
    public static final String DEFAULT_WARRIOR_NAME = "Unnamed Warrior";
    public static final String DEFAULT_MAGE_NAME = "Unnamed Mage";
    public static final String DEFAULT_ARCHER_NAME = "Unnamed Archer";

    private GameConstants() {
        // Utility class: prevent instantiation.
    }
}
