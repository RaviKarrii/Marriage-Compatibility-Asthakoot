package Virgo.api;

import Virgo.Astakoot;
import Virgo.Constants;
import Virgo.Horoscope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/compatibility")
public class CompatibilityController {

    private final String[] Raasi = {"","Aries","Taurus","Gemini","Cancer","Leo","Virgo","Libra","Scorpio","Sagittarius","Capricorn","Aquarius","Pisces"};

    @PostMapping("/calculate")
    public CompatibilityResponse calculate(@RequestBody CompatibilityRequest request) {
        CompatibilityRequest.PersonDetails boyDetails = request.getBoy();
        CompatibilityRequest.PersonDetails girlDetails = request.getGirl();

        Horoscope boy = new Horoscope(boyDetails.getName(), boyDetails.getBirthDate(), boyDetails.getBirthTime(), boyDetails.getLatitude(), boyDetails.getLongitude());
        Horoscope girl = new Horoscope(girlDetails.getName(), girlDetails.getBirthDate(), girlDetails.getBirthTime(), girlDetails.getLatitude(), girlDetails.getLongitude());

        boy.process();
        girl.process();

        // Index 1 is Moon in the planet list (see Horoscope.java: planets array, index 1 is SE_MOON)
        int boyNakshatra = Integer.parseInt(boy.planetlist.get(1).Nakshatra);
        int girlNakshatra = Integer.parseInt(girl.planetlist.get(1).Nakshatra);
        int boyRaasi = Integer.parseInt(boy.planetlist.get(1).Raasi);
        int girlRaasi = Integer.parseInt(girl.planetlist.get(1).Raasi);

        Astakoot koot = new Astakoot(boyNakshatra, girlNakshatra, boyRaasi, girlRaasi);
        Constants constants = new Constants();

        CompatibilityResponse response = new CompatibilityResponse();

        response.setBoy(new CompatibilityResponse.PersonResult(
                boyDetails.getName(),
                constants.nakshatra[boyNakshatra],
                Raasi[boyRaasi]
        ));

        response.setGirl(new CompatibilityResponse.PersonResult(
                girlDetails.getName(),
                constants.nakshatra[girlNakshatra],
                Raasi[girlRaasi]
        ));

        response.setVarna(new CompatibilityResponse.KootaScore(1, koot.calcVarnaKoota()));
        response.setVaisya(new CompatibilityResponse.KootaScore(2, koot.calcVasyaKoota()));
        response.setTara(new CompatibilityResponse.KootaScore(3, koot.calcDinaKuta()));
        response.setYoni(new CompatibilityResponse.KootaScore(4, Double.parseDouble(koot.calcYoni())));
        response.setMaitri(new CompatibilityResponse.KootaScore(5, koot.calcMaitri()));
        response.setGana(new CompatibilityResponse.KootaScore(6, koot.calcGanaKuta()));
        response.setBahkut(new CompatibilityResponse.KootaScore(7, koot.calcBahkut()));
        response.setNadi(new CompatibilityResponse.KootaScore(8, koot.calcNadi()));

        double total = koot.calcVarnaKoota() + koot.calcVasyaKoota() + koot.calcDinaKuta() +
                Double.parseDouble(koot.calcYoni()) + koot.calcMaitri() + koot.calcGanaKuta() +
                koot.calcBahkut() + koot.calcNadi();

        response.setTotalScore(total);

        return response;
    }
}
