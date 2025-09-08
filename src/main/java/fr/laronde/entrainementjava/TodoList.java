package fr.laronde.entrainementjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TodoList {

    private final List<Task> tasks = new ArrayList<>();
    private int id = 1;

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

    public boolean toggle(int id) {
        for (Task task : tasks) {
            if (id == task.getId()) {
                if (!task.isDone()) {
                    task.markDone();
                } else {
                    task.markUndone();
                }
                return true;
            }

        }
        return false;
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

public boolean removeTask(int id) {

    for (Task task : tasks) {
        if (task.getId() == id) {
            tasks.remove(task);
            return true;
        }


    }
    System.out.println("La tâche n'existe pas ");
    return false;
}


}
