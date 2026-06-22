import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Pretty table printing
    public static void printTable(ArrayList<Student> list) {
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-20s %-20s %-20s%n", "Roll #", "Name", "Address");
        System.out.println("------------------------------------------------------------------------");

        for (Student s : list) {
            System.out.printf("%-20d %-20s %-20s%n", s.rollno, s.name, s.address);
        }

        System.out.println("------------------------------------------------------------------------");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("Please enter the information for the 10 students:");

        for (int i = 0; i < 10; i++) {
            System.out.println("\nStudent #" + (i + 1));

            // Name
            System.out.print("Please enter Student name: ");
            String name = sc.nextLine();

            // Roll number with validation
            int roll = 0;
            boolean validRoll = false;

            while (!validRoll) {
                System.out.print("Please enter student roll number: ");

                if (sc.hasNextInt()) {
                    roll = sc.nextInt();
                    sc.nextLine();

                    boolean exists = false;

                    // check for duplicates
                    for (Student s : students) {
                        if (s.rollno == roll) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("That roll number is already taken. Please try another.");
                    } else {
                        validRoll = true;
                    }

                } else {
                    System.out.println("Error. Please enter a whole number.");
                    sc.nextLine();
                }
            }

            // Address
            System.out.print("Please enter the address: ");
            String address = sc.nextLine();

            students.add(new Student(roll, name, address));
        }

        System.out.println("\nOriginal format:");
        printTable(students);

        SelectionSort.selectionSort(students, new NameComparator());
        System.out.println("\nSorted by Name:");
        printTable(students);

        SelectionSort.selectionSort(students, new RollnoComparator());
        System.out.println("\nSorted by roll Number:");
        printTable(students);

        sc.close();
    }
}
