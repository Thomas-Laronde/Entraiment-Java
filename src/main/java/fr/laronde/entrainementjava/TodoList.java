package fr.laronde.entrainementjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TodoList {

    private final List<Task> tasks = new ArrayList<>();
    private int id = 1;
    public record OperationResult(boolean success, String message) { }


    public Task addTask(String title) {

        if (title == null || title.isBlank()) {
            System.out.println("veuillez renseigner une tâche");
            return null;
        }
        Task nouvelleTache = new Task(id, title);
        tasks.add(nouvelleTache);
        id++;
        return nouvelleTache;
    }

    public OperationResult toggle(int id) {
        for (Task task : tasks) {
            if (id == task.getId()) {
                if (!task.isDone()) {
                    task.markDone();
                    return new OperationResult(true, "Tâche marquée comme faite !");
                } else {
                    task.markUndone();
                    return new OperationResult(true, "Tâche marquée comme non faite !");
                }
            }
        }
        return new OperationResult(false,"Tâche non trouvée" );
    }


    public Optional<Task> findById(int id) {
        for (Task task : tasks) {
            if (id == task.getId()) {
                return Optional.of(task);
            }
        }
        return Optional.empty();
    }

    public List<Task> listAll() {
         return tasks;
    }


public OperationResult removeTask(int id) {

    for (Task task : tasks) {
        if (task.getId() == id) {
            tasks.remove(task);
            return new OperationResult(true, "Tâche supprimée !");
        }
    }
    return new OperationResult(false, " la tâche n'existe pas ");
}




}
