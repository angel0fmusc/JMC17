public class OperatorPrecedenceClass {
    public static void main(String[] args) {
        double firstDouble = 20.00;
        double secondDouble = 80.00;

        double result = (firstDouble + secondDouble) * 100.00;
        System.out.println("result = " + result);

        double remainderDouble = result % 40.00;
        System.out.println("remainderDouble = " + remainderDouble);

        boolean isZero = remainderDouble == 0.00;
        System.out.println("isZero = " + isZero);

        if(!isZero){
            System.out.println("Got some remainder");
        }
    }
}
