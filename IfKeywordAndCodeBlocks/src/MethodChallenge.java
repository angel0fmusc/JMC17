public class MethodChallenge {
    public static void main(String[] args) {

        displayHighScorePosition("Tim", calculateHighScorePosition(1500));
        displayHighScorePosition("Bob", calculateHighScorePosition(999));
        displayHighScorePosition("Gerry", calculateHighScorePosition(499));
        displayHighScorePosition("Percy", calculateHighScorePosition(99));
        displayHighScorePosition("Janis", calculateHighScorePosition(-10000));

    }

    public static void displayHighScorePosition(String playerName, int position){
        System.out.println(playerName + " managed to get into position " + position + " on the high score list");
    }

    public static int calculateHighScorePosition(int score){
        int position = 4;

        if(score >= 1000){
            position = 1;
        } else if (score >= 500){
            position = 2;
        } else if (score >= 100){
            position = 3;
        }

        return position;
    }
}
