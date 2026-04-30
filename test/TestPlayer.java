import org.junit.Test;
import static org.junit.Assert.*;

public class TestPlayer {

    @Test
    public void testConstructorName() {
        Player p = new Player("You");
        assertEquals("You", p.name);
    }

    @Test
    public void testConstructorDefaults() {
        Player p = new Player("You");
        assertEquals(0, p.totalScore);
        assertEquals(0, p.batsmen.size());
    }

    @Test
    public void testAddOneBatsman() {
        Player p = new Player("You");
        Opener opener = new Opener("Rohan");
        p.addBatsman(opener);
        assertEquals(1, p.batsmen.size());
        assertTrue(p.batsmen.contains(opener));
    }

    @Test
    public void testAddThreeBatsmenInOrder() {
        Player p = new Player("You");
        Opener opener   = new Opener("Rohan");
        AllRounder ar   = new AllRounder("Virat");
        WicketKeeper wk = new WicketKeeper("Dhoni");
        p.addBatsman(opener);
        p.addBatsman(ar);
        p.addBatsman(wk);
        assertEquals(3, p.batsmen.size());
        assertEquals(opener, p.batsmen.get(0));
        assertEquals(ar,     p.batsmen.get(1));
        assertEquals(wk,     p.batsmen.get(2));
    }

    @Test
    public void testAddScoreOnce() {
        Player p = new Player("You");
        p.addScore(4);
        assertEquals(4, p.totalScore);
    }

    @Test
    public void testAddScoreAccumulates() {
        Player p = new Player("You");
        p.addScore(4);
        p.addScore(6);
        p.addScore(2);
        assertEquals(12, p.totalScore);
    }

    @Test
    public void testAddZeroRunsNoChange() {
        Player p = new Player("You");
        p.addScore(5);
        p.addScore(0);
        assertEquals(5, p.totalScore);
    }
}