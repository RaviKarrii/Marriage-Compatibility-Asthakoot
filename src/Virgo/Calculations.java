package Virgo;

public class Calculations {
    public String nakshatra[] = {"Ashwini", "Bharani", "Krittika", "Rohini", "Mrigshira", "Ardra", "Punarvasu", "Pushya", "Ashlesha", "Magha", "Purva Phalguni", "Uttara Phalguni", "Hasta", "Chitra", "Swati", "Vishakha", "Anuradha", "Jyestha", "Mula", "Purva Ashadha", "Uttara Ashadha", "Shravana", "Dhanishta", "Satabhisha", "Purva Bhadrapada", "Uttara Bhadrapada", "Revati", "Ashwini"};

    public String RaasiFinder(int angle)
    {
        if (angle >= 0 && angle < 30){
            return "Aries";
        }
        else if (angle >= 30 && angle < 60){
            return "Taurus";
        }
        else if (angle >= 60 && angle < 90){
            return "Gemini";
        }
        else if (angle >= 90 && angle < 120){
            return "Cancer";
        }
        else if (angle >= 120 && angle < 150){
            return "Leo";
        }
        else if (angle >= 150 && angle < 180){
            return "Virgo";
        }
        else if (angle >= 180 && angle < 210){
            return "Libra";
        }
        else if (angle >= 210 && angle < 240){
            return "Scorpio";
        }
        else if (angle >= 240 && angle < 270){
            return "Saggittarius";
        }
        else if (angle >= 270 && angle < 300){
            return "Capricorn";
        }
        else if (angle >= 300 && angle < 330){
            return "Aquarius";
        }
        else if (angle >= 330 && angle < 360){
            return "Pisces";
        }
        return "";
    }
    public static int calculateNakshatra(double moonlog)
    {

        int i = (int) (moonlog / (13.333333));
        if(i<0){
            i=0;
        }
        return i;
    }
}
