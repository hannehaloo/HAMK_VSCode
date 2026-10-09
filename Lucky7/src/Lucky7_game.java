import java.util.Random;
import java.util.Scanner;

// Lucky7 -variaatiopeli, jossa heitetään noppaa 3 kertaa,
// yrittäen saada 7-numeroita. Jokaisesta seiskasta voittaa.
public class Lucky7_game {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        // Pelimaksu on 1€. Pelaaja syöttää pelirahansa määrän.
        // Jos pelaaja saa yhden seiskan, voittaa hän 3€, kahdesta 5€, kolmesta 7€.
        // Jos rahat loppuvat, peli loppuu. Jos pelaaja kirjoittaa "e" kysyttäessä, peli loppuu.
        int pelaajanRahat = 0;
        int pelimaksu = 1;
        int voittoYksi7 = 3;
        int voittoKaksi7 = 5;
        int voittoKolme7 = 7;
        
        System.out.println("Syötä rahamäärä jolla haluat pelata (min. 1 euro):");
        pelaajanRahat = Integer.parseInt(sc.nextLine());
        System.out.println("Saldosi: " + pelaajanRahat + " euroa.");

        // Rahat on syötetty, peli voi alkaa.
        while (true) {
            // Vähennetään pelimaksu.
            int seiskoja = 0;
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

            // Lasketaan kuinka monta 7-numeroa pelaaja sai.
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

            // Peli ilmoittaa pelaajalle voitonmaksun/häviön ja saldon.
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

            // Mikäli pelirahat ovat loppuneet, peli loppuu.
            // Muutoin peli kysyy haluatko jatkaa pelaamista vai sulkea pelin.
            if (pelaajanRahat <= 0) {
                System.out.println("Pelirahat ovat loppuneet.\nGame Over!");
                break;
            } else {
                System.out.println("Haluatko pelata uudestaan? Jos haluat pelata, paina Enter.\nJos et halua pelata, kirjoita 'e' ja paina Enter.");
                String uusiPeli = sc.nextLine();
                if (uusiPeli.equalsIgnoreCase("e")) {
                    System.out.println("Game over!");
                    break;
                }
            }
        }
    }
}
