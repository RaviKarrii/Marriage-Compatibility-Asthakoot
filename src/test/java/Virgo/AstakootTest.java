package Virgo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AstakootTest {

    @Test
    void testAstakootCalculations() {
        // Example values:
        // Boy: Ashwini (0), Aries (1) -> Index 0
        // Girl: Bharani (1), Aries (1) -> Index 0
        // Note: Astakoot constructor takes indices directly.
        // Raasi is 1-based in Astakoot logic (e.g. 1=Aries)
        
        int boyNak = 0; // Ashwini
        int girlNak = 1; // Bharani
        int boyRaasi = 1; // Aries
        int girlRaasi = 1; // Aries
        
        Astakoot koot = new Astakoot(boyNak, girlNak, boyRaasi, girlRaasi);
        
        // Varna: Both Aries (Kshatriya) -> 1 point
        assertEquals(1, koot.calcVarnaKoota());
        
        // Vasya: Both Quadruped -> 2 points
        assertEquals(2.0, koot.calcVasyaKoota());
        
        // Tara: 
        // Boy-Girl: 0-1 = -1 -> 26 % 9 = 8 -> Even -> 1.5
        // Girl-Boy: 1-0 = 1 % 9 = 1 -> Odd -> 0
        // Total = 1.5
        assertEquals(1.5, koot.calcDinaKuta());
        
        // Yoni:
        // Boy: Ashwini -> Horse (0)
        // Girl: Bharani -> Elephant (1)
        // YoniArray[1][0] -> 2
        assertEquals("2", koot.calcYoni());
        
        // Maitri:
        // Boy: Aries (Mars)
        // Girl: Aries (Mars)
        // Same lord -> 5
        assertEquals(5.0, koot.calcMaitri());
        
        // Gana:
        // Boy: Ashwini -> Deva (0)
        // Girl: Bharani -> Manushya (1)
        // Girl(1) Boy(0) -> 6 (Manushya - Deva)
        assertEquals(6, koot.calcGanaKuta());
        
        // Bahkut:
        // Both Aries -> 1-1 = 0 -> 7
        assertEquals(7, koot.calcBahkut());
        
        // Nadi:
        // Boy: Ashwini -> Adi (0)
        // Girl: Bharani -> Madhya (1)
        // Different -> 8
        assertEquals(8, koot.calcNadi());
    }
}
