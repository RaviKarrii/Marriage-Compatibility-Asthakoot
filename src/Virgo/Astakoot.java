package Virgo;

public class Astakoot {
    int boyNak,girlNak;
    public Astakoot(int boyNak,int girlNak){
        this.boyNak = boyNak;
        this.girlNak = girlNak;
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
}
