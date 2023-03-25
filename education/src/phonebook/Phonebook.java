package phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Phonebook {

    private List<Note> notes;

    public Phonebook(List<Note> notes) {
        this.notes = notes;
    }


    public Phonebook() {
        this.notes = null;
    }

    public void addNewNote(String name, String phone) {
        notes.add(Note.create(name, phone));
    }

    public Note find(String name) {
        for (Note contact : notes) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public List<Note> findAll(String name) {
        ArrayList<Note> foundContacts = new ArrayList<>();
        for (Note contact : notes) {
            if (contact.getName().equals(name)) {
                foundContacts.add(contact);
            }
        }
        return !foundContacts.isEmpty() ? foundContacts : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phonebook phonebook = (Phonebook) o;
        return Objects.equals(notes, phonebook.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notes);
    }

    @Override
    public String toString() {
        return "Phonebook{" +
                "notes=" + notes +
                '}';
    }
}
