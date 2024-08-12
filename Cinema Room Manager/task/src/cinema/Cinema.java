package cinema;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
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
    }

    private static void drawRows() {
        for (int row = 0; row < 5; row++) {
            drawOneRow();
        }
    }

    private static void drawOneRow() {}
}