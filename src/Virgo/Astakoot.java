package Virgo;

public class Astakoot {
    int boyNak,girlNak,boyRaasi,girlRaasi;
    public String nakshatra[] = {"Ashwini", "Bharani", "Krittika", "Rohini", "Mrigshira", "Ardra", "Punarvasu", "Pushya", "Ashlesha", "Magha", "Purva Phalguni", "Uttara Phalguni", "Hasta", "Chitra", "Swati", "Vishakha", "Anuradha", "Jyestha", "Mula", "Purva Ashadha", "Uttara Ashadha", "Shravana", "Dhanishta", "Satabhisha", "Purva Bhadrapada", "Uttara Bhadrapada", "Revati", "Abhijit"};
    public int [] animalMappings = {0,1,2,3,3,4,5,2,5,6,6,7,8,9,8,9,11,10,4,11,12,11,13,0,13,7,1,12};
    Constants Arrays = new Constants();
    public Astakoot(int boyNak,int girlNak,int boyRaasi,int girlRaasi){
        this.boyNak = boyNak;
        this.girlNak = girlNak;
        this.boyRaasi = boyRaasi;
        this.girlRaasi = girlRaasi;
    }
    public int calcVarnaKoota(){
        int Bvkpoint = 3,Gvkpoint = 3;
        if (boyRaasi == 4 || boyRaasi == 8 || boyRaasi == 12){
            Bvkpoint = 0;
        }
        if (boyRaasi == 1 || boyRaasi == 5 || boyRaasi == 9){
            Bvkpoint = 1;
        }
        if (boyRaasi == 2 || boyRaasi == 6 || boyRaasi == 10){
            Bvkpoint = 2;
        }
        if (girlRaasi == 4 || girlRaasi == 8 || girlRaasi == 12){
            Gvkpoint = 0;
        }
        if (girlRaasi == 1 || girlRaasi == 5 || girlRaasi == 9){
            Gvkpoint = 1;
        }
        if (girlRaasi == 2 || girlRaasi == 6 || girlRaasi == 10){
            Gvkpoint = 2;
        }


        return Arrays.VarnaArray[Gvkpoint][Bvkpoint];
    }

    public Double calcVasyaKoota() {
        int Bvkpoint = 4, Gvkpoint = 4;
        if (boyRaasi == 3 || boyRaasi == 6 || boyRaasi == 7 || boyRaasi == 9 || boyRaasi == 11)    {
            Bvkpoint = 0;
        }
        if (girlRaasi == 3 ||girlRaasi == 6 ||girlRaasi == 7 ||girlRaasi == 9 || girlRaasi == 11)    {
            Gvkpoint = 0;
        }
        if (boyRaasi == 5){
            Bvkpoint = 1;
        }
        if (girlRaasi == 5){
            Gvkpoint = 1;
        }
        if (boyRaasi == 1 || boyRaasi == 2 || boyRaasi == 10)    {
            Bvkpoint = 2;
        }
        if (girlRaasi == 1 ||girlRaasi == 2 ||girlRaasi == 10)    {
            Gvkpoint = 2;
        }
        if (boyRaasi == 4 || boyRaasi == 10 || boyRaasi == 12)    {
            Bvkpoint = 3;
        }
        if (girlRaasi == 4 ||girlRaasi == 10 ||girlRaasi == 12)    {
            Gvkpoint = 3;
        }

        return Arrays.VasyaArray[Gvkpoint][Bvkpoint];
    }




    public int calcDinaKuta() {

        int count = (boyNak - girlNak + 1);

        if (count <= 0) {

            count = count + 27;

        }

        count = count % 9;

        // System.out.println(boyNak + " - " + girlNak + " Count : " + count);
        if ((count % 2) == 0) {

            return 3;

        } else {

            return 0;

        }

    }
    public int calcGanaKuta() {

        int boyGana = findGana(boyNak);
        int girlGana = findGana(girlNak);

        // System.out.println(" BG: " + boyGana + " GG: " + girlGana);
        int gana = 0;

        if ((boyGana == girlGana) || ((boyGana == 1) && (girlGana == 2))) {

            gana = 6;

        } else if (((boyGana == 2) && (girlGana == 1))) {

            gana = 4;

        } else if ((boyGana == 3) && ((girlGana == 1) || (girlGana == 2))) {

            gana = 3;

        } else if ((girlGana == 3) && ((boyGana == 1) || (boyGana == 2))) {

            int count = (girlNak - boyNak + 1);

            if (count <= 0) {

                count = count + 27;

            }

            if (count > 14) {

                gana = 3;

            } else {

                gana = 0;

            }

        }

        return gana;

    }

    private int findGana(int nak) {

        int gana = 0;

        switch (nak) {

            case 0:
            case 4:
            case 6:
            case 7:
            case 12:
            case 14:
            case 16:
            case 21:
            case 26:
                gana = 1;

                break;

            case 1:
            case 3:
            case 5:
            case 10:
            case 11:
            case 19:
            case 20:
            case 24:
            case 25:
                gana = 2;

                break;

            case 2:
            case 8:
            case 9:
            case 13:
            case 15:
            case 17:
            case 18:
            case 22:
            case 23:
                gana = 3;

                break;

        }

        return gana;

    }
    public String calcTara()
    {
        int bn = 0;
        int gn = 0;
        if (boyNak<10){
            bn = boyNak - 1;
        }
        else if(boyNak<=18){
            bn =Integer.parseInt(String.valueOf(boyNak).substring(1));
        }
        else{
            bn =Integer.parseInt(String.valueOf(boyNak).substring(1))+1;

        }
        if (girlNak<10){
            gn = girlNak - 1;
        }
        else if(girlNak<=18){
            //gn = girlNak - 10;
            gn =Integer.parseInt(String.valueOf(girlNak).substring(1));

        }
        else{
            gn =Integer.parseInt(String.valueOf(girlNak).substring(1))+1;
        }

        return String.valueOf(Arrays.TaraConst[bn][gn]);
    }
    public String calcYoni(){
        System.out.println(nakshatra[boyNak] + " " + nakshatra[girlNak]);
        System.out.println(boyNak + " " + girlNak);
        System.out.println(String.valueOf(Arrays.animalMappings[boyNak])+ " " +String.valueOf(Arrays.animalMappings[girlNak]));
        return String.valueOf(Arrays.YoniArray[Arrays.animalMappings[girlNak]][Arrays.animalMappings[boyNak]]);
    }

}
