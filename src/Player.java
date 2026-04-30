import java.util.*;

class Player {
    String name;
    List<Batsman> batsmen;
    int totalScore;

    Player(String name) {
        this.name = name;
        this.batsmen = new ArrayList<>();
        this.totalScore = 0;
    }

    void addBatsman(Batsman b) {
        batsmen.add(b);
    }

    void addScore(int runs) {
        totalScore += runs;
    }
}