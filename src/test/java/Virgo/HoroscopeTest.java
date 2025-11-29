package Virgo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HoroscopeTest {

    @Test
    void testHoroscopeProcess() {
        // 1st Jan 2000, 12:00 PM, Hyderabad
        String name = "Test";
        String dob = "01/01/2000";
        String time = "12:00:00";
        String lat = "17.3850";
        String lon = "78.4867";
        
        Horoscope h = new Horoscope(name, dob, time, lat, lon);
        
        // This might fail if swisseph library is not found or initialized correctly
        // But we want to test if it works.
        try {
            h.process();
            
            assertFalse(h.planetlist.isEmpty());
            assertEquals(8, h.planetlist.size()); // 8 planets as per planets array
            
            // Check Sun (index 0)
            Planet sun = h.planetlist.get(0);
            assertEquals("Sun", sun.Name);
            assertNotNull(sun.Nakshatra);
            assertNotNull(sun.Raasi);
            
        } catch (Exception e) {
            fail("Horoscope processing failed: " + e.getMessage());
        }
    }
}
