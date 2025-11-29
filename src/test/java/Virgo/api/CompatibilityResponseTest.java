package Virgo.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompatibilityResponseTest {

    @Test
    void testCompatibilityResponse() {
        CompatibilityResponse response = new CompatibilityResponse();
        
        CompatibilityResponse.PersonResult boy = new CompatibilityResponse.PersonResult("Boy", "Ashwini", "Aries");
        CompatibilityResponse.PersonResult girl = new CompatibilityResponse.PersonResult("Girl", "Bharani", "Aries");
        
        response.setBoy(boy);
        response.setGirl(girl);
        
        assertEquals("Boy", response.getBoy().getName());
        assertEquals("Ashwini", response.getBoy().getNakshatra());
        assertEquals("Aries", response.getBoy().getRaasi());
        
        assertEquals("Girl", response.getGirl().getName());
        assertEquals("Bharani", response.getGirl().getNakshatra());
        assertEquals("Aries", response.getGirl().getRaasi());
        
        CompatibilityResponse.KootaScore score = new CompatibilityResponse.KootaScore(1.0, 1.0);
        response.setVarna(score);
        
        assertEquals(1.0, response.getVarna().getMax());
        assertEquals(1.0, response.getVarna().getObtained());
        
        response.setTotalScore(30.0);
        assertEquals(30.0, response.getTotalScore());
    }
}
