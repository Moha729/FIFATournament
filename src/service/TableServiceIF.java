package service;

import modles.Player;
import modles.Table;

import java.util.ArrayList;

public interface TableServiceIF {

    public Table populateTable(ArrayList<Player> playersList);//and sort
    public Table getTable(ArrayList<Player> playersList);
}
