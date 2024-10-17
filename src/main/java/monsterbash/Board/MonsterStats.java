package monsterbash.Board;

public final class MonsterStats {
    public int attack = 0;
    public int hp = 0;
    public int cost = 0;

    // TODO: add custom powers to the monsters!

    public MonsterStats() {}

    public String toString() {
        return "AT: " + attack + " HP: " + hp + " COST: " + cost;
    }
}
