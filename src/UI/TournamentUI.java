package UI;

import modles.*;

import java.util.*;

public class TournamentUI implements TournamentUIIF{
    @Override
    public Tournament createNewTournament() {
        return null;
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

    }

    @Override
    public void showUnplayedMatches(ArrayList<Match> matchesList) {

    }

    @Override
    public void showPlayedMatches(ArrayList<MatchPlayed> playedMathces) {

    }
}
