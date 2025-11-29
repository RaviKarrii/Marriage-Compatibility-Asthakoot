package Virgo.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompatibilityRequestTest {

    @Test
    void testCompatibilityRequest() {
        CompatibilityRequest request = new CompatibilityRequest();
        CompatibilityRequest.PersonDetails boy = new CompatibilityRequest.PersonDetails();
        boy.setName("Boy");
        boy.setBirthDate("1990-01-01");
        boy.setBirthTime("10:00");
        boy.setLatitude("12.34");
        boy.setLongitude("56.78");

        CompatibilityRequest.PersonDetails girl = new CompatibilityRequest.PersonDetails();
        girl.setName("Girl");
        girl.setBirthDate("1992-02-02");
        girl.setBirthTime("11:00");
        girl.setLatitude("12.34");
        girl.setLongitude("56.78");

        request.setBoy(boy);
        request.setGirl(girl);

        assertEquals("Boy", request.getBoy().getName());
        assertEquals("1990-01-01", request.getBoy().getBirthDate());
        assertEquals("10:00", request.getBoy().getBirthTime());
        assertEquals("12.34", request.getBoy().getLatitude());
        assertEquals("56.78", request.getBoy().getLongitude());

        assertEquals("Girl", request.getGirl().getName());
        assertEquals("1992-02-02", request.getGirl().getBirthDate());
        assertEquals("11:00", request.getGirl().getBirthTime());
        assertEquals("12.34", request.getGirl().getLatitude());
        assertEquals("56.78", request.getGirl().getLongitude());
    }
}
