package Oving5;

public class StudentHash {
    private String name;
    private StudentHash next;

    public StudentHash(String name) {
        this.name = name;
    }

    public void setNext(StudentHash next) {
        this.next = next;
    }

    public StudentHash getNext() {
        return next;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student " +
                "name: '" + name + '\'';
    }
}
