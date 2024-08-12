package cinema;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        System.out.println("Cinema:");
        drawRowLabel();
        drawRows();
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
}