package phonebook;

import java.util.Objects;

public class Note {

    private String name;
    private String phone;

    private Note(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public static Note create(String name, String phone) {
        return new Note(name, phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(name, note.name) && Objects.equals(phone, note.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone);
    }

    @Override
    public String toString() {
        return "Note{" +
                "name: " + name +
                ", phone: " + phone +
                '}';
    }
}
