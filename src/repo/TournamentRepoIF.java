package repo;

import modles.*;

import java.util.*;

public interface TournamentRepoIF {

    public void addTournament(Tournament tournament);
    public void updateTournamentData(Tournament tournament);
    public ArrayList<Tournament> readTournaments();

}
