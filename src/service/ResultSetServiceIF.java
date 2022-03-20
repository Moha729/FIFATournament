package service;

import modles.*;

import java.util.*;

public interface ResultSetServiceIF {

    public ArrayList<Match> makeMatches(ArrayList<Player> playersList, ArrayList<Match> matchesList);//matchesList
    public ArrayList<MatchPlayed> createArrayListMatchPlayed();//playedMatchesList
    public MatchPlayed registerMatch(Match match);//gets added to playedMatchesList

    public ArrayList<Match> getUnPlayedMatches(ArrayList<Match> matchesList);

    public ArrayList<MatchPlayed> getPlayedMatches(ArrayList<MatchPlayed> playedMatchesList);

    public ResultSet getResultSet(ArrayList<Match> matchesList, ArrayList<MatchPlayed> playedMatches);

    /*
    //makeMatches
    //registerMatch

    //getPlayedMatches
    //getUnPlayedMatches

    //getResultSet


    public void displayMatches(ArrayList<Match> matchesList);//one print statement
    //maybe this one belong in the UI


    public ArrayList<MatchPlayed> displayPlayedMatches();//requires sharp toString coding

    public ArrayList<Match> makeMatches();
    public ResultSet displayMatches(ArrayList<Match> matchesList);

    public MatchPlayed registerMatch(Match match);
    //it gets returned then added to the list in the service class
    public ArrayList<MatchPlayed> displayPlayedMatches();
    public ResultSet viewResultSet(ArrayList<Match> matchesList, ArrayList<MatchPlayed> playedMatches);

    public ResultSet getResultSet();
    */
}
