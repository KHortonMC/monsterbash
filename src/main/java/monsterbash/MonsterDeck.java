package monsterbash;

import java.util.LinkedList;

public class MonsterDeck extends CardDeck {
    private void createCard(String name, MonsterStats stats) {
        MonsterCard card = new MonsterCard(name, stats);
        card.setVisible(false);
        cardDeck.add(card);
    }

    public void buildDeck() {
        // TODO: refactor this to be from a data source and not hardcoded
        MonsterStats stats = new MonsterStats();
        stats.attack = 9;
        stats.hp = 8;
        stats.cost = 8;
        createCard("Angry Aligator", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        createCard("Apprentice Wizard", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        createCard("Box Wizard", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        createCard("Cooligator", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        createCard("Fire Fighter", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        createCard("Runestone Golem", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        createCard("Woad Blade", stats);

        stats = new MonsterStats();
        stats.attack = 9;
        stats.hp = 8;
        stats.cost = 8;
        createCard("Angry Aligator", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        createCard("Apprentice Wizard", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        createCard("Box Wizard", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        createCard("Cooligator", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        createCard("Fire Fighter", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        createCard("Runestone Golem", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        createCard("Woad Blade", stats);

        stats = new MonsterStats();
        stats.attack = 9;
        stats.hp = 8;
        stats.cost = 8;
        createCard("Angry Aligator", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        createCard("Apprentice Wizard", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        createCard("Box Wizard", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        createCard("Cooligator", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        createCard("Fire Fighter", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        createCard("Runestone Golem", stats);

        stats = new MonsterStats();
        stats.attack = 4;
        stats.hp = 4;
        stats.cost = 4;
        createCard("Woad Blade", stats);
    }
}
