public class StringMethods {

    public static void main(String[] args) {

        String birthDate = "11/25/1982";
        int startingIndex = birthDate.indexOf("1982");
        System.out.println("StartingIndex = " + startingIndex);
        System.out.println("Birth year = " + birthDate.substring(startingIndex));

        System.out.println("Day = " + birthDate.substring(3,5));

        String newDate = String.join("/", "25","11","1982");
        System.out.println("newDate = " + newDate);

        System.out.println(newDate.replace("/", "-"));
        System.out.println(newDate.replace("2", "two"));
        System.out.println(newDate.replaceFirst("/", "-"));
        System.out.println(newDate.replaceAll("/", "---"));
    }
}
