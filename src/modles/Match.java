package modles;

import modles.Player;

public class Match {

        private Player player1;
        private Player player2;

        public Match(Player player1, Player player2){
                this.player1 = player1;
                this.player2 = player2;
        }

        public String toString (){

                return String.format("%10s  vs.  %-10s",getPlayer1().getName(), getPlayer2().getName());
        }

        public void setPlayer1(Player player1){
                this.player1 = player1;
        }

        public void setPlayer2(Player player2) {
                this.player2 = player2;
        }
        public Player getPlayer1(){
                return player1;
        }
        public Player getPlayer2(){
                return player2;
        }
}
