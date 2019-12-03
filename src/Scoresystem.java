public class Scoresystem {

    /**
     * Implement Scoresystem:
     * For every move the player makes -50 points
     * If Treasure is found or Wumpus killed +500 points
     * If killed through hole/Wumpus -1000
     * Print Score at the end of the game
     */

    private int score = 0;

    private int foundTreasureScore = 1000;
    private int killedWumpusScore = 1000;
    private int changedRoomScore = -50;
    private int getKilledScore = -1000;

    private static Scoresystem scoresystem = new Scoresystem();

    private Scoresystem() {
    }

    public static Scoresystem getInstance(){
        return scoresystem;
    }

    public int getFoundTreasureScore() {
        return foundTreasureScore;
    }

    public int getKilledWumpusScore() {
        return killedWumpusScore;
    }

    public int getChangedRoomScore() {
        return changedRoomScore;
    }

    public int getGetKilledScore() {
        return getKilledScore;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void updateScore(int scoreChange){
        int newScore = getScore();
        newScore += scoreChange;
        setScore(newScore);
    }
}
