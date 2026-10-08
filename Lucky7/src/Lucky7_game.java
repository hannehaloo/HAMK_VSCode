import java.util.Random;
import java.util.Scanner;

public class Lucky7_game {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int arvottuNmr1 = r.nextInt(10)+1;
        int arvottuNmr2 = r.nextInt(10)+1;
        int arvottuNmr3 = r.nextInt(10)+1;
        System.out.println(arvottuNmr1);
        System.out.println(arvottuNmr2);
        System.out.println(arvottuNmr3);

        while (true) {
            if (arvottuNmr1 == 7 || arvottuNmr2 == 7 || arvottuNmr3 == 7) {
                System.out.println("Sait numeron seitsemän, voitit pelin!");
            } else {
                System.out.println("Et saanut seitsemää, hävisit!");
            }
            break;
        }
    }
}
