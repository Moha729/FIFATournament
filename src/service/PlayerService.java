package service;

import controller.Controller;
import modles.Player;

public class PlayerService implements PlayerServiceIF{

    Controller controller = new Controller();

    @Override
    public Player newPlayer(String name) {
        return new Player(name, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    @Override
    public Player updatePlayer(Player player) {
        return null;
    }
}
