package com.game.model;


public final class Stats {

    private final int health;
    private final int mana;
    private final int strength;
    private final int agility;
    private final int intelligence;

    public Stats(int health, int mana, int strength, int agility, int intelligence) {
        this.health = health;
        this.mana = mana;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public boolean hasValidHealth() {
        return health >= GameConstants.MIN_VALID_HEALTH;
    }

    public boolean hasNoNegativeAttributes() {
        return mana >= GameConstants.MIN_VALID_STAT_VALUE
                && strength >= GameConstants.MIN_VALID_STAT_VALUE
                && agility >= GameConstants.MIN_VALID_STAT_VALUE
                && intelligence >= GameConstants.MIN_VALID_STAT_VALUE;
    }

    @Override
    public String toString() {
        return "HP=" + health
                + ", MP=" + mana
                + ", STR=" + strength
                + ", AGI=" + agility
                + ", INT=" + intelligence;
    }
}
