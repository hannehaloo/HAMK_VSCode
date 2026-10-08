import java.util.Random;
import java.util.Scanner;

public class Lucky7_game {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        // Pelaajan rahat: 5€ alkuun, pelimaksu on 1€.
        // Jos pelaaja saa yhden seiskan, voittaa hän 3€, kahdesta 5€, kolmesta 7€.
        // Jos rahat loppuvat, peli loppuu.
        int pelaajanRahat = 5;
        int pelimaksu = 1;
        int voittoYksi7 = 3;
        int voittoKaksi7 = 5;
        int voittoKolme7 = 7;
        int seiskoja = 0;

        // Looppi kertoo voititko vai hävisitkö, jos yksi numeroistasi oli 7. Peli loppuu.
        while (true) {
            //System.out.println("Syötä rahamäärä jolla haluat pelata (min. 1€):");
            //pelaajanRahat = sc.nextInt();
            pelaajanRahat -= pelimaksu;
            System.out.println("Pelimaksu -1 euro käytetty, peli alkaa.");
            System.out.println("Arvotaan numerot:");

            // Arvotaan 3 numeroa ja tulostetaan ne.
            int arvottuNmr1 = r.nextInt(10)+1;
            int arvottuNmr2 = r.nextInt(10)+1;
            int arvottuNmr3 = r.nextInt(10)+1;
            System.out.println(arvottuNmr1);
            System.out.println(arvottuNmr2);
            System.out.println(arvottuNmr3);

            if (arvottuNmr1 == 7 && arvottuNmr2 == 7 && arvottuNmr3 == 7) {
                seiskoja += 3;
            } else if (arvottuNmr1 == 7 && arvottuNmr2 == 7) {
                seiskoja += 2;
            } else if (arvottuNmr2 == 7 && arvottuNmr3 == 7) {
                seiskoja += 2;
            } else if (arvottuNmr1 == 7 && arvottuNmr3 == 7) {
                seiskoja += 2;
            } else if (arvottuNmr1 == 7 || arvottuNmr2 == 7 || arvottuNmr3 == 7) {
                seiskoja += 1;
            }

            switch (seiskoja) {
                case 1:
                    pelaajanRahat += voittoYksi7;
                    System.out.println("Sait yhden numero seitsemän, voitit 3 euroa!");
                    System.out.println("Pelitilillesi on lisätty: " + voittoYksi7 + " euroa.");
                    System.out.println("Saldosi: " + pelaajanRahat + " euroa.");
                    break;
                case 2:
                    pelaajanRahat += voittoKaksi7;
                    System.out.println("Sait kaksi numero seitsemää, voitit 5 euroa!");
                    System.out.println("Pelitilillesi on lisätty: " + voittoKaksi7 + " euroa.");
                    System.out.println("Saldosi: " + pelaajanRahat + " euroa.");
                    break;
                case 3:
                    pelaajanRahat += voittoKolme7;
                    System.out.println("Sait kolme numero seitsemää, voitit 7 euroa!");
                    System.out.println("Pelitilillesi on lisätty: " + voittoKolme7 + " euroa.");
                    System.out.println("Saldosi: " + pelaajanRahat + " euroa.");
                    break;
                default:
                    System.out.println("Et saanut yhtään numero seitsemää, hävisit!");
                    System.out.println("Saldosi: " + pelaajanRahat + " euroa.");
                    break;
            }

            seiskoja = 0;
            
            if (pelaajanRahat <= 0) {
                System.out.println("Pelirahat ovat loppuneet.\nGame Over!");
                break;
            }
        }
    }
}
