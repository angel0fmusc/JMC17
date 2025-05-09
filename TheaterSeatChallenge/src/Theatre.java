import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class Theatre {

    private class Seat implements Comparable<Seat>{

        private String seatNum;
        private boolean reserved;

        public Seat(char row, int seatNo) {
            /*
            * The 0 pads numbers with zeros on the left.
            * The 3 is the width, specifying the minimum number
            * of characters the output should occupy.
            * */
            this.seatNum = "%c%03d".formatted(row, seatNo).toUpperCase();
        }

        public void setReserved(boolean reserved) {
            this.reserved = reserved;
        }

        @Override
        public String toString() {
            return seatNum;
        }

        @Override
        public int compareTo(Seat o) {
            return this.seatNum.compareTo(o.seatNum);
        }
    }

    private String theater;
    private int seatsPerRow;
    /*
    * Use the interface type (NavigableSet) as your reference type
    * */
    private NavigableSet<Seat> seats = new TreeSet<>();

    /**
     * Theater constructor. Assume uniform number of seats in every row.
     * Number of rows should never exceed 26. Rows labeled A-Z.
     * @param theater String, the name of the theatre
     * @param numRows int, number of rows in the theatre
     * @param totalSeats int, number of total seats in the theatre
     */
    public Theatre(String theater, int numRows, int totalSeats) {
        this.theater = theater;
        // Calculate the number of seats per row
        seatsPerRow = totalSeats / numRows;
        // Loop through the number of rows, for each row
        // get ASCII value for row
        for(int i = 0; i < totalSeats; i++){
            char rowChar = (char) (i / seatsPerRow + (int)'A');
            int seatInRow = i % seatsPerRow + 1;
            seats.add(new Seat(rowChar, seatInRow));
        }
    }

    /**
     * Prints each seat, with each row
     * printed on a separate line
     */
    public void printSeatMap(){
        String separatorLine = "-".repeat(90);
        /*
        * 1$ indicates which of the arguments to use, the 1 implies the first argument
        * (separator line), whereas the 2$ implies the second argument (theater)
        * %1$s is the first argument
        * %2$s is the second argument
        * */
        System.out.printf("%1$s%n%2$s Seat Map%n%1$s%n", separatorLine, theater);

        int index = 0;
        for(Seat s : seats){
            /*
            * The '-' makes the output left-justified by adding any padding spaces to the right
            * instead of the left. So, %-8s left-justifies the string, but takes up a minimum of
            * 8 characters in the output
            * */
            System.out.printf("%-8s%s", s.seatNum + ((s.reserved) ? "(●)" : ""),
                    /*
                    * index++ returns the current value of the variable (starting at 0)
                    * and THEN increments it by 1. So, the first pass will yield 1 % 10
                    * */
                    ((index++ + 1) % seatsPerRow == 0) ? "\n" : "");
        }
        System.out.println(separatorLine);
    }

    // Booking Agent needed to reserve seats
    public String reserveSeat(char row, int seat){

        Seat requestedSeat = new Seat(row, seat);
        /*
        * Sets don't have a get method. Floor gives the greatest element
        * equal to the passed element, or if no such element exists,
        * then it returns the greatest element that is less than the
        * passed element. Otherwise, null is returned
        * */
        Seat requested = seats.floor(requestedSeat);

        if(requested == null || !requested.seatNum.equals(requestedSeat.seatNum)){
            System.out.printf("--> No such seat: " + requestedSeat);
            System.out.printf(": Seat must be between %s and %s%n",
                    seats.first().seatNum, seats.last().seatNum);
        } else{
            if(!requested.reserved){
                requested.setReserved(true);
                return requested.seatNum;
            } else{
                System.out.println("Seat's already reserved.");
            }
        }
        return null;
    }

    private boolean validate(int count, char first, char last, int min, int max){

        /*
        * min should be greater than 0 because the seat numbers in any row always start
        * with 1. The user's shouldn't try to get more seats per row than are available.
        * The difference of max and min should be greater than the number of seats
        * that the user wants.*/
        boolean result = (min > 0 || seatsPerRow >= count || (min-max + 1) >= count);
        result = result && seats.contains(new Seat(first, min));
        if(!result){
            System.out.printf("Invalid! %1$d seats between " +
                    "%2$c[%3$d-%4$d]-%5$c[%3$d-%4$d] Try again",
                    count, first, min, max, last);
            System.out.printf(": Seats must be between %s and %s%n", seats.first().seatNum,
                    seats.last().seatNum);
        }

        return result;
    }

    public Set<Seat> reserveSeats(int count, char minRow, char maxRow,
                                  int minSeat, int maxSeat){

        // Get the last valid seat in the theatre
        char lastValid = seats.last().seatNum.charAt(0);
        maxRow = ( maxRow < lastValid ) ? maxRow : lastValid;

        if(!validate(count, minRow, maxRow, minSeat, maxSeat)){
            return null;
        }

        NavigableSet<Seat> selected = null;

        for(char letter = minRow; letter <= maxRow; letter++){
            NavigableSet<Seat> contiguous = seats.subSet(
                    new Seat(letter, minSeat), true,
                    new Seat(letter, maxSeat), true);

            int index = 0;
            Seat first = null;
            for(Seat current : contiguous){
                if(current.reserved){
                    index = 0;
                    continue;
                }

                first = (index == 0) ? current : first;
                if(++index == count){
                    selected = contiguous.subSet(first, true, current, true);
                    break;
                }
            }
            if(selected != null){
                break;
            }
        }

        Set<Seat> reservedSeats = null;
        if (selected != null){
            selected.forEach(s -> s.setReserved(true));
            reservedSeats = new TreeSet<>(selected);
        }
        return reservedSeats;
    }

}
