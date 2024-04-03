import java.util.*;

class House {
    private double price;
    private double squareFootage;

    public House(double price, double squareFootage) {
        this.price = price;
        this.squareFootage = squareFootage;
    }

    public double getPrice() {
        return price;
    }

    public double getSquareFootage() {
        return squareFootage;
    }
}

public class HousingAnalyzer {
    public static void main(String[] args) {
        // Create a list of housing prices and square footages
        List<House> houses = new ArrayList<>();
        houses.add(new House(150000.0, 1200.0));
        houses.add(new House(250000.0, 1800.0));
        houses.add(new House(180000.0, 1500.0));
        houses.add(new House(300000.0, 2200.0));
        houses.add(new House(120000.0, 1000.0));

        // Define price ranges
        double[] priceRanges = {100000.0, 200000.0, 300000.0, 400000.0, Double.MAX_VALUE};

        // Initialize variables to store results
        int[] housesSoldByRange = new int[priceRanges.length - 1];
        double[] totalSquareFootageByRange = new double[priceRanges.length - 1];

        // Iterate through each house and categorize it into the appropriate price range
        for (House house : houses) {
            double price = house.getPrice();
            double squareFootage = house.getSquareFootage();
            for (int i = 0; i < priceRanges.length - 1; i++) {
                if (price >= priceRanges[i] && price < priceRanges[i + 1]) {
                    housesSoldByRange[i]++;
                    totalSquareFootageByRange[i] += squareFootage;
                    break;
                }
            }
        }

        // Calculate average square footage for each price range and display the results
        System.out.println("Number of houses sold within specific price ranges and average square footage:");
        for (int i = 0; i < priceRanges.length - 1; i++) {
            if (housesSoldByRange[i] > 0) {
                double averageSquareFootage = totalSquareFootageByRange[i] / housesSoldByRange[i];
                System.out.printf("$%.2f - $%.2f: %d houses, Average Square Footage: %.2f sq.ft.%n",
                        priceRanges[i], priceRanges[i + 1], housesSoldByRange[i], averageSquareFootage);
            }
        }
    }
}
