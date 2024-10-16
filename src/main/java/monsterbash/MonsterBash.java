package monsterbash;

public class MonsterBash {
    public static final double cardWidth = 100;
    public static final double cardHeight = 150;
    public static final int fontSize = 10;

    static MonsterBoard board = null;

    public static void buildCards() {
        // TODO: refactor this to be from a data source and not hardcoded
        MonsterStats stats = new MonsterStats();
        stats.attack = 9;
        stats.hp = 8;
        stats.cost = 8;
        MonsterDeck.createCard("Angry Aligator", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        MonsterDeck.createCard("Apprentice Wizard", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        MonsterDeck.createCard("Box Wizard", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        MonsterDeck.createCard("Cooligator", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        MonsterDeck.createCard("Fire Fighter", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        MonsterDeck.createCard("Runestone Golem", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        MonsterDeck.createCard("Woad Blade", stats);

        board = new MonsterBoard();
    }
}
