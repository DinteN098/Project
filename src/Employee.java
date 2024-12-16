
public class Employee {
    private final int empId; // `empId` is immutable
    private String fname;
    private String lname;
    private String email;
    private String hireDate;
    private double salary;
    private String ssn;

    // Constructor without empId (for new employees)
    public Employee(String fname, String lname, String email, String hireDate, double salary, String ssn) {
        this.empId = 0; // Default value (set after insertion into DB)
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.hireDate = hireDate;
        this.salary = salary;
        this.ssn = ssn;
    }

    // Constructor for existing employees (e.g., fetched from DB)
    public Employee(int empId, String fname, String lname, String email, String hireDate, double salary, String ssn) {
        this.empId = empId;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.hireDate = hireDate;
        this.salary = salary;
        this.ssn = ssn;
    }

    // Getter for empId (no setter to keep it immutable)
    public int getEmpId() {
        return empId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", salary=" + salary +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
