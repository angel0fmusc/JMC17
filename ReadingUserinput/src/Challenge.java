import java.util.Scanner;

public class Challenge {
    public static void main(String[] args) {
        getInputFromScanner();
    }

    public static void getInputFromScanner(){
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int counter = 1;

        do{
            System.out.print("Enter number #" + counter + ": ");
            // Check that it is a valid number
            try{
                int number = Integer.parseInt(scanner.nextLine());
                counter++;
                sum += number;

            } catch (NumberFormatException badUserInput){
                System.out.println("Invalid character. Try again");
            }

        } while(counter <= 5);

        System.out.println("The sum is " + sum);
    }
}
