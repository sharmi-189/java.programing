import java.util.Scanner;

public class StudentManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static int[] rollNo = new int[100];
    static String[] name = new String[100];
    static int[] age = new int[100];
    static String[] department = new String[100];

    static int count = 0;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    // Add Student
    static void addStudent() {

        System.out.print("Enter Roll Number: ");
        rollNo[count] = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        name[count] = sc.nextLine();

        System.out.print("Enter Age: ");
        age[count] = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Department: ");
        department[count] = sc.nextLine();

        count++;

        System.out.println("Student added successfully!");
    }

    // Display Students
    static void displayStudents() {

        if (count == 0) {
            System.out.println("No students available!");
            return;
        }

        System.out.println("\n===== STUDENT DETAILS =====");

        for (int i = 0; i < count; i++) {

            System.out.println("Roll Number : " + rollNo[i]);
            System.out.println("Name        : " + name[i]);
            System.out.println("Age         : " + age[i]);
            System.out.println("Department  : " + department[i]);
            System.out.println("---------------------------");
        }
    }

    // Search Student
    static void searchStudent() {

        System.out.print("Enter Roll Number to search: ");
        int searchRoll = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (rollNo[i] == searchRoll) {

                System.out.println("\nStudent Found!");
                System.out.println("Roll Number : " + rollNo[i]);
                System.out.println("Name        : " + name[i]);
                System.out.println("Age         : " + age[i]);
                System.out.println("Department  : " + department[i]);

                return;
            }
        }

        System.out.println("Student not found!");
    }

    // Delete Student
    static void deleteStudent() {

        System.out.print("Enter Roll Number to delete: ");
        int deleteRoll = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (rollNo[i] == deleteRoll) {

                for (int j = i; j < count - 1; j++) {

                    rollNo[j] = rollNo[j + 1];
                    name[j] = name[j + 1];
                    age[j] = age[j + 1];
                    department[j] = department[j + 1];
                }

                count--;

                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }
}