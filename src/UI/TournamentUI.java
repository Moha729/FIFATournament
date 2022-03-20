package UI;

import controller.Controller;
import modles.Match;
import modles.MatchPlayed;
import modles.Player;
import modles.Tournament;

import java.util.ArrayList;


public class TournamentUI implements TournamentUIIF {
    UITools tools = new UITools();
    Controller controller = new Controller();

    @Override
    public Tournament registerNewTournament(String optionOne1) {
        return controller.tournamentService.createNewTournament(tools.returnStringInfo(50, 1, optionOne1));

    }

    @Override
    public Tournament loadTournament() {

        return null;
    }

    @Override
    public ArrayList<Player> populatePlayer() {

        return null;
    }

    @Override
    public ArrayList<Match> makeMatches(ArrayList<Player> playersList) {
        return null;
    }

    @Override
    public Match getMatch(ArrayList<Match> matchesList) {
        return null;
    }

    @Override
    public MatchPlayed registerMatch(Match match) {
        return null;
    }

    @Override
    public void showTable(ArrayList<Player> playersList) {

        tools.margeTop(70);
        System.out.printf("|%-20s %-3s %-3s %-4s %-3s %-3s %-4s %-3s %-3s |", "Team",
                "M", "P", "W", "D", "L", "GF", "GA", "GD");
        for (int i = 0; i < playersList.size(); i++)
            System.out.println("| " + playersList.get(i).fullString() + " |");

        tools.margeTop(70);

    }

    @Override
    public void showUnplayedMatches(ArrayList<Match> matchesList) {
        for (int i = 0; i < matchesList.size(); i++)
            tools.customizedButton(40, 1, matchesList.get(i).toString());
    }

    @Override
    public void showPlayedMatches(ArrayList<MatchPlayed> playedMathces) {
        for (int i = 0; i < playedMathces.size(); i++)
            tools.customizedButton(40, 1, playedMathces.get(i).toString());
    }
}
