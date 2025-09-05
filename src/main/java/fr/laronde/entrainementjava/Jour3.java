package fr.laronde.entrainementjava;

import java.util.Scanner;

public class Jour3 {

    public static void run() {
        Scanner sc = new Scanner(System.in);


        // 1️⃣ Stockage des tâches (tableau fixe pour l'instant)
        String[] tasks = new String[100];
        int size = 0;

        boolean quitter = false;

        // 2️⃣ Boucle du menu
        while (!quitter) {

            printMenu();

            int choix = sc.nextInt();
            sc.nextLine(); // consommer le \n restant

            switch (choix) {
                case 1:
                    //  Ajouter une tâche
                    System.out.print("Texte de la tâche : ");
                    String task = sc.nextLine().strip();
                    if (!task.isBlank()) {
                        size = addTask(tasks, size, task);
                    } else {
                        System.out.println("La tâche ne peut pas être vide !");
                    }
                    break;

                case 2:
                    //  Lister les tâches
                    if (size == 0) {
                        System.out.println("Aucune tâche.");
                    } else {
                       listTasks(tasks, size);

                    }
                    break;

                case 3:
                    //  Supprimer une tâche
                    if (size == 0) {
                        System.out.println("Aucune tâche à supprimer.");
                    } else {
                        for (int i = 0; i < size; i++) {
                            System.out.println((i+1) + ") " + tasks[i]);
                        }

                        System.out.println("Quelle tâche voulez-vous supprimer ?");
                        int indexTaskToRemove = sc.nextInt() -1;

                        if (indexTaskToRemove < 0 || indexTaskToRemove >= size) {
                            System.out.print("Index de tâche non valide");
                        } else {
                            size = removeTask(tasks, size, indexTaskToRemove);
                            System.out.println("Tâche supprimée !");

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
   private static void printMenu() {System.out.println("\n=== TodoList Menu ===");
               System.out.println("1. Ajouter une tâche");
               System.out.println("2. Lister les tâches");
               System.out.println("3. supprimer une tâche");
               System.out.println("0. Quitter");
               System.out.print("Ton choix ? ");}

    private static int addTask(String[] tasks, int size, String task){
                        tasks[size] = task;
                        size++;
                        System.out.println("Tâche ajoutée !");
                        return size;
    }
    private static void listTasks(String[] tasks, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println( (i+1) + "-> " + tasks[i]);
        }
    }
    private static int removeTask(String[] tasks, int size, int index) {
        for (int i = index; i < size - 1; i++) {
            tasks[i] = tasks[i + 1];
        }
        tasks[size - 1] = null;
        System.out.println("Tâche supprimée !");
        return size -1;
    }

}