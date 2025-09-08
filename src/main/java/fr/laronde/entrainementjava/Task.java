package fr.laronde.entrainementjava;

public class Task {
    private final int id;        // identifiant interne
    private String title;        // ex: "Acheter du lait"
    private boolean done;        // statut

    public Task(int id, String title) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("title");
        this.id = id;
        this.title = title.strip();
        this.done = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isDone() { return done; }

    public void rename(String newTitle) {
        if (newTitle == null || newTitle.isBlank()) throw new IllegalArgumentException("newTitle");
        this.title = newTitle.strip();
    }

    public void markDone() {
        this.done = true;
    }

    public void markUndone() {
        this.done = false; }

    @Override public String toString() {
        return (done ? "[x] " : "[ ] ") + "#" + id + " " + title;
    }
}
