import java.util.Random;

class WicketKeeper extends Batsman {
    Random rand = new Random();

    WicketKeeper(String name) {
        super(name);
    }

    @Override
    int applyBattingBonus(int runs, int ballCount) {
        return runs;
    }

    @Override
    boolean avoidOut() {
        if (rand.nextInt(100) < 20) {
            System.out.println("🧤 WicketKeeper Saved!");
            return true;
        }
        return false;
    }
}
