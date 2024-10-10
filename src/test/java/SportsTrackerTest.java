import org.junit.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class SportsTrackerTest {

    @Test
    public void testLogActivity() {
        SportsTracker sportsTracker = new SportsTracker();
        sportsTracker.logActivity("Running", 30);
        sportsTracker.logActivity("Swimming", 45);
        sportsTracker.logActivity("Cycling", 60);

        assertEquals(3, sportsTracker.activities.size());
        assertEquals(30, sportsTracker.activities.get("Running").get(LocalDate.now()));
        assertEquals(45, sportsTracker.activities.get("Swimming").get(LocalDate.now()));
        assertEquals(60, sportsTracker.activities.get("Cycling").get(LocalDate.now()));
    }

    @Test
    public void testCalculateTotalTime() {
        SportsTracker sportsTracker = new SportsTracker();
        sportsTracker.logActivity("Running", 30);
        sportsTracker.logActivity("Swimming", 45);
        sportsTracker.logActivity("Cycling", 60);

        assertEquals(135, sportsTracker.calculateTotalTime());
    }

}