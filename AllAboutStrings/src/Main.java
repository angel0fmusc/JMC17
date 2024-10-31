public class Main {

    public static void main(String[] args) {

        printInformation("Hello World");
        printInformation("");
        printInformation("\t   \n");

        String helloWorld = "Hello World";
        System.out.printf("Index of r = %d%n", helloWorld.indexOf('r'));
        System.out.printf("Index of World = %d%n", helloWorld.indexOf("World"));

        System.out.printf("Index of l = %d%n", helloWorld.indexOf('l'));
        System.out.printf("Index of l = %d%n", helloWorld.lastIndexOf('l'));

        String helloWorldLower = helloWorld.toLowerCase();
        if(helloWorld.equals(helloWorldLower)){
            System.out.println("Values match exactly");
        }
        if(helloWorld.equalsIgnoreCase(helloWorldLower)){
            System.out.println("Values match ignoring case");
        }

        if(helloWorld.startsWith("Hello")){
            System.out.println("String starts with Hello");
        }

        if(helloWorld.endsWith("World")){
            System.out.println("String ends with World");
        }

        if(helloWorld.contains("or")){
            System.out.println("String contains or");
        }

        if(helloWorld.contentEquals("Hello World")){
            System.out.println("Values match exactly");
        }

    }

    public static void printInformation(String str){

        int length = str.length();
        System.out.printf("Length = %d%n", length);
        if(str.isEmpty()){
            System.out.println("String is Empty");
            return;
        }
        if(str.isBlank()){
            System.out.println("String is blank");
        }
        System.out.printf("First char = %c%n", str.charAt(0));
        System.out.printf("Last char = %c%n", str.charAt(length-1));
    }
}
