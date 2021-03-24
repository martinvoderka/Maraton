package maraton;

import java.util.Scanner;

public class MaratonApp {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Zadej pocet bezcu: ");
        int n = sc.nextInt();
        int[][] bezci = new int[n][4];
        System.out.println("Zadej cislo bezce a jeho hodiny, minuty a vteriny");
        for (int i = 0; i < n; i++) 
        {
            bezci[i][0] = sc.nextInt();
            bezci[i][1] = sc.nextInt();
            bezci[i][2] = sc.nextInt();
            bezci[i][3] = sc.nextInt();
        }
        Bezci maraton = new Bezci(bezci);
        
        System.out.println(maraton.doCasu() + " bezci bezeli pod 2:07:00");
        System.out.println("Nejrychlejsi bezec ma cislo " + maraton.nejrychlejsiBezec());
        int ztrata = maraton.ztrata();
        System.out.format("Nejpomalejsi bezec ma na nejrychlejsiho ztratu %02d:%02d:%02d \n", ztrata/10000, (ztrata%10000)/100, ztrata%100);
        int naKilometr = maraton.naKilometr();
        System.out.format("Nejrychlejsi mel rychlost %02d:%02d na kilometr \n", naKilometr/100, naKilometr%100);
        System.out.format("Prumerna rychlost nejrychlejsiho bezce byla %.2f km/h \n",maraton.prumernaRychlost());
        
    }
    
}
