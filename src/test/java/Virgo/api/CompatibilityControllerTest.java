package Virgo.api;

import Virgo.Astakoot;
import Virgo.Horoscope;
import Virgo.Constants;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

// Since CompatibilityController uses `new Horoscope(...)` and `new Astakoot(...)` directly, 
// it's hard to unit test with mocks without refactoring. 
// However, we can write an integration test or a test that mocks the behavior if we refactor.
// For now, let's write a test that sends a request and asserts the response structure, 
// assuming the logic classes work (which we will test separately).
// But wait, `Horoscope` and `Astakoot` are not Spring beans, so we can't mock them easily with @MockBean 
// unless we change the controller to inject them.
// Given the current code, we will write a test that actually executes the logic.
// This effectively becomes an integration test for the controller + logic.

@WebMvcTest(CompatibilityController.class)
class CompatibilityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCalculate() throws Exception {
        String requestJson = "{\n" +
                "    \"boy\": {\n" +
                "        \"name\": \"Boy\",\n" +
                "        \"birthDate\": \"1990-01-01\",\n" +
                "        \"birthTime\": \"10:00\",\n" +
                "        \"latitude\": \"17.3850\",\n" +
                "        \"longitude\": \"78.4867\"\n" +
                "    },\n" +
                "    \"girl\": {\n" +
                "        \"name\": \"Girl\",\n" +
                "        \"birthDate\": \"1992-02-02\",\n" +
                "        \"birthTime\": \"11:00\",\n" +
                "        \"latitude\": \"17.3850\",\n" +
                "        \"longitude\": \"78.4867\"\n" +
                "    }\n" +
                "}";

        mockMvc.perform(post("/api/compatibility/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.boy.name").value("Boy"))
                .andExpect(jsonPath("$.girl.name").value("Girl"))
                .andExpect(jsonPath("$.totalScore").exists());
    }
}
