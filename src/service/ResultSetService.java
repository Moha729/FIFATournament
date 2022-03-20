package service;

import modles.Match;
import modles.MatchPlayed;
import modles.Player;
import modles.ResultSet;

import java.util.ArrayList;

public class ResultSetService implements ResultSetServiceIF{
    @Override
    public ArrayList<Match> makeMatches(ArrayList<Player> players, ArrayList<Match> unplayedMatches) {
        int y = players.size();
        int i = 0;
        int j = y - (y - (i + 1));

        for (i = 0; i < (y - 1); i++) {
            for (j = y - (y - (i + 1)); j < y; j++) {
                //System.out.println(players.get(i) + " vs. " + players.get(j));
                unplayedMatches.add(new Match(players.get(i), players.get(j)));
            }
        }
        return unplayedMatches;
    }

    @Override
    public ArrayList<MatchPlayed> createArrayListMatchPlayed() {
        return null;
    }

    @Override
    public MatchPlayed registerMatch(Match match) {
        return null;
    }

    @Override
    public ArrayList<Match> getUnPlayedMatches(ArrayList<Match> matchesList) {
        return null;
    }

    @Override
    public ArrayList<MatchPlayed> getPlayedMatches(ArrayList<MatchPlayed> playedMatchesList) {
        return null;
    }

    @Override
    public ResultSet getResultSet(ArrayList<Match> matchesList, ArrayList<MatchPlayed> playedMatches) {
        return null;
    }
}
