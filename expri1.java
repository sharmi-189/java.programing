import java.util.Scanner;

public class ParkingSystem {

    static int totalSlots = 10;
    static String[] vehicleNumbers = new String[totalSlots];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== PARKING SYSTEM =====");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Display Parking Slots");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    parkVehicle(sc);
                    break;

                case 2:
                    removeVehicle(sc);
                    break;

                case 3:
                    displaySlots();
                    break;

                case 4:
                    System.out.println("Thank you for using Parking System!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }

    // Park a vehicle
    static void parkVehicle(Scanner sc) {

        System.out.print("Enter vehicle number: ");
        String vehicle = sc.nextLine();

        for (int i = 0; i < totalSlots; i++) {

            if (vehicleNumbers[i] == null) {
                vehicleNumbers[i] = vehicle;

                System.out.println("Vehicle parked successfully!");
                System.out.println("Parking Slot: " + (i + 1));
                return;
            }
        }

        System.out.println("Parking is full!");
    }

    // Remove a vehicle
    static void removeVehicle(Scanner sc) {

        System.out.print("Enter vehicle number to remove: ");
        String vehicle = sc.nextLine();

        for (int i = 0; i < totalSlots; i++) {

            if (vehicleNumbers[i] != null &&
                vehicleNumbers[i].equals(vehicle)) {

                vehicleNumbers[i] = null;

                System.out.println("Vehicle removed successfully!");
                System.out.println("Slot " + (i + 1) + " is now available.");
                return;
            }
        }

        System.out.println("Vehicle not found!");
    }

    // Display parking slots
    static void displaySlots() {

        System.out.println("\n===== PARKING SLOTS =====");

        for (int i = 0; i < totalSlots; i++) {

            if (vehicleNumbers[i] == null) {
                System.out.println("Slot " + (i + 1) + " : Empty");
            } else {
                System.out.println("Slot " + (i + 1) +
                                   " : " + vehicleNumbers[i]);
            }
        }
    }
}