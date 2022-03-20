package UI;

import controller.Controller;
import modles.Match;
import modles.MatchPlayed;
import modles.Player;
import modles.Tournament;

import java.util.ArrayList;

public class MenuUI {

    TournamentUI tournamentUI = new TournamentUI();


    UITools tools = new UITools();
    Controller controller = new Controller();

    String headText = "Velkommen til din FIFA22 Tunering";

    String firstOption1 = "Opret ny tunering";
    String firstOption2 = "Load en tunering";

    String optionOne1 = "Giv tuneringen navn";

    String optionOne2 = "Indtast hold";

    String secondOption1 = "Tilføje flere";
    String secondOption2 = "Start tunering";

    String thirdOption = "Vælg kamp";

    public void printHeadLine(String headText){
        tools.customizedButton(120, 5, headText);
    }

    public int printFirstOption(){//Create or load
        return 0;
    }
    //option1
    public Player getPlayer(String optionOne2){
        return controller.playerService.newPlayer(tools.returnStringInfo(50,1,optionOne2));
    }
    public int printSecondOption(){
        return 0;
    }

    public ArrayList<Player> populatePlayersList(ArrayList<Player> playersList){
        playersList.add(getPlayer(optionOne2));
        do {
            playersList.add(getPlayer(optionOne2));

        } while (printSecondOption()==1);
        return playersList;
    }
    public void createNewTournament(ArrayList<Player> playersList, ArrayList<Match> matchesList){
        Tournament tournament = tournamentUI.registerNewTournament(optionOne1);
        controller.tournaments.add(tournament);

        playersList = populatePlayersList(playersList);
        tournament.setPlayerList(playersList);

        matchesList = tournamentUI.makeMatches(playersList);






    }
    //option2


    public void runTournament(){}

    public void showTable(ArrayList<Player> playersList) {

    }

    public void showUnplayedMatches(ArrayList<Match> matchesList) {

    }

    public void showPlayedMatches(ArrayList<MatchPlayed> playedMathces) {

    }
}
