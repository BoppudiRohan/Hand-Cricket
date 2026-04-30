import org.junit.Test;
import static org.junit.Assert.*;

public class TestAllRounder {

    @Test
    public void testConstructorName() {
        AllRounder ar = new AllRounder("Virat");
        assertEquals("Virat", ar.name);
    }

    @Test
    public void testConstructorDefaults() {
        AllRounder ar = new AllRounder("Virat");
        assertEquals(0, ar.score);
        assertFalse(ar.isOut);
    }

    @Test
    public void testBonusIsBaseOrBasePlusOne() {
        AllRounder ar = new AllRounder("Virat");
        for (int i = 0; i < 100; i++) {
            int result = ar.applyBattingBonus(4, 1);
            assertTrue(result == 4 || result == 5);
        }
    }

    @Test
    public void testBonusTriggersFiftyPercent() {
        AllRounder ar = new AllRounder("Virat");
        int bonusCount = 0;
        for (int i = 0; i < 1000; i++) {
            if (ar.applyBattingBonus(3, 1) == 4) bonusCount++;
        }
        double rate = (double) bonusCount / 1000;
        assertTrue(rate > 0.30 && rate < 0.70);
    }

    @Test
    public void testBonusWithMinimumRuns() {
        AllRounder ar = new AllRounder("Virat");
        int result = ar.applyBattingBonus(1, 1);
        assertTrue(result == 1 || result == 2);
    }

    @Test
    public void testBonusWithMaximumRuns() {
        AllRounder ar = new AllRounder("Virat");
        int result = ar.applyBattingBonus(6, 1);
        assertTrue(result == 6 || result == 7);
    }

    @Test
    public void testAvoidOutAlwaysFalse() {
        AllRounder ar = new AllRounder("Virat");
        assertFalse(ar.avoidOut());
    }
}