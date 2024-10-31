public class Main {
    public static void main(String[] args) {
        int newScore = calculateScore("Tim", 500);
        System.out.println("New score is " + newScore);

        int secondScore = calculateScore(75);
        System.out.println("Second score is " + secondScore);
    }

    public static int calculateScore(String playerName, int score){
        System.out.println("Player " + playerName +
                " scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore(int score){
        System.out.println("Player scored " + score + " points");
        return score * 1000;
    }
}
