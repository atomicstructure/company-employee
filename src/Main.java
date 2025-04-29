import java.util.*;
import java.util.function.Function;


public class Main {
    public static void main(String[] args) {
        // Sample dataset
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 28, "HR", 50000),
                new Employee("Bob", 35, "Engineering", 75000),
                new Employee("Charlie", 32, "Sales", 60000),
                new Employee("David", 45, "Engineering", 80000),
                new Employee("Eve", 29, "HR", 55000)
        );

        // Function to concatenate name and department
        Function<Employee, String> nameAndDepartment = emp -> emp.getName() + " - " + emp.getDepartment();

        // Generate new collection with concatenated strings
        List<String> nameAndDeptList = employees.stream()
                .map(nameAndDepartment)
                .toList();

        // Print the concatenated strings
        nameAndDeptList.forEach(System.out::println);

        // Calculate the average salary
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        System.out.println("Average Salary: " + averageSalary);

        // Filter employees by age threshold (e.g., age > 30)
        int ageThreshold = 30;
        List<Employee> filteredEmployees = employees.stream()
                .filter(emp -> emp.getAge() < ageThreshold)
                .toList();

        // Print filtered employees
        filteredEmployees.forEach(emp -> System.out.println(emp.getName() + " - " + emp.getAge()));
    }
}