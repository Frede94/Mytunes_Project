/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;

/**
 * @author Mikkel
 */
public class DataBaseConnector
{

    private SQLServerDataSource ds = new SQLServerDataSource();

    /*
    Opretter forbindelse til databasen
     */
    public DataBaseConnector()
    {
        ds.setDatabaseName("MyTunesMMEF");
        ds.setUser("CS2017A_25_java");
        ds.setPassword("javajava");
        ds.setServerName("EASV-DB2");
        ds.setPortNumber(1433);
    }

    public Connection getConnection() throws SQLServerException
    {
        return ds.getConnection();
    }
}
