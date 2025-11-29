package Virgo.api;

public class CompatibilityResponse {
    private PersonResult boy;
    private PersonResult girl;
    private KootaScore varna;
    private KootaScore vaisya;
    private KootaScore tara;
    private KootaScore yoni;
    private KootaScore maitri;
    private KootaScore gana;
    private KootaScore bahkut;
    private KootaScore nadi;
    private double totalScore;

    public PersonResult getBoy() {
        return boy;
    }

    public void setBoy(PersonResult boy) {
        this.boy = boy;
    }

    public PersonResult getGirl() {
        return girl;
    }

    public void setGirl(PersonResult girl) {
        this.girl = girl;
    }

    public KootaScore getVarna() {
        return varna;
    }

    public void setVarna(KootaScore varna) {
        this.varna = varna;
    }

    public KootaScore getVaisya() {
        return vaisya;
    }

    public void setVaisya(KootaScore vaisya) {
        this.vaisya = vaisya;
    }

    public KootaScore getTara() {
        return tara;
    }

    public void setTara(KootaScore tara) {
        this.tara = tara;
    }

    public KootaScore getYoni() {
        return yoni;
    }

    public void setYoni(KootaScore yoni) {
        this.yoni = yoni;
    }

    public KootaScore getMaitri() {
        return maitri;
    }

    public void setMaitri(KootaScore maitri) {
        this.maitri = maitri;
    }

    public KootaScore getGana() {
        return gana;
    }

    public void setGana(KootaScore gana) {
        this.gana = gana;
    }

    public KootaScore getBahkut() {
        return bahkut;
    }

    public void setBahkut(KootaScore bahkut) {
        this.bahkut = bahkut;
    }

    public KootaScore getNadi() {
        return nadi;
    }

    public void setNadi(KootaScore nadi) {
        this.nadi = nadi;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public static class PersonResult {
        private String name;
        private String nakshatra;
        private String raasi;

        public PersonResult(String name, String nakshatra, String raasi) {
            this.name = name;
            this.nakshatra = nakshatra;
            this.raasi = raasi;
        }

        public String getName() {
            return name;
        }

        public String getNakshatra() {
            return nakshatra;
        }

        public String getRaasi() {
            return raasi;
        }
    }

    public static class KootaScore {
        private double max;
        private double obtained;

        public KootaScore(double max, double obtained) {
            this.max = max;
            this.obtained = obtained;
        }

        public double getMax() {
            return max;
        }

        public double getObtained() {
            return obtained;
        }
    }
}
