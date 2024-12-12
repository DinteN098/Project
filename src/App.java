import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Generate Report");
            System.out.println("2. Add Employee");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee Data");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    Report.displayReport();
                    break;
                case 3:

                    System.out.println("\nSearch Employee by:");
                    System.out.println("1. First Name");
                    System.out.println("2. Last Name");
                    System.out.println("3. Employee Id");
                    System.out.println("4. SSN");
                    System.out.println("5. Exit");

                    System.out.print("Enter you choice: ");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (searchChoice) {
                        case 1:
                            System.out.print("Enter you First Name: ");
                            String fName = scanner.nextLine();
                            SearchEmployee.byFirstName(fName);
                            break;
                        case 2:
                            System.out.print("Enter you Last Name: ");
                            String lastName = scanner.nextLine();
                            SearchEmployee.byLastName(lastName);
                            break;
                        case 3:
                            System.out.print("Enter you Employee ID: ");
                            int empId = scanner.nextInt();
                            SearchEmployee.byEmpId(empId);
                            break;
                        case 4:
                            System.out.print("Enter you SSN: ");
                            String ssn = scanner.nextLine();
                            SearchEmployee.bySSN(ssn);
                            break;
                        case 5:
                            System.out.println("Exiting...");
                            scanner.close();
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
