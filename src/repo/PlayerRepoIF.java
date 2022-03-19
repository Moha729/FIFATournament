package repo;


import modles.*;

import java.util.*;

public interface PlayerRepoIF {

    public void addPlayers(ArrayList<Player> playersList);//db
    public void updatePlayer(ArrayList<Player> playersList);//db
    public ArrayList<Player> loadPlayers();//db

    //when this is done the table is running


}
