package fr.laronde.entrainementjava;

import java.util.Scanner;

public class Jour2 {

    public static void run() {
        Scanner sc = new Scanner(System.in);


        // 1️⃣ Stockage des tâches (tableau fixe pour l'instant)
        String[] tasks = new String[100];
        int size = 0;

        boolean quitter = false;

        // 2️⃣ Boucle du menu
        while (!quitter) {
            System.out.println("\n=== TodoList Menu ===");
            System.out.println("1. Ajouter une tâche");
            System.out.println("2. Lister les tâches");
            System.out.println("0. Quitter");
            System.out.print("Ton choix ? ");

            int choix = sc.nextInt();
            sc.nextLine(); // consommer le \n restant

            switch (choix) {
                case 1:
                    //  Ajouter une tâche
                    System.out.print("Texte de la tâche : ");
                    String task = sc.nextLine().strip();
                    if (!task.isBlank()) {
                        tasks[size] = task;
                        size++;
                        System.out.println("Tâche ajoutée !");
                    } else {
                        System.out.println("La tâche ne peut pas être vide !");
                    }
                    break;

                case 2:
                    //  Lister les tâches
                    if (size == 0) {
                        System.out.println("Aucune tâche.");
                    } else {
                        for (int i = 0; i < size; i++) {
                            System.out.println(i + "-> " + tasks[i]);
                        }
                    }
                    break;


                case 0:
                    quitter = true;
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide, veuillez recommencer !");
            }
        }

        // sc.close();
    }

}