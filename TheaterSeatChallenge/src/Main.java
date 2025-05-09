public class Main {

    public static void main(String[] args) {

        int rows = 10;
        int totalSeats = 100;
        Theatre pantages = new Theatre("Pantages Theatre", rows, totalSeats);

        pantages.printSeatMap();

        bookSeat(pantages, 'A', 3);
        bookSeat(pantages, 'Z', 57);
        bookSeat(pantages, 'B', 1);
        bookSeat(pantages, 'B', 11);

        bookSeats(pantages, 4, 'B', 3, 10);
        bookSeats(pantages, 6, 'B', 'C', 3, 10);
        bookSeats(pantages, 4, 'B', 1, 10);
        bookSeats(pantages, 4, 'B', 'C', 1, 10);
        bookSeats(pantages, 1, 'B', 'C', 1, 10);
        bookSeats(pantages, 4, 'M', 'Z', 1, 10);
        bookSeats(pantages, 10, 'A', 'E', 1, 10);
    }

    private static void bookSeat(Theatre theatre, char row, int seatNo){

        String seat = theatre.reserveSeat(row, seatNo);
        if(seat != null){
            System.out.println("Congratulations! Your reserved seat is " + seat);
            theatre.printSeatMap();
        } else{
            System.out.println("Sorry! Unable to reserve seat " + row + seatNo);
        }
    }

    private static void bookSeats(Theatre theatre, int tickets, char minRow,
                                  int minSeat, int maxSeat){
        bookSeats(theatre, tickets, minRow, minRow, minSeat, maxSeat);
    }

    private static void bookSeats(Theatre theatre, int tickets, char minRow, char maxRow,
                                  int minSeat, int maxSeat){

        var seats = theatre.reserveSeats(tickets, minRow, maxRow, minSeat, maxSeat);
        if(seats != null) {
            System.out.println("Congratulations! Your reserved seats are " + seats);
            theatre.printSeatMap();
        } else{
            System.out.println("Sorry! No matching contiguous seats in rows: " +
                    minRow + " - " + maxRow);
        }
    }
}
