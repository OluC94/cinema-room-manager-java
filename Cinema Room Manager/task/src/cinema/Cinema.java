package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        System.out.println("Cinema:");
        drawRowLabel();
        drawRows();
        getProfitFromSeatingPlan();
    }

    private static void drawRowLabel() {
        for (int i = 0; i < 9; i++) {
            if (i == 0){
                System.out.print("  ");
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void drawRows() {
        for (int row = 1; row < 8; row++) {
            drawOneRow(row);
            System.out.println();
        }
    }

    private static void drawOneRow(Integer rowNumber) {
        for (int col = 0; col < 9; col++) {
            if (col == 0){
                System.out.print(rowNumber + " ");
                continue;
            }

            if (col != 8){
                System.out.print("S" + " ");
            }

        }
    }

    private static void getProfitFromSeatingPlan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        Integer rows =  scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        Integer columns = scanner.nextInt();
        System.out.println("Total income:");
        System.out.println("$" + calculateProfit(rows, columns));
    }

    private static Integer calculateProfit(Integer rows, Integer columns) {
        if (rows * columns <= 60){
            return rows * columns * 10;
        }

        int highPriceRows = rows / 2;
        int lowPriceRows = rows - highPriceRows;
        return columns * ( (highPriceRows * 10) + (lowPriceRows * 8));
    }


}