package cinema;

import java.util.Objects;
import java.util.Scanner;

public class Cinema {
    static Scanner scanner = new Scanner(System.in);
    static Integer rowCount;
    static Integer columnCount;
    static Integer customerRow;
    static Integer customerColumn;
    static Integer ticketPrice;
    
    public static void main(String[] args) {
        // Write your code here
        getSeatingPlan();
        drawSeatingPlan();
        getCustomerSeat();
        getTicketPrice();
        drawSeatingPlan();
//        getProfitFromSeatingPlan();
    }

    private static void drawSeatingPlan() {
        System.out.println("Cinema:");
        drawRowLabel();
        drawRows();
    }
    
    private static void getSeatingPlan() {
        System.out.println("Enter the number of rows:");
        rowCount = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        columnCount = scanner.nextInt();
    }

    private static void drawRowLabel() {
        for (int i = 0; i <= columnCount; i++) {
            if (i == 0){
                System.out.print("  ");
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void drawRows() {
        for (int row = 1; row <= rowCount; row++) {
            drawOneRow(row);
            System.out.println();
        }
    }

    private static void drawOneRow(Integer rowNumber) {
        for (int col = 0; col <= columnCount + 1; col++) {
            if (col == 0){
                System.out.print(rowNumber + " ");
                continue;
            }

            if (Objects.equals(rowNumber, customerRow) && Objects.equals(col, customerColumn)){
                System.out.print("B" + " ");
            } else if (col != columnCount) {
                System.out.print("S" + " ");
            }

        }
    }

    private static void getCustomerSeat() {
        System.out.println("Enter a row number:");
        customerRow = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        customerColumn = scanner.nextInt();
    }

    private static void getTicketPrice() {
        boolean isTenDollarRow = rowCount * columnCount <= 60 || customerRow <= rowCount / 2;

        ticketPrice = isTenDollarRow ? 10 : 8;
        System.out.println("Ticket price: $" + ticketPrice);
    }

    private static void getProfitFromSeatingPlan() {
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

