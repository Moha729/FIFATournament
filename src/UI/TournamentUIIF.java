package UI;

import modles.*;

import java.util.ArrayList;

public interface TournamentUIIF {

    public Tournament createNewTournament();//create
    public Tournament loadTournament();//load

    public ArrayList<Player> populatePlayer();//asks how many player and register them

    public ArrayList<Match> makeMatches(ArrayList<Player> playersList);//auto

    public Match getMatch(ArrayList<Match> matchesList);//choose match by index

    public MatchPlayed registerMatch(Match match);//updates the player too

    //public ArrayList<Player> updatePlayers(ArrayList<Player> playersList, MatchPlayed matchPlayed);
    //Maybe unnecessary method if referenced correctly

    public void showTable(ArrayList<Player> playersList);//sort by points
    public void showUnplayedMatches(ArrayList<Match> matchesList);
    public void showPlayedMatches(ArrayList<MatchPlayed> playedMathces);


}
