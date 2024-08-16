package cinema;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cinema {
    static Scanner scanner = new Scanner(System.in);
    static Integer rowCount;
    static Integer columnCount;
    static Integer customerRow;
    static Integer customerColumn;
    static Integer ticketPrice;
    static List<Seat> purchasedSeats = new ArrayList<>();
    static Integer currentIncome = 0;
    static boolean isValidSeatChoice;
    
    public static void main(String[] args) {
        // Write your code here
        getSeatingPlan();
        menu();
    }

    private static void menu(){
        boolean menuIsActive = true;
        int option;

        while(menuIsActive){

            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            option = scanner.nextInt();
            switch(option){
                case 1:
                    drawSeatingPlan();
                    break;
                case 2:
                    isValidSeatChoice = false;
                    while (!isValidSeatChoice){
                        purchaseSeat();
                    }
                    getTicketPrice();
                    break;
                case 3:
                    showStatistics();
                    break;
                case 0:
                    menuIsActive = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
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

            if (isTakenSeat(rowNumber, col)){
                System.out.print("B" + " ");
            } else if (col != columnCount) {
                System.out.print("S" + " ");
            }

        }
    }

    private static void purchaseSeat() {
        System.out.println("Enter a row number:");
        customerRow = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        customerColumn = scanner.nextInt();

        if (isTakenSeat(customerRow, customerColumn)){
            System.out.println("That ticket has already been purchased!");
        } else if (!isSeatInBounds(customerRow, customerColumn)){
            System.out.println("Wrong input!");
        } else {
            purchasedSeats.add(new Seat(customerRow, customerColumn));
            isValidSeatChoice = true;
        }
    }

    private static void getTicketPrice() {
        boolean isTenDollarRow = rowCount * columnCount <= 60 || customerRow <= rowCount / 2;

        ticketPrice = isTenDollarRow ? 10 : 8;
        currentIncome += ticketPrice;
        System.out.println("Ticket price: $" + ticketPrice);
    }

    // iterate through the seat list, return true if there is a match
    private static boolean isTakenSeat(Integer row, Integer col) {
        for (Seat seat : purchasedSeats) {
            if (seat.getRow() == row && seat.getColumn() == col) {
                return true;
            }
        }
        return false;
    }

    private static int calculateProfit(Integer rows, Integer columns) {
        if (rows * columns <= 60){
            return rows * columns * 10;
        }

        int highPriceRows = rows / 2;
        int lowPriceRows = rows - highPriceRows;
        return columns * ( (highPriceRows * 10) + (lowPriceRows * 8));
    }

    private static void showStatistics() {
        int purchasedSeatsCount = purchasedSeats.size();
        double percentageSeatsTaken = ((double) purchasedSeatsCount / ( rowCount * columnCount)) * 100;
        double roundedPercentage = getDecimalFormat(percentageSeatsTaken);
        int totalIncome = calculateProfit(rowCount, columnCount);

        System.out.println("Number of purchased tickets: " + purchasedSeatsCount);
        System.out.printf("Percentage: %.2f%%%n", roundedPercentage);
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);

    }

    private static double getDecimalFormat(double num) {
        DecimalFormat df = new DecimalFormat("0.00");
        String formattedNum = df.format(num);
        return Double.parseDouble(formattedNum);
    }

    private static boolean isSeatInBounds(Integer row, Integer col) {
        boolean rowInBounds = row <= rowCount && row > 0;
        boolean colInBounds = col <= columnCount && col > 0;
        return rowInBounds && colInBounds;
    }
}

