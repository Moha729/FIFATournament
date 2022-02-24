public class MatchPlayed extends Match{

    private int scorePlayer1;
    private int scorePlayer2;


    public MatchPlayed(Player player1, Player player2, int scorePlayer1, int scorePlayer2) {
        super(player1, player2);
        this.scorePlayer1 = scorePlayer1;
        this.scorePlayer2 = scorePlayer2;
    }

    @Override
    public String toString(){
        return String.format("%10s %2d - %-2d %-10s",getPlayer1(),getScorePlayer1(),getScorePlayer2(),getPlayer2());
    }

    public void setScorePlayer1(int scorePlayer1) {
        this.scorePlayer1 = scorePlayer1;
    }

    public void setScorePlayer2(int scorePlayer2) {
        this.scorePlayer2 = scorePlayer2;
    }

    public int getScorePlayer1() {
        return scorePlayer1;
    }

    public int getScorePlayer2() {
        return scorePlayer2;
    }
}
