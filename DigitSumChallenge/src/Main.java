public class Main {
    public static void main(String[] args) {

        System.out.printf("Sum of 125 = %d%n", sumDigits(125));
        System.out.printf("Sum of 32 = %d%n", sumDigits(32));
        System.out.printf("Sum of 300 = %d%n", sumDigits(300));
        System.out.printf("Sum of 1234 = %d%n", sumDigits(1234));
        System.out.printf("Sum of -50 = %d%n", sumDigits(-50));
        System.out.printf("Sum of 3 = %d%n", sumDigits(3));

    }

    public static int sumDigits(int number){
        if(number < 0){
            return -1;
        }

        int sum = 0;

        while(number > 0){
            sum += number % 10;
            number = number / 10;
        }

        return sum;
    }
}
