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
                    System.out.println("2. Total pay for month by job Division.");

                    System.out.print("Enter you choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.print("Enter Date (e.g 2024-09): ");
                            String date = scanner.nextLine();
                            PayrollReport.totalPayByJobTitle(date);
                            break;
                        case 2:
                            System.out.print("Enter Date (e.g 2024-09): ");
                            date = scanner.nextLine();
                            PayrollReport.totalPayByDivision(date);
                        default:
                            break;
                    }

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

                    System.out.println("\nUpdate Salary by:");
                    System.out.println("1. SSN");
                    System.out.println("2. Employee ID");
                    System.out.println("3. Exit");

                    System.out.println("Enter your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.println("Enter SSN:");
                            String ssn = scanner.nextLine();

                            // Retrieve current salary by SSN
                            Double currentSalary = SalaryRetriever.bySSN(ssn);

                            if (currentSalary == null) {
                                System.out.println("No employee found with SSN: " + ssn);
                                break;
                            }

                            System.out.println("Current Salary: " + currentSalary);

                            // Check if the salary is within the range
                            if (currentSalary >= 58000 && currentSalary < 105000) {
                                System.out.println("Enter percentage increase (e.g., 3.2 for 3.2%):");
                                double percentageIncrease = scanner.nextDouble();

                                // Calculate the new salary
                                double newSalary = currentSalary * (1 + percentageIncrease / 100);
                                UpdateSalary.bySSN(newSalary, ssn);

                                System.out.println("Salary updated to: " + newSalary);
                            } else {
                                System.out.println("Salary is not within the specified range (58,000 - 105,000).");
                            }
                            break;

                        case 2:
                            System.out.println("Enter Employee ID:");
                            int empId = scanner.nextInt();

                            // Retrieve current salary by Employee ID
                            currentSalary = SalaryRetriever.byEmpId(empId);

                            if (currentSalary == null) {
                                System.out.println("No employee found with Employee ID: " + empId);
                                break;
                            }

                            System.out.println("Current Salary: " + currentSalary);

                            // Check if the salary is within the range
                            if (currentSalary >= 58000 && currentSalary < 105000) {
                                System.out.println("Enter percentage increase (e.g., 3.2 for 3.2%):");
                                double percentageIncrease = scanner.nextDouble();

                                // Calculate the new salary
                                double newSalary = currentSalary * (1 + percentageIncrease / 100);
                                UpdateSalary.byEmpId(newSalary, empId);

                                System.out.println("Salary updated to: " + newSalary);
                            } else {
                                System.out.println("Salary is not within the specified range (58,000 - 105,000).");
                            }
                            break;

                        case 3:
                        default:
                            System.out.println("Exiting salary update menu.");
                            break;
                    }
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
