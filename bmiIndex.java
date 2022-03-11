package feladat;

import java.util.Scanner;

public class bmiIndex {

    static int weight = beker("Testtömeg (kg) [40; 150]", 40, 150);
    static int height = beker("Testmagasság (cm) [100; 200]", 100, 200);
    static double bmi = bmi();

    private static void kiiras(String szoveg) {
        System.out.println(szoveg);
    }

    public static void main(String[] args) {
        kiiras("BMI index:");
        szamitas();
    }

    private static double bmi() {
        return weight / Math.pow(height / 100.0, 2);
    }

    private static int beker(String beSzoveg, int also, int felso) {
        System.out.print(beSzoveg);

        Scanner sc = new Scanner(System.in);
        int ertek = -1;
        boolean jo = false;
        while (!jo) {
            ertek = sc.nextInt();
            jo = ertek >= also && ertek <= felso;
            if (!jo) {
                System.out.println("Hibás érték! Kérem adja meg újra!");
                System.out.println(beSzoveg);
            }
        }
        return ertek;
    }

    private static void szamitas() {
        String kiadat = "kórosan sovány";
        if (bmi > 20 && bmi < 25) {
            kiadat = "normál testsúly";
        } else if (bmi > 25 && bmi < 30) {
            kiadat = "túlsúlyos";
        } else if (bmi > 30 && bmi < 35) {
            kiadat = "elhízott";
        } else if (bmi > 35) {
            kiadat = "károsan elhízott";
        }
        System.out.printf("Ön %d cm magas és %d kg tömegű, "
                + "így az ön BMI indexe %.2f. %s\n ", height, weight, bmi, kiadat);

    }
}
