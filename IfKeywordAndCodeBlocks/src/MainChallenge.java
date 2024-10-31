public class MainChallenge {
    public static void main(String[] args) {

        int finalScore = calculateScore(true, 800, 8, 200);
        System.out.println("Your final score is " + finalScore);
        finalScore = calculateScore(false, 10000, 8, 200);
        System.out.println("Your final score is " + finalScore);
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus){

        int finalScore = score;

        if (gameOver) {
            finalScore += (levelCompleted * bonus);
        } else{
            System.out.println("The game is not over. What are you doing here?");
        }
        return finalScore;
    }
}
