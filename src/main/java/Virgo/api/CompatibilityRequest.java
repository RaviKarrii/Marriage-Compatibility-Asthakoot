package Virgo.api;

public class CompatibilityRequest {
    private PersonDetails boy;
    private PersonDetails girl;

    public PersonDetails getBoy() {
        return boy;
    }

    public void setBoy(PersonDetails boy) {
        this.boy = boy;
    }

    public PersonDetails getGirl() {
        return girl;
    }

    public void setGirl(PersonDetails girl) {
        this.girl = girl;
    }

    public static class PersonDetails {
        private String name;
        private String birthDate;
        private String birthTime;
        private String latitude;
        private String longitude;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

        public String getBirthTime() {
            return birthTime;
        }

        public void setBirthTime(String birthTime) {
            this.birthTime = birthTime;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }
    }
}
