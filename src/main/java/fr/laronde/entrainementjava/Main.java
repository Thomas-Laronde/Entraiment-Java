package fr.laronde.entrainementjava;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Lancer une étape spécifique
        System.out.print("Quel jour veux tu tester ? ");
        String nbJour = sc.nextLine().strip();

        switch (nbJour) {
            case "1" -> {
                System.out.println("Lancement Jour 1");
                Jour1.run();
            }
            case "2" -> {
                System.out.println("Lancement Jour 2");
                Jour2.run();
            }
            case "3" -> {
                System.out.println("Lancement Jour 3");
                Jour3.run();
            }
            /*case "4" -> {
                System.out.println("Lancement Jour 4");
                Jour4.run();
            }
            case "5" -> {
                System.out.println("Lancement Jour 5");
                Jour5.run();
            }
            case "6" -> {
                System.out.println("Lancement Jour 6");
                Jour6.run();
            }
            case "7" -> {
                System.out.println("Lancement Jour 7");
                Jour7.run();
            }
            case "8" -> {
                System.out.println("Lancement Jour 8");
                Jour8.run();
            }
            case "9" -> {
                System.out.println("Lancement Jour 9");
                Jour9.run();
            }
            case "10" -> {
                System.out.println("Lancement Jour 10");
                Jour10.run();
            }*/
            default -> System.out.println("Jour invalide !");
        }
    }
}
