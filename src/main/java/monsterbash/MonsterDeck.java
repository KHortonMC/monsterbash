package monsterbash;

import java.util.LinkedList;

public class MonsterDeck {
    static LinkedList<MonsterCard> monsterCards = new LinkedList<MonsterCard>();

    static void createCard(String name, MonsterStats stats) {
        MonsterCard card = new MonsterCard(name, stats);
        card.setVisible(false);

        monsterCards.add(card);
    }

    static void shuffle() {
        // TODO: some shuffle logic
    }

    static MonsterCard draw() {
        MonsterCard retVal = monsterCards.get(0);
        monsterCards.removeFirst();
        return retVal;
    }

    static void discard(MonsterCard card) {
        monsterCards.addLast(card);
    }
}
