public class Printer {

    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = (tonerLevel >= 0 && tonerLevel <= 100) ? tonerLevel : -1;
        this.pagesPrinted = 0;
        this.duplex = duplex;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public boolean isDuplex() {
        return duplex;
    }

    @Override
    public String toString() {
        return "Printer{" +
                "tonerLevel=" + tonerLevel +
                ", pagesPrinted=" + pagesPrinted +
                ", duplex=" + duplex +
                '}';
    }

    public int addToner(int tonerAmount){
        int totalToner = tonerLevel + tonerAmount;
        if(totalToner > 100 || totalToner < 0){
            return -1;
        }
        tonerLevel = totalToner;
        return tonerLevel;
    }

    public int printPages(int pages){
        // duplex printers reduce number of pages printed
        // divide by 2; example: 5 total pages = 2 double-sided pages & 1 remaining page
        if(duplex){
            System.out.println("This is a duplex printer. Printing on both sides");
            int doubleSidedPages = pages / 2;
            int remainingSinglePage = pages % 2;
            pagesPrinted = pagesPrinted + doubleSidedPages + remainingSinglePage;
            return doubleSidedPages + remainingSinglePage;
        } else{
            pagesPrinted += pages;
            return pages;
        }
    }
}
