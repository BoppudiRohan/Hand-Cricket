import org.junit.Test;
import static org.junit.Assert.*;

public class TestOpener {

    @Test
    public void testRunsDoubledOnSixthBall() {
        Opener opener = new Opener("Rohan");
        assertEquals(6, opener.applyBattingBonus(3, 6));
    }

    @Test
    public void testNoBonusOnNormalBall() {
        Opener opener = new Opener("Rohan");
        assertEquals(4, opener.applyBattingBonus(4, 3));
    }
}