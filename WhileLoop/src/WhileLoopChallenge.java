public class WhileLoopChallenge {
    public static void main(String[] args) {
        int num = 5;
        int count = 0;

        while( num <= 20){
            if(isEvenNumber(num)){
                System.out.println(num);
                count++;
            }
            num++;
            if(count == 5){
                break;
            }
        }
    }

    public static boolean isEvenNumber(int number){
        return (number % 2 == 0);
    }
}
