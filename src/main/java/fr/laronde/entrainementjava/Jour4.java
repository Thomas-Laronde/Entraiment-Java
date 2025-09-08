package fr.laronde.entrainementjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jour4 {

    public static void run() {
        Scanner sc = new Scanner(System.in);

        // 1️⃣ Stockage des tâches (ArrayList)
        List<String> tasks = new ArrayList<>(); // Créer une List plutôt qu'un tableau

        boolean quitter = false;

        // 2️⃣ Boucle du menu
        while (!quitter) {

            printMenu();

            int choix = sc.nextInt();
            sc.nextLine(); // consommer le \n

            switch (choix) {
                case 1:
                    // Ajouter une tâche
                    System.out.print("Texte de la tâche : ");
                    String task = sc.nextLine().strip();
                    if (!task.isBlank()) {
                        tasks.add(task);         // AJouter grâce à la méthode .add()
                        System.out.println("Tâche ajoutée !");
                    } else {
                        System.out.println("La tâche ne peut pas être vide !");
                    }
                    break;

                case 2:
                    // Lister les tâches
                    if (tasks.isEmpty()) { // Savoir si la List est vide .isEmpty()
                        System.out.println("Aucune tâche.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) { // .size() pour avoir la longueur de la List
                            System.out.println((i + 1) + " -> " + tasks.get(i)); // Récupérer grâce à la méthode .get()
                        }
                    }
                    break;

                case 3:
                    // Supprimer une tâche
                    if (tasks.isEmpty()) {
                        System.out.println("Aucune tâche à supprimer.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ") " + tasks.get(i));
                        }

                        System.out.println("Quelle tâche voulez-vous supprimer ?");
                        int indexTaskToRemove = sc.nextInt() - 1;

                        if (indexTaskToRemove < 0 || indexTaskToRemove >= tasks.size()) {
                            System.out.println("Index de tâche non valide !");
                        } else {
                            tasks.remove(indexTaskToRemove); // Supprimer grâce à la méthode .remove()                            System.out.println("Tâche supprimée !");
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

    private static void printMenu() {
        System.out.println("\n=== TodoList Menu ===");
        System.out.println("1. Ajouter une tâche");
        System.out.println("2. Lister les tâches");
        System.out.println("3. Supprimer une tâche");
        System.out.println("0. Quitter");
        System.out.print("Ton choix ? ");
    }
}