package fr.laronde.entrainementjava;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenue dans TodoList !");

        // Scanner pour lire les entrées utilisateur
        try (Scanner sc = new Scanner(System.in)) {

            // 1️⃣ Demander le prénom
            System.out.print("Ton prénom ? ");
            String prenom = sc.nextLine();

            if (prenom.isBlank()) {
                System.out.println("Prénom vide !");
            } else {
                System.out.println("Bonjour " + prenom + " !");
            }

            // 2️⃣ Variables pour calculs
            int entier = 0; // <-- à remplir
            System.out.print("Ton premier nombre ? ");
            int a = sc.nextInt();

            System.out.print("Ton deuxieme nombre ? ");
            int b = sc.nextInt();

            sc.nextLine();  // pour enlever le retour à la ligne


            // 3️⃣ Calculs à faire
            int somme = a + b;        // <-- à calculer

            int difference = a - b;   // <-- à calculer

            int produit = a * b;      // <-- à calculer

            double division = (double) a / b;  // <-- à calculer

            // 4️⃣ Affichage conditionnel
            boolean afficherDetails = false;
            String reponse;

            do {
                System.out.print("Veux-tu voir le résultat ? (oui/non) : ");
                reponse = sc.nextLine().strip().toLowerCase();

                if (!reponse.equals("oui") && !reponse.equals("non")) {
                    System.out.println("Veuillez saisir 'oui' ou 'non' !");
                }
            } while (!reponse.equals("oui") && !reponse.equals("non"));

            if (reponse.equals("oui")) {
                afficherDetails = true;
            } else {
                System.out.println("D'accord");
            }
            if (afficherDetails) {
                System.out.println("La somme de ces deux nombres est : " + somme + "!");
                System.out.println("La différence de ces deux nombres est : " + difference + "!");
                System.out.println("Le produit de ces deux nombres est : " + produit + "!");
                System.out.println("La division décimale de ces deux nombres est : " + division + "!");
                // <-- afficher les résultats ici
            }

            // 5️⃣ Bonus : demander deux nombres à l'utilisateur et refaire les calculs
            // <-- à compléter

        }
    }
}
