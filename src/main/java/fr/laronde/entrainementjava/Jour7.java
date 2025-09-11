package fr.laronde.entrainementjava;

import java.util.Scanner;

public class Jour7 {
    public class Input {
        public static int readInt(Scanner sc, String prompt) {
            System.out.print(prompt);
            while (!sc.hasNextInt()) {
                System.out.println("Veuillez entrer un entier.");
                sc.next(); // on jette l’entrée invalide
                System.out.print(prompt);
            }
            return sc.nextInt();
        }
    }

}
