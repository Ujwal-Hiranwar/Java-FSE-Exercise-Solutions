import java.util.Scanner;

public class FinancialForecast {

    // Recursive method to forecast future value
    public static double forecastFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return forecastFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the initial value: ");
        double initialValue = scanner.nextDouble();

        System.out.print("Enter the annual growth rate (in %): ");
        double annualGrowthRate = scanner.nextDouble() / 100;

        System.out.print("Enter the number of years: ");
        int forecastYears = scanner.nextInt();

        double predictedValue = forecastFutureValue(initialValue, annualGrowthRate, forecastYears);
        System.out.printf("Predicted value after %d years: ₹%.2f%n", forecastYears, predictedValue);

        scanner.close();
    }
}
