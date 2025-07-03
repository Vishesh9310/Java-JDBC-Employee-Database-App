public class Employee {
    private int id;
    private String first_name, last_name, email, phone, department;
    private double salary;

    public Employee(int id, String first_name, String last_name, String email, String phone, String department, double salary){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.salary = salary;
    }

    //getters
    public int getId() { return id; }
    public String getFirstName() { return first_name; }
    public String getLastName() { return last_name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    //toString for displaying
    @Override
    public String toString(){
        return  id + " | " + first_name + " " + last_name + " | " + email + " | " + phone + " | " + department + " | " + salary;
    }
}