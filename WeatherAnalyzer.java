import java.util.*;

class WeatherData {
    private double temperature;
    private double humidity;

    public WeatherData(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }
}

public class WeatherAnalyzer {
    public static void main(String[] args) {
        // Create a list of weather data
        List<WeatherData> weatherList = new ArrayList<>();
        weatherList.add(new WeatherData(8.0, 70.0));
        weatherList.add(new WeatherData(15.0, 65.0));
        weatherList.add(new WeatherData(5.0, 80.0));
        weatherList.add(new WeatherData(-2.0, 90.0));
        weatherList.add(new WeatherData(20.0, 50.0));

        // Define temperature ranges
        double[] tempRanges = {-Double.MAX_VALUE, 0.0, 10.0, 20.0, 30.0, Double.MAX_VALUE};

        // Initialize variables to store results
        int[] daysByTempRange = new int[tempRanges.length - 1];
        double[] totalHumidityByTempRange = new double[tempRanges.length - 1];

        // Iterate through each weather data and categorize it into the appropriate temperature range
        for (WeatherData data : weatherList) {
            double temperature = data.getTemperature();
            double humidity = data.getHumidity();
            for (int i = 0; i < tempRanges.length - 1; i++) {
                if (temperature >= tempRanges[i] && temperature < tempRanges[i + 1]) {
                    daysBy
