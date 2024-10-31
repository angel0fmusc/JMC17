public class Challenge {
    public static void main(String[] args) {
        double heightInCentimeters = convertToCentimeters(5, 8);
        System.out.println("5ft, 8in = " + heightInCentimeters + " cm");
        System.out.println("68in = " + convertToCentimeters(68) + " cm");

    }

    public static double convertToCentimeters(int heightInInches){
        double centimetersConversion = (double)(heightInInches * 2.54);
        return centimetersConversion;
    }

    public static double convertToCentimeters(int heightInFeet, int remainingHeightInInches){
        int feetConversionToInches = heightInFeet * 12; // 1 ft = 12 inches
        int totalHeightInInches = feetConversionToInches + remainingHeightInInches;

        return convertToCentimeters(totalHeightInInches);
    }
}
