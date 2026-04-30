abstract class Batsman {
    String name;
    int score;
    boolean isOut;

    Batsman(String name) {
        this.name = name;
        this.score = 0;
        this.isOut = false;
    }

    abstract int applyBattingBonus(int runs, int ballCount);

    boolean avoidOut() {
        return false;
    }
}
