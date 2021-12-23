package Oving5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HashTable {
    private StudentHash[] table;
    private int collition;

    public HashTable(int tableLength) {
        table = new StudentHash[tableLength];
        collition = 0;
    }

    public int getCollition() {
        return collition;
    }

    public int tableLength(){
        return table.length;
    }

    public int makeHashKey(String name){
        int prime = 57;
        int count = 1;
        int hashVal = 0;
        for (int i = 0; i < name.length(); i++) {
            hashVal = (hashVal + (name.charAt(i)) - 'a' + 1)*count % table.length;
            count = (count*prime)%table.length;
        }
        if (hashVal < 0){
            hashVal *= -1;
        }
        return hashVal;
    }

    public void putInTable(StudentHash student){
        int index = makeHashKey(student.getName());
        if (table[index] == null){
            table[index] = student;
        } else if (table[index] != null){
            StudentHash collitionHash = table[index];
            collition++;
            System.out.println("Collision at index: " + index + " Student: "  + collitionHash.getName()
                    + " already at this index");
            while (collitionHash.getNext() != null){
                collition++;
                System.out.println("Collision at index: " + index + " Student: "  + collitionHash.getName()
                        + " already at this index");
                collitionHash = collitionHash.getNext();
            }
            collitionHash.setNext(student);
        }
    }

    public StudentHash findStudent(String studentName){
        try {
            int index = makeHashKey(studentName);
            StudentHash temp = table[index];
            if (temp.getName().trim().equalsIgnoreCase(studentName)) {
                return temp;
            } else {
                while (!temp.getName().trim().equalsIgnoreCase(studentName)) {
                temp = temp.getNext();
                }
            }
            return temp;
        }catch (NullPointerException n){
            return null;
        }
    }

    public int nrOfIndexesUsed() {
        int count = 0;
        for (StudentHash studentHash : table) {
            if (studentHash != null) {
                count++;
            }
        }
        return count;
    }

    public int nrOfStudents(){
        int total = 0;
        StudentHash temp;
        for (int i = 0; i < table.length; i++) {
            temp = table[i];
            if (temp != null) {
                total++;
                while (temp.getNext() != null) {
                    total++;
                    temp = temp.getNext();
                }
            }
        }
        return total;
    }


    public static void main(String[] args) {
        HashTable table = new HashTable(149);
        try {
            FileReader reader = new FileReader("C:\\Users\\hassa\\NTNU.Data\\2år\\1.sem\\AlgDat\\AlgDat_IDATT2101\\src\\main\\java\\Oving5\\navn.txt");
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null){
                StudentHash newStudent = new StudentHash(line);
                table.putInTable(newStudent);
            }
            System.out.println(table.findStudent("Hasan Rehman Omarzae").toString());
            System.out.println("Nr of students: " + table.nrOfStudents() + "\n" + "collisions: " +
                    table.getCollition());
            System.out.println("The load factor is: " + (double)table.nrOfIndexesUsed()/table.tableLength());
            System.out.println("Average: " + (double)table.getCollition()/table.nrOfStudents());

            br.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
