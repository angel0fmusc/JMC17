public class Main {
    public static void main(String[] args) {
        Printer myPrinter = new Printer(50, false);

        System.out.println("Initial page count = " + myPrinter.getPagesPrinted());

        int pagesPrinted = myPrinter.printPages(5);
        System.out.printf("Current Job Pages: %d, Printer Total: %d %n", pagesPrinted, myPrinter.getPagesPrinted());

        pagesPrinted = myPrinter.printPages(10);
        System.out.printf("Current Job Pages: %d, Printer Total: %d %n", pagesPrinted, myPrinter.getPagesPrinted());


    }
}
