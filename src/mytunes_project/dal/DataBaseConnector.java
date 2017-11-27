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
 * This makes a connection to the Database 
 * @author Mikkel
 */
public class DataBaseConnector
{

    private SQLServerDataSource dataSource;

    public DataBaseConnector() throws IOException
    {
        dataSource = new SQLServerDataSource();

        dataSource.setServerName("EASV-DB2");
        dataSource.setPortNumber(1433);
        dataSource.setDatabaseName("MyTunesMMEF");
        dataSource.setUser("CS2017A_25");
        dataSource.setPassword("javajava");
    }

    public Connection getConnection() throws SQLServerException
    {
        return dataSource.getConnection();
    }
}
