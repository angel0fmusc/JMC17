import java.util.Scanner;

public class MinAndMaxChallenge {
    public static void main(String[] args) {

        int min= 0, max = 0;
        int loopCount = 0;
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter a number to continue, or any character to quit: ");
            try{
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);
                System.out.println("You entered " + number);

                if(loopCount==0 || number < min){
                    min = number;
                }

                if (loopCount == 0 || number > max){
                    max = number;
                }
                loopCount++;
            } catch (NumberFormatException characterInput){
                System.out.println("Quitting now! Thanks!");
                quit = true;
            }
        } while(!quit);

        System.out.println("Current minimum: " + min);
        System.out.println("Current maximum: " + max);
    }
}
