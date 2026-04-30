import java.util.*;

class Game {

    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    Player human;
    Player cpu;
    int target = 0;

    void startGame() {
        System.out.println("🏏 Welcome to Hand Cricket!");

        human = new Player("You");
        cpu = new Player("CPU");

        setupPlayers();

        boolean humanBatsFirst = toss();

        if (humanBatsFirst) {
            playInnings(human, true);
            target = human.totalScore + 1;

            System.out.println("\nTarget for CPU: " + target);
            playInnings(cpu, false);

        } else {
            playInnings(cpu, false);
            target = cpu.totalScore + 1;

            System.out.println("\nTarget for You: " + target);
            playInnings(human, true);
        }

        declareWinner();
    }

    void setupPlayers() {
        System.out.println("\nEnter 3 player names:");

        String n1 = sc.nextLine();
        String n2 = sc.nextLine();
        String n3 = sc.nextLine();

        human.addBatsman(new Opener(n1));
        human.addBatsman(new AllRounder(n2));
        human.addBatsman(new WicketKeeper(n3));

        cpu.addBatsman(new Opener("CPU_Opener"));
        cpu.addBatsman(new AllRounder("CPU_AllRounder"));
        cpu.addBatsman(new WicketKeeper("CPU_WK"));
    }

    boolean toss() {
        System.out.println("\nChoose heads/tails:");
        String choice = sc.nextLine().toLowerCase();

        String result = rand.nextBoolean() ? "heads" : "tails";
        System.out.println("Toss: " + result);

        return choice.equals(result);
    }

    void playInnings(Player batting, boolean isHumanBatting) {
        for (Batsman b : batting.batsmen) {

            int ballCount = 1;
            System.out.println("\nBatting: " + b.name);

            while (!b.isOut) {

                int batNum;
                int bowlNum;

                if (isHumanBatting) {
                    System.out.print("Enter (1-6): ");
                    batNum = sc.nextInt();

                    bowlNum = rand.nextInt(6) + 1;
                    System.out.println("CPU: " + bowlNum);

                } else {
                    System.out.print("Your bowl (1-6): ");
                    bowlNum = sc.nextInt();

                    while (bowlNum < 1 || bowlNum > 6) {
                        System.out.print("Invalid! Enter 1-6: ");
                        bowlNum = sc.nextInt();
                    }

                    batNum = rand.nextInt(6) + 1;

                    // reveal AFTER input
                    System.out.println("CPU played: " + batNum);
                }

                if (batNum == bowlNum) {
                    if (!b.avoidOut()) {
                        b.isOut = true;
                        System.out.println("OUT!");
                        break;
                    } else {
                        System.out.println("Saved!");
                    }
                } else {
                    int runs = b.applyBattingBonus(batNum, ballCount);
                    b.score += runs;
                    batting.addScore(runs);

                    System.out.println("Scored: " + runs);

                }

                ballCount++;

                if (batting.totalScore >= target && target != 0) {
                    return;
                }
            }
        }
    }

    void declareWinner() {
        System.out.println("\nYou: " + human.totalScore);
        System.out.println("CPU: " + cpu.totalScore);

        if (human.totalScore > cpu.totalScore)
            System.out.println("You Win!");
        else if (human.totalScore < cpu.totalScore)
            System.out.println("CPU Wins!");
        else
            System.out.println("Draw!");
    }
}