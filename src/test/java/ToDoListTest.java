import fr.laronde.entrainementjava.Task;
import fr.laronde.entrainementjava.TodoList;
import org.junit.jupiter.api.Test;
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
}
