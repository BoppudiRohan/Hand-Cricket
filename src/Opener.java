class Opener extends Batsman {

    Opener(String name) {
        super(name);
    }

    @Override
    int applyBattingBonus(int runs, int ballCount) {
        if (ballCount % 6 == 0) {
            System.out.println("🔥 Power Hit! Runs Doubled!");
            return runs * 2;
        }
        return runs;
    }
}