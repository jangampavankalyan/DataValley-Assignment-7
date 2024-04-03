import java.util.*;

class Employee {
    private String name;
    private int[] workHours; // Assuming 7 days of work hours

    public Employee(String name, int[] workHours) {
        this.name = name;
        this.workHours = workHours;
    }

    public int getTotalHours() {
        int total = 0;
        for (int hours : workHours) {
            total += hours;
        }
        return total;
    }

    public double getAverageHours() {
        return getTotalHours() / 7.0; // Assuming 7 days in a week
    }
}

public class EmployeeWorkHoursAnalyzer {
    public static void main(String[] args) {
        // Create a list of employees with their work hours
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Employee 1", new int[]{8, 8, 8, 8, 8, 8, 8})); // 40 hours
        employees.add(new Employee("Employee 2", new int[]{9, 9, 9, 9, 9, 9, 9})); // 45 hours
        employees.add(new Employee("Employee 3", new int[]{7, 7, 7, 7, 7, 7, 7})); // 35 hours
        employees.add(new Employee("Employee 4", new int[]{10, 10, 10, 10, 10, 10, 10})); // 50 hours

        // Initialize variables to store results
        int moreThan40Count = 0;
        int exactly40Count = 0;
        int lessThan40Count = 0;
        double moreThan40Average = 0.0;
        double exactly40Average = 0.0;
        double lessThan40Average = 0.0;

        // Iterate through each employee and categorize them based on their work hours
        for (Employee employee : employees) {
            int totalHours = employee.getTotalHours();
            double averageHours = employee.getAverageHours();
            if (totalHours > 40) {
                moreThan40Count++;
                moreThan40Average += averageHours;
            } else if (totalHours == 40) {
                exactly40Count++;
                exactly40Average += averageHours;
            } else {
                lessThan40Count++;
                lessThan40Average += averageHours;
            }
        }

        // Calculate average hours per day for each group and display the results
        System.out.println("Number of employees with work hours and average hours per day for each group:");
        if (moreThan40Count > 0) {
            moreThan40Average /= moreThan40Count;
            System.out.printf("More than 40 hours: %d employees, Average Hours per Day: %.2f%n",
                    moreThan40Count, moreThan40Average);
        }
        if (exactly40Count > 0) {
            exactly40Average /= exactly40Count;
            System.out.printf("Exactly 40 hours: %d employees, Average Hours per Day: %.2f%n",
                    exactly40Count, exactly40Average);
        }
        if (lessThan40Count > 0) {
            lessThan40Average /= lessThan40Count;
            System.out.printf("Less than 40 hours: %d employees, Average Hours per Day: %.2f%n",
                    lessThan40Count, lessThan40Average);
        }
    }
}
