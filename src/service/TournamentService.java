package service;

import modles.Player;
import modles.Tournament;

import java.util.ArrayList;
import java.util.Date;

public class TournamentService implements TournamentServiceIF {


    @Override
    public Tournament createNewTournament(String name) {
        return new Tournament(66, name, new Date(), null, null,
                null, null);
    }

    @Override
    public Tournament selectTournament() {
        System.out.println();
        return null;
    }

    @Override
    public ArrayList<Tournament> getTournaments() {
        return null;
    }
}
