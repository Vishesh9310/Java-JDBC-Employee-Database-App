import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/employeedb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Optum@12";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        Main mainApp = new Main();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if (conn.isClosed()) {
                System.out.println("Connection is closed");
            } else {
                System.out.println("Connection established");
            }

            do {
                System.out.println("\nEmployee Database Menu");
                System.out.println("1. Add Employee");
                System.out.println("2. View All Employees");
                System.out.println("3. Update Salary");
                System.out.println("4. Delete Employee");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("First Name: "); String fn = sc.next();
                        System.out.print("Last Name: "); String ln = sc.next();
                        System.out.print("Email: "); String em = sc.next();
                        System.out.print("Phone: "); String ph = sc.next();
                        System.out.print("Department: "); String dept = sc.next();
                        System.out.print("Salary: "); double sal = sc.nextDouble();
                        Employee emp = new Employee(0, fn, ln, em, ph, dept, sal);
                        mainApp.createEmployee(conn, emp);
                        break;
                    case 2:
                        mainApp.readEmployees(conn);
                        break;
                    case 3:
                        System.out.print("Employee ID: "); int id = sc.nextInt();
                        System.out.print("New Salary: "); double newSal = sc.nextDouble();
                        mainApp.updateEmployee(conn, id, "salary", String.valueOf(newSal));
                        break;
                    case 4:
                        System.out.print("Employee ID to delete: "); int empid = sc.nextInt();
                        mainApp.deleteEmployee(conn, empid);
                        break;
                    case 0:
                        System.out.println("Exiting.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (choice != 0);

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }

      public void createEmployee(Connection conn, Employee emp){
        String sql = "INSERT INTO employee (first_name, last_name, email, phone, department, salary) VALUES (?, ?, ?, ?, ?, ?);";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, emp.getFirstName());
            ps.setString(2, emp.getLastName());
            ps.setString(3, emp.getEmail());
            ps.setString(4, emp.getPhone());
            ps.setString(5, emp.getDepartment());
            ps.setDouble(6, emp.getSalary());

            ps.executeUpdate();
            System.out.println("Employee added succesfully...");
            
        } catch (Exception e) {
        }
    }

    public void readEmployees(Connection conn) {
        String sql = "SELECT * FROM employee;";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                );
                System.out.println(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(Connection conn, int id, String colname, String colvalue) {
        String sql = "UPDATE employee SET " + colname + " = ? WHERE id = ?;";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, colvalue);
            ps.setInt(2, id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Employee not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(Connection conn, int empid) {
        String sql = "DELETE FROM employee WHERE id = ?;";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, empid);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee deleted successfully.");
            } else {
                System.out.println("Employee not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
