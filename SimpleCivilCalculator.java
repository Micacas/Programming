/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple.civil.calculator;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class SimpleCivilCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;
            
            do {
                displayMainMenu();
                System.out.print("Enter your choice (1-3 to select a category, 0 to exit): ");
                choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        engineeringDataAnalysis(scanner);
                        break;
                    case 2:
                        engineeringEconomy(scanner);
                        break;
                    case 3:
                        strengthOfMaterials(scanner);
                        break;
                    case 0:
                        System.out.println("Exiting program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 0 and 3.");
                        break;
                }
            } while (choice != 0);
        }
    }

    private static void displayMainMenu() {
        System.out.println("\nMain Categories:");
        System.out.println("1. Engineering Data Analysis");
        System.out.println("2. Engineering Economy");
        System.out.println("3. Strength of Materials");
        System.out.println("0. Exit");
    }

    private static void engineeringDataAnalysis(Scanner scanner) {
        int subChoice;

        do {
            System.out.println("\nEngineering Data Analysis - Subcategories:");
            System.out.println("1. Mean / Average");
            System.out.println("2. Standard Deviation");
            System.out.println("0. Back to Main Categories");
            System.out.print("Enter your choice: ");
            subChoice = scanner.nextInt();

            switch (subChoice) {
                case 1:
                    meanAverage(scanner);
                    break;
                case 2:
                    standardDeviation(scanner);
                    break;
                case 0:
                    System.out.println("Going back to Main Categories.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 0, 1, or 2.");
                    break;
            }
        } while (subChoice != 0);
    }

    private static void meanAverage(Scanner scanner) {
        int entryChoice;

        do {
            System.out.println("\nMean / Average - Entry Options:");
            System.out.println("1. Input all testing data");
            System.out.println("2. Input two values");
            System.out.println("0. Back to Engineering Data Analysis");
            System.out.print("Enter your choice: ");
            entryChoice = scanner.nextInt();

            switch (entryChoice) {
                case 1:
                    inputAllTestingData(scanner);
                    break;
                case 2:
                    inputTwoValues(scanner);
                    break;
                case 0:
                    System.out.println("Going back to Engineering Data Analysis.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 0, 1, or 2.");
                    break;
            }
        } while (entryChoice != 0);
    }

    private static void inputAllTestingData(Scanner scanner) {
        System.out.print("Enter the testing data (comma-separated): ");
        scanner.nextLine();
        String dataInput = scanner.nextLine();
        String[] data = dataInput.split(",");
        double[] values = Arrays.stream(data)
                .mapToDouble(Double::parseDouble)
                .toArray();

        Arrays.sort(values);
        double sum = Arrays.stream(values).sum();
        int totalItems = values.length;
        double mean = sum / totalItems;

        System.out.println("Arrangement of data: " + Arrays.toString(values));
        System.out.println("Sum of data: " + sum);
        System.out.println("Total number of items: " + totalItems);
        System.out.println("Mean (average): " + mean);
    }

    private static void inputTwoValues(Scanner scanner) {
        System.out.print("Enter value 1: ");
        double value1 = scanner.nextDouble();
        System.out.print("Enter value 2: ");
        double value2 = scanner.nextDouble();

        double mean = value1 / value2;
        System.out.println("Mean (average): " + mean);
    }
    
    private static void standardDeviation(Scanner scanner) {
        System.out.print("Enter the data (comma-separated): ");
        scanner.nextLine();
        String dataInput = scanner.nextLine();
        String[] data = dataInput.split(",");
        double[] values = Arrays.stream(data)
                .mapToDouble(Double::parseDouble)
                .toArray();

        double mean = calculateMean(values);
        double sumSquaredDeviations = Arrays.stream(values)
                .map(value -> Math.pow(value - mean, 2))
                .sum();
        double variance = sumSquaredDeviations / values.length;
        double standardDeviation = Math.sqrt(variance);

        System.out.println("Data: " + Arrays.toString(values));
        System.out.println("Mean: " + mean);
        System.out.println("Variance: " + variance);
        System.out.println("Standard Deviation: " + standardDeviation);
    }

    private static double calculateMean(double[] values) {
        return Arrays.stream(values).average().orElse(0.0);
    }

    private static void engineeringEconomy(Scanner scanner) {
        int subChoice;

        do {
            System.out.println("\nEngineering Economy - Subcategories:");
            System.out.println("1. Interest and Discount");
            System.out.println("0. Back to Main Categories");
            System.out.print("Enter your choice: ");
            subChoice = scanner.nextInt();

            switch (subChoice) {
                case 1:
                    interestAndDiscount(scanner);
                    break;
                case 0:
                    System.out.println("Going back to Main Categories.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 0 or 1.");
                    break;
            }
        } while (subChoice != 0);
    }

    private static void interestAndDiscount(Scanner scanner) {
        int subSubChoice;

        do {
            System.out.println("\nInterest and Discount - Subcategories:");
            System.out.println("1. Simple Interest");
            System.out.println("0. Back to Engineering Economy");
            System.out.print("Enter your choice: ");
            subSubChoice = scanner.nextInt();

            switch (subSubChoice) {
                case 1:
                    simpleInterest(scanner);
                    break;
                case 0:
                    System.out.println("Going back to Engineering Economy.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 0 or 1.");
                    break;
            }
        } while (subSubChoice != 0);
    }

    private static void simpleInterest(Scanner scanner) {
        System.out.print("Enter principal (P): ");
        double principal = scanner.nextDouble();
        System.out.print("Enter rate of interest (r): ");
        double rate = scanner.nextDouble();
        System.out.print("Enter time in years (t): ");
        double time = scanner.nextDouble();

        double interest = principal * rate * time;
        double futureAmount = principal * (1 + rate * time);

        System.out.println("Simple Interest: " + interest);
        System.out.println("Future Amount: " + futureAmount);
    }

    private static void strengthOfMaterials(Scanner scanner) {
        int subChoice;

        do {
            System.out.println("\nStrength of Materials - Subcategories:");
            System.out.println("1. Simple Normal Stress");
            System.out.println("2. Shear Stress");
            System.out.println("0. Back to Main Categories");
            System.out.print("Enter your choice: ");
            subChoice = scanner.nextInt();

            switch (subChoice) {
                case 1:
                    simpleNormalStress(scanner);
                    break;
                case 2:
                    shearStress(scanner);
                    break;
                case 0:
                    System.out.println("Going back to Main Categories.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 0, 1, or 2.");
                    break;
            }
        } while (subChoice != 0);
    }

    private static void simpleNormalStress(Scanner scanner) {
        System.out.print("Enter applied normal load (P): ");
        double appliedLoad = scanner.nextDouble();
        System.out.print("Enter area (A): ");
        double area = scanner.nextDouble();

        double normalStress = appliedLoad / area;

        System.out.println("Normal Stress (q): " + normalStress);
    }

    private static void shearStress(Scanner scanner) {
        System.out.print("Enter shear stress (T): ");
        double shearStress = scanner.nextDouble();
        System.out.print("Enter resultant shearing force (V): ");
        double shearingForce = scanner.nextDouble();
        System.out.print("Enter area (Av): ");
        double area = scanner.nextDouble();

        double calculatedShearStress = shearingForce / area;

        System.out.println("Calculated Shear Stress (T): " + calculatedShearStress);
    }
}
