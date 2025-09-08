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

        assertFalse(task.isDone());
        assertFalse(todoList.toggle(50));
        assertTrue(todoList.toggle(task.getId()));
       assertTrue(task.isDone());
    }

    @Test
    void testRemove() {
        TodoList todoList = new TodoList();

        Task tache = todoList.addTask("Tâche qui va partir");

        assertTrue(todoList.removeTask(tache.getId()));
        assertFalse(todoList.removeTask(tache.getId()));
    }
}
