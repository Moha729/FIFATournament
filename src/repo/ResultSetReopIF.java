package repo;

import modles.*;

public interface ResultSetReopIF {

    public void addResultSet(ResultSet resultSet);//add played and unplayed matches
    //experiment with.. a resultset has a list of unplayed and a list of played

    public void updateResultSet(ResultSet resultSet);

    public ResultSet loadReasultSet();
}
