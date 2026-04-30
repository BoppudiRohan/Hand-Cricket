import org.junit.Test;
import static org.junit.Assert.*;

public class TestWicketKeeper {

    @Test
    public void testConstructorName() {
        WicketKeeper wk = new WicketKeeper("Dhoni");
        assertEquals("Dhoni", wk.name);
    }

    @Test
    public void testConstructorDefaults() {
        WicketKeeper wk = new WicketKeeper("Dhoni");
        assertEquals(0, wk.score);
        assertFalse(wk.isOut);
    }

    @Test
    public void testNoBattingBonus() {
        WicketKeeper wk = new WicketKeeper("Dhoni");
        assertEquals(3, wk.applyBattingBonus(3, 1));
    }

    @Test
    public void testNoBonusOnSixthBall() {
        WicketKeeper wk = new WicketKeeper("Dhoni");
        assertEquals(4, wk.applyBattingBonus(4, 6));
    }

    @Test
    public void testAvoidOutTwentyPercent() {
        WicketKeeper wk = new WicketKeeper("Dhoni");
        int saved = 0;
        for (int i = 0; i < 1000; i++) {
            if (wk.avoidOut()) saved++;
        }
        double rate = (double) saved / 1000;
        assertTrue(rate > 0.10 && rate < 0.35);
    }

    @Test
    public void testAvoidOutNotAlwaysTrue() {
        WicketKeeper wk = new WicketKeeper("Dhoni");
        boolean gotFalse = false;
        for (int i = 0; i < 50; i++) {
            if (!wk.avoidOut()) { gotFalse = true; break; }
        }
        assertTrue(gotFalse);
    }

    @Test
    public void testAvoidOutNotAlwaysFalse() {
        WicketKeeper wk = new WicketKeeper("Dhoni");
        boolean gotTrue = false;
        for (int i = 0; i < 100; i++) {
            if (wk.avoidOut()) { gotTrue = true; break; }
        }
        assertTrue(gotTrue);
    }
}