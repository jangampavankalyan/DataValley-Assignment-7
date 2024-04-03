import java.util.*;

class MedicalTestResult {
    private String patientName;
    private double resultValue;

    public MedicalTestResult(String patientName, double resultValue) {
        this.patientName = patientName;
        this.resultValue = resultValue;
    }

    public double getResultValue() {
        return resultValue;
    }
}

public class MedicalTestAnalyzer {
    public static void main(String[] args) {
        // Create a list of medical test results
        List<MedicalTestResult> testResults = new ArrayList<>();
        testResults.add(new MedicalTestResult("Patient 1", 95.0));
        testResults.add(new MedicalTestResult("Patient 2", 115.0));
        testResults.add(new MedicalTestResult("Patient 3", 80.0));
        testResults.add(new MedicalTestResult("Patient 4", 105.0));
        testResults.add(new MedicalTestResult("Patient 5", 120.0));

        // Define result ranges (example ranges, adjust as needed)
        double normalRangeStart = 80.0;
        double normalRangeEnd = 100.0;
        double borderlineRangeStart = 100.0;
        double borderlineRangeEnd = 120.0;
        double highRangeStart = 120.0;

        // Initialize variables to store results
        int normalCount = 0;
        int borderlineCount = 0;
        int highCount = 0;
        double normalTotal = 0.0;
        double borderlineTotal = 0.0;
        double highTotal = 0.0;

        // Iterate through each medical test result and categorize it into the appropriate range
        for (MedicalTestResult result : testResults) {
            double value = result.getResultValue();
            if (value >= normalRangeStart && value < normalRangeEnd) {
                normalCount++;
                normalTotal += value;
            } else if (value >= borderlineRangeStart && value < borderlineRangeEnd) {
                borderlineCount++;
                borderlineTotal += value;
            } else if (value >= highRangeStart) {
                highCount++;
                highTotal += value;
            }
        }

        // Calculate average value for each range and display the results
        System.out.println("Number of patients with results falling within specific ranges and average value:");
        if (normalCount > 0) {
            double normalAverage = normalTotal / normalCount;
            System.out.printf("Normal Range (%.0f-%.0f): %d patients, Average Value: %.2f%n",
                    normalRangeStart, normalRangeEnd, normalCount, normalAverage);
        }
        if (borderlineCount > 0) {
            double borderlineAverage = borderlineTotal / borderlineCount;
            System.out.printf("Borderline Range (%.0f-%.0f): %d patients, Average Value: %.2f%n",
                    borderlineRangeStart, borderlineRangeEnd, borderlineCount, borderlineAverage);
        }
        if (highCount > 0) {
            double highAverage = highTotal / highCount;
            System.out.printf("High Range (≥ %.0f): %d patients, Average Value: %.2f%n",
                    highRangeStart, highCount, highAverage);
        }
    }
}
