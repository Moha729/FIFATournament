package service;

import modles.*;

import java.util.*;

public interface TournamentServiceIF {

    public Tournament createNewTournament(String name);
    public Tournament selectTournament();
    public ArrayList<Tournament> getTournaments();
}
