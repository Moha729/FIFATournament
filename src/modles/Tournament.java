package modles;

import java.util.*;

public class Tournament {

    private int id;
    private String name;
    private Date date;
    private Player winner;
    private ArrayList<Player> playerList;//get names
    private Table table;
    private ResultSet resultSet;

    public Tournament(int id, String name, Date date, Player winner,
                      ArrayList<Player> playerList, Table table, ResultSet resultSet) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.winner = winner;
        this.playerList = playerList;
        this.table = table;
        this.resultSet = resultSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
}
//String name
//Date date
//modles.Player winner *
//List participants
//Table table *
//List results *