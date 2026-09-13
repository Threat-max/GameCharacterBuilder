# Game Character Builder

A small Java project demonstrating the **Builder** design pattern through
the domain of a game character (health, mana, strength, agility,
intelligence, class, equipment and skills).

## Package structure

```
com.game.model     Character (Product), Stats, CharacterClass, WeaponType, ArmorType, GameConstants
com.game.builder    CharacterBuilder (interface), HeroBuilder (concrete Builder)
com.game.director   CharacterDirector
com.game.main       Main (Client)
```

## Running

```bash
javac -d out $(find src -name "*.java")
java -cp out com.game.main.Main
```

`Main` demonstrates three things:
1. Manual construction of a `Character` via fluent method chaining.
2. Construction of preset characters (Warrior / Mage / Archer) via `CharacterDirector`.
3. A deliberately invalid build (blank name + non-positive health) that is
   caught and reported as an `IllegalStateException`, to show fail-fast validation.

---

## Clean Code principles applied

### 1. Meaningful Names

Every class, method and variable is named after what it represents, not
how it is implemented. `CharacterBuilder.setStats(...)`, `addSkill(...)`,
`CharacterDirector.makeWarrior(...)` all read like domain vocabulary
rather than generic getters/setters.

**Before:**
```java
public HB s(String n, int h, int m) { ... } // what is "s"? what is "h"?
```

**After:**
```java
public CharacterBuilder setStats(int health, int mana, int strength,
                                  int agility, int intelligence) { ... }
```

### 2. Single Responsibility Principle / Small Methods

`HeroBuilder.build()` doesn't validate everything inline in one giant
block — it delegates to `validateName()`, `validateCharacterClass()` and
`validateStats()`, each responsible for exactly one invariant. Likewise,
`CharacterDirector` only knows *sequences* of builder calls; it never
constructs a `Character` object directly.

**Before:**
```java
public Character build() {
    if (name == null || name.isBlank()) throw new IllegalStateException("...");
    if (characterClass == null) throw new IllegalStateException("...");
    if (stats == null || stats.getHealth() <= 0) throw new IllegalStateException("...");
    // ... 30 more lines mixing validation and construction
}
```

**After:**
```java
public Character build() {
    validateName();
    validateCharacterClass();
    validateStats();
    return new Character(name, characterClass, stats, weapon, armor, new ArrayList<>(skills));
}
```

### 3. Validated Construction / Fail-Fast

A `Character` can only come into existence through `HeroBuilder.build()`,
and `build()` refuses to produce an inconsistent object — it throws a
clear `IllegalStateException` immediately instead of letting bad data
propagate into the rest of the program.

**Before:**
```java
Character hero = new Character("", null, null, null, null, null); // silently broken object
```

**After:**
```java
new HeroBuilder().setName("").setCharacterClass(CharacterClass.WARRIOR)
        .setStats(0, 10, 5, 5, 5).build();
// throws: IllegalStateException: Cannot build a Character: name must not be empty.
```

### 4. No Magic Numbers / Strings

Every raw literal that means something (base stats, preset names,
validation thresholds) is pulled into `GameConstants`, and every
categorical value (class, weapon, armor) is an `enum` instead of a
free-text `String`.

**Before:**
```java
builder.setCharacterClass("warrior") // typo-prone, no compiler help
       .setStats(150, 20, 18, 8, 5); // what do these numbers mean?
```

**After:**
```java
builder.setCharacterClass(CharacterClass.WARRIOR)
       .setStats(GameConstants.WARRIOR_BASE_HEALTH,
                 GameConstants.WARRIOR_BASE_MANA,
                 GameConstants.WARRIOR_BASE_STRENGTH,
                 GameConstants.WARRIOR_BASE_AGILITY,
                 GameConstants.WARRIOR_BASE_INTELLIGENCE);
```

### 5. Fluent API & Encapsulation

`Character`'s fields are all `private final`, exposed only through
getters and a descriptive `toString()`; its skill list is returned as an
unmodifiable view so callers can't mutate internal state. Every
`HeroBuilder` setter returns `this`, so a character can be assembled as
one readable chain instead of a sequence of disconnected statements.

**Before:**
```java
HeroBuilder b = new HeroBuilder();
b.setName("Elysia");
b.setCharacterClass(CharacterClass.ARCHER);
b.setWeapon(WeaponType.BOW);
Character c = b.build();
```

**After:**
```java
Character c = new HeroBuilder()
        .setName("Elysia")
        .setCharacterClass(CharacterClass.ARCHER)
        .setWeapon(WeaponType.BOW)
        .setArmor(ArmorType.LEATHER)
        .addSkill("Poison Arrow")
        .build();
```

---

## Suggested Git commit sequence (3+ commits)

1. `feat: add Character model, enums and constants`
   — `Character`, `Stats`, `CharacterClass`, `WeaponType`, `ArmorType`, `GameConstants`.
2. `feat: implement CharacterBuilder interface and HeroBuilder with validation`
   — `CharacterBuilder`, `HeroBuilder` (fluent setters + fail-fast `build()`).
3. `feat: add CharacterDirector with Warrior/Mage/Archer presets`
   — `CharacterDirector`.
4. `feat: add Main demo and README with Clean Code write-up`
   — `Main`, `README.md`.
