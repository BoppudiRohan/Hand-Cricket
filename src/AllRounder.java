import java.util.Random;

class AllRounder extends Batsman {
    Random rand = new Random();

    AllRounder(String name) {
        super(name);
    }

    @Override
    int applyBattingBonus(int runs, int ballCount) {
        if (rand.nextBoolean()) {
            System.out.println("🎯 AllRounder Bonus +1 Run!");
            return runs + 1;
        }
        return runs;
    }
}