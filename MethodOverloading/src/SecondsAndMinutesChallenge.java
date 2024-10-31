public class SecondsAndMinutesChallenge {
    public static void main(String[] args) {
        System.out.println(getDurationString(580));
        System.out.println(getDurationString(-580));
        System.out.println(getDurationString(3945));
        System.out.println(getDurationString(65, 45));
        System.out.println(getDurationString(-65, 45));
        System.out.println(getDurationString(65,145));
    }

    /**
     * A method that takes time, represented in seconds, as the parameter
     * We want to transform the seconds into hours
     * @param seconds
     * @return
     */

    public static String getDurationString(int seconds){
        if(seconds < 0){
            return "Invalid seconds";
        }

        // 1 minute = 60 seconds
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60; // Any remaining seconds from the minutes...?
        return getDurationString(minutes, remainingSeconds);


    }
    /**
     * We want to display the time in hours with the remaining minutes and seconds in a String
     */
    public static String getDurationString(int minutes, int seconds){
        if(minutes < 0 || (seconds < 0 || seconds > 59)){
            return "Invalid seconds or minutes";
        }
        
        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;
        String finalTime = hours + "h " + remainingMinutes + "m " + seconds + "s";
        return finalTime;

    }
}
