package cinema;

public class Seat{
    private final Integer row;
    private final Integer column;
    private boolean isBought = false;

    public Seat(Integer row, Integer column){
        this.row = row;
        this.column = column;
    }

    public void displaySeatData(){
        System.out.println("Row: " + row + ", Column: " + column);
    }

    public void buySeat(){
        isBought = true;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }
}
