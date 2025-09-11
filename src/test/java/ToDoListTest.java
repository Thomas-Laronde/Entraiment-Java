import fr.laronde.entrainementjava.Task;
import fr.laronde.entrainementjava.TodoList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {

    @Test
    void createAndToggle() {
        var t = new Task(1, "Acheter du lait");
        assertFalse(t.isDone());
        t.markDone();
        assertTrue(t.isDone());
    }

    @Test
    void invalidTitleThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Task(1, " "));
    }

    @Test
    void testAddTask() {
        TodoList todoList = new TodoList();

        Task task = todoList.addTask("Acheter du pain");
        Task task2 = todoList.addTask("Acheter du jambon");
        assertAll(
                "TodoList",
                () -> assertEquals("Acheter du pain", task.getTitle()),
                () -> assertEquals("Acheter du jambon", task2.getTitle()),
                () -> assertEquals(2,todoList.listAll().size()),
                () -> assertEquals(1, task.getId()),
                () -> assertEquals(2, task2.getId())
        );
    }

    @Test
    void testToggle() {
        TodoList todoList = new TodoList();

        Task task = todoList.addTask("Acheter du fromage");

        // La tâche existe
        TodoList.OperationResult resultExist = todoList.toggle(task.getId());
        assertTrue(resultExist.success());
        assertEquals("Tâche marquée comme faite !",resultExist.message() );

        // La tâche n'existe pas
        TodoList.OperationResult resultNotExist = todoList.toggle(50);
        assertFalse(resultNotExist.success());
        assertEquals("Tâche non trouvée",resultNotExist.message());

        // La tâche à été cochée
        TodoList.OperationResult resulToggled = todoList.toggle(task.getId());
        assertTrue(resulToggled.success());
       assertEquals("Tâche marquée comme non faite !", resulToggled.message());
    }

    @Test
    void testRemove() {
        TodoList todoList = new TodoList();

        Task tache = todoList.addTask("Tâche qui va partir");

        TodoList.OperationResult result = todoList.removeTask(tache.getId());

        assertTrue(result.success());
        assertEquals("Tâche supprimée !", result.message());
    }

    @Test
    void testListDoneAndUndone() {
        // Je recré une Todolist de class TodoList
        TodoList testTodolist = new TodoList();

        // J'ajoute mes tâches pour ensuite pour manipuler mon resulter et vérifier si ma méthode fonctionne
        Task t1 = testTodolist.addTask("Acheter du pain");
        Task t2 = testTodolist.addTask("Faire du sport");
        Task t3 = testTodolist.addTask("Lire un livre");

        // J'execute le code testé
        testTodolist.toggle(t1.getId());
        List<Task> done = testTodolist.listDone();
        List<Task> undone = testTodolist.listUndone();

        // Je vérifie les resultats
        assertEquals(1, done.size());
        assertTrue(done.contains(t1));

        assertEquals(2, undone.size());
        assertTrue(undone.contains(t2));
        assertTrue(undone.contains(t3));
    }
}
