package controller;

import UI.MenuUI;
import UI.TournamentUI;
import modles.Match;
import modles.MatchPlayed;
import modles.Player;
import modles.Tournament;
import service.PlayerService;
import service.ResultSetService;
import service.TournamentService;

import java.util.ArrayList;

public class Controller {

    MenuUI menu = new MenuUI();

    public TournamentService tournamentService = new TournamentService();
    public PlayerService playerService = new PlayerService();
    public ResultSetService resultSetService = new ResultSetService();

    public ArrayList<Player> playersList = new ArrayList<>();
    public ArrayList<Match> matchesList = new ArrayList<>();
    public ArrayList<MatchPlayed> playedMatches = new ArrayList<>();
    public ArrayList<Tournament> tournaments = new ArrayList<>();

    //create connection
    //populate arraylists


}
