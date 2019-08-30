package Virgo;

import swisseph.*;

import java.lang.management.PlatformLoggingMXBean;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.CheckedOutputStream;

public class Horoscope {
    String Name,DOBD,DOBT,LAT,LON;
    int Year,Month,Day,Hours,Min,Sec;
    public int[] planets = { SweConst.SE_SUN,
            SweConst.SE_MOON,
            SweConst.SE_MARS,
            SweConst.SE_MERCURY,
            SweConst.SE_JUPITER,
            SweConst.SE_VENUS,
            SweConst.SE_SATURN,
            SweConst.SE_MEAN_NODE };	// Some systems prefer SE_MEAN_NODE
    //String plNams[] = {"Sun","Moon","Mars","Mercury","Jupiter","Venus","Saturn","","","","Rahu"};
    public static final String planetShortNames[] = {"SU", "MO", "ME", "VE", "MA", "JU", "SA", "UR", "NE", "PL", "RA", "KE"};
    /**
     *  Description of the Field
     */
    public static final String plNams[] = {"Sun", "Moon", "Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto", "Rahu", "Ketu"};

    public List<Planet> planetlist = new ArrayList<Planet>();
    int flags = SweConst.SEFLG_SWIEPH | SweConst.SEFLG_SPEED  | SweConst.SEFLG_SIDEREAL;
    //boolean retrograde = false;

    public Horoscope(String Name,String DOBD,String DOBT,String LAT,String LON)
    {
        this.Name = Name;
        this.DOBD = DOBD;
        this.DOBT = DOBT;
        this.LAT = LAT;
        this.LON = LON;
    }
    public void process(){
        Day = Integer.parseInt(DOBD.split("/")[0]);
        Month = Integer.parseInt(DOBD.split("/")[1]);
        Year = Integer.parseInt(DOBD.split("/")[2]);
        Hours = Integer.parseInt(DOBT.split(":")[0]);
        Min = Integer.parseInt(DOBT.split(":")[1]);
        Sec = Integer.parseInt(DOBT.split(":")[2]);
        String[] date = SRtime().split(" ")[0].split("-");
        String[] time = SRtime().split(" ")[1].split(":");
        double time2 = decimal(Integer.parseInt(time[0]),Integer.parseInt(time[1]),Integer.parseInt(time[2]));
        SweDate sd=new SweDate(Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0]),time2);
        Calculations c = new Calculations();
        for(int number:planets){
            //System.out.println(number);
            String PLDET = getPlanetPos(number,sd);
            String[] arr = PLDET.split(":");
            String raasi = c.RaasiFinder(Integer.parseInt(arr[1].trim()));
            Planet p = new Planet(plNams[number],arr[1]+":"+arr[2]+":"+arr[3],derive(Integer.parseInt(arr[1]))+":"+arr[2]+":"+arr[3],raasi,String.valueOf(c.calculateNakshatra(Double.parseDouble((arr[1])))));
            planetlist.add(p);
            //Planet e = new Planet();
        }
        for(Planet i:planetlist){
            System.out.println(i.Name);
            //System.out.println(i.ActualCoord);
            System.out.println(i.CalcCoord);
            //System.out.println(i.Nakshatra);
            System.out.println(i.Raasi);
        }
    }
    public int derive(int a){
        int b = 30;
        while (b <= a){
            a = a-b;
        }
        return a;
    }
    private String TZcalc(){
        return "IST";
        //Need to write
    }
    private static String yoga, tithi, karana;
    public String SRtime(){
        String input = Day+"-"+Month+"-"+Year+" "+ Hours +":"+Min+":"+Sec;//"31-12-1998 23:37:50";
        DateFormat dfNy = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ROOT);
        dfNy.setTimeZone(TimeZone.getTimeZone(TZcalc()));
        DateFormat dfUtc = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ROOT);
        dfUtc.setTimeZone(TimeZone.getTimeZone("UTC"));

        try {
            return dfUtc.format(dfNy.parse(input));
        } catch (Exception e) {

        }return "";
    }
    private String dms(double val){
        String res = new String();
        if (val < 0){
            val = Math.abs(val);
            res = res + "-";
        }
        int deg = (int)val;
        //System.out.print(deg+" : ");
        double mindob = (val-deg)* 60;
        int min = (int)(mindob);
        int sec = (int)((mindob - min)*60);
        //System.out.println(min+" : "+sec);
        res = res + deg+":"+min+":"+sec;
        return res;
    }
    public String getPlanetPos(int planet, SweDate sd){
        SwissEph sw = new SwissEph();
        int rc;
        sw.swe_set_sid_mode(1,0,0);
        double[] res=new double[6];
        StringBuffer sbErr=new StringBuffer();
        rc=sw.swe_calc_ut(sd.getJulDay() ,
                planet,
                flags,
                res,
                sbErr);
        System.out.println(plNams[planet]+" - " + dms(res[0]) );
        return plNams[planet]+":" + dms(res[0]);
    }
    public static double decimal( int deg, int min, int sec ) {

        double temp = ( ( ( deg * 60 ) + min ) * 60 ) + sec;
        double res = ( double ) ( temp / 3600 );

        //System.out.println("res " + res);
        return res;

    }

}
