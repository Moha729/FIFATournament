package service;

import modles.*;

import java.util.*;

public interface TournamentIF {

    public Tournament createNewTournament();
    public Tournament selectTournament();
    public ArrayList<Tournament> getTournaments();
}
