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
            System.out.println("5. Update Employee Salary");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.println("\nReport by:");
                    System.out.println("1. Total pay for month by job title.");
                    System.out.println("2. Total pay for month by job division.");

                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.print("Enter Date (e.g., 2024-09): ");
                            String date = scanner.nextLine();
                            PayrollReport.totalPayByJobTitle(date);
                            break;
                        case 2:
                            System.out.print("Enter Date (e.g., 2024-09): ");
                            date = scanner.nextLine();
                            PayrollReport.totalPayByDivision(date);
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    searchEmployee(scanner);
                    break;
                case 4:
                    EmployeeUpdate.updateEmployee();
                    break;
                case 5:
                    updateEmployeeSalary(scanner);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to add an employee
    private static void addEmployee() {
        Employee newEmployee = InsertEmployee.getEmployeeFromInput();
        if (newEmployee != null) {
            InsertEmployee.addEmployeeToDatabase(newEmployee);
        } else {
            System.out.println("Error: Unable to add employee. Please try again.");
        }
    }

    // Method to search for an employee
    private static void searchEmployee(Scanner scanner) {
        System.out.println("\nSearch Employee by:");
        System.out.println("1. First Name");
        System.out.println("2. Last Name");
        System.out.println("3. Employee ID");
        System.out.println("4. SSN");
        System.out.println("5. Exit");

        System.out.print("Enter your choice: ");
        int searchChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        Employee foundEmployee = null;
        switch (searchChoice) {
            case 1:
                System.out.print("Enter First Name: ");
                String firstName = scanner.nextLine();
                foundEmployee = SearchEmployee.byFirstName(firstName);
                break;
            case 2:
                System.out.print("Enter Last Name: ");
                String lastName = scanner.nextLine();
                foundEmployee = SearchEmployee.byLastName(lastName);
                break;
            case 3:
                System.out.print("Enter Employee ID: ");
                int empId = scanner.nextInt();
                foundEmployee = SearchEmployee.byEmpId(empId);
                break;
            case 4:
                System.out.print("Enter SSN: ");
                String ssn = scanner.nextLine();
                foundEmployee = SearchEmployee.bySSN(ssn);
                break;
            case 5:
                System.out.println("Exiting search menu.");
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                return;
        }

        if (foundEmployee != null) {
            System.out.println("Employee Found: " + foundEmployee);
        } else {
            System.out.println("No employee found with the provided details.");
        }
    }

    // Method to update employee salary
    private static void updateEmployeeSalary(Scanner scanner) {
        System.out.println("\nUpdate Salary by:");
        System.out.println("1. SSN");
        System.out.println("2. Employee ID");
        System.out.println("3. Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter SSN: ");
                String ssn = scanner.nextLine();
                updateSalaryByIdentifier(ssn, true);
                break;
            case 2:
                System.out.print("Enter Employee ID: ");
                int empId = scanner.nextInt();
                updateSalaryByIdentifier(empId, false);
                break;
            case 3:
                System.out.println("Exiting salary update menu.");
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void updateSalaryByIdentifier(Object identifier, boolean isSSN) {
        Double currentSalary;
        if (isSSN) {
            currentSalary = SalaryRetriever.bySSN((String) identifier);
        } else {
            currentSalary = SalaryRetriever.byEmpId((int) identifier);
        }

        if (currentSalary == null) {
            System.out.println("No employee found with the provided identifier.");
            return;
        }

        System.out.println("Current Salary: " + currentSalary);
        if (currentSalary >= 58000 && currentSalary < 105000) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter percentage increase (e.g., 3.2 for 3.2%): ");
            double percentageIncrease = scanner.nextDouble();

            double newSalary = currentSalary * (1 + percentageIncrease / 100);

            if (isSSN) {
                UpdateSalary.bySSN(newSalary, (String) identifier);
            } else {
                UpdateSalary.byEmpId(newSalary, (int) identifier);
            }

            System.out.println("Salary updated to: " + newSalary);
        } else {
            System.out.println("Salary is not within the specified range (58,000 - 105,000).");
        }
    }
}
