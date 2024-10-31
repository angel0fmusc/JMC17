public class Main {
    public static void main(String[] args) {

//        for (int i = 0; i <= 5; i++){
//            System.out.println(i);
//        }
//
//        int j = 0;
//
//        while (j <= 5){
//            System.out.println(j);
//            j++;
//        }
//
//        boolean isReady = false;
//        do{
//
//        } while (isReady);

        int number = 0;
        while (number < 50){
            number += 5;
            if(number % 25 == 0){
                continue;
            }
            System.out.print(number + "_");
        }
    }
}
