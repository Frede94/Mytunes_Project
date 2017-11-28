/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
<<<<<<< HEAD
=======

>>>>>>> b8e489500144f56be76bd87386499fb2cc17a37e
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mytunes_project.be.Song;

/**
 *
 * @author Mikkel
 */
public class SongDAO
{

    private DataBaseConnector dbConnector;

    public SongDAO() throws IOException
    {
        dbConnector = new DataBaseConnector();
    }

    public Song createSong(String title, String artistId, String categoryId, float time, String path) throws SQLServerException, SQLException
    {
        try (Connection con = dbConnector.getConnection())
        {
            String sql = "INSERT INTO Song VALUES (?,?,?,?,?);";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, title);
            statement.setString(2, artistId);
            statement.setString(3, categoryId);
            statement.setFloat(4, time);
            statement.setString(5, path);

            if (statement.executeUpdate() == 1)
            {
                ResultSet rs = statement.getGeneratedKeys();
                rs.next();
                int SongId = rs.getInt(1);
                Song s = new Song(SongId, title, artistId, categoryId, time, path);
                return s;
            }
            throw new RuntimeException("Can't create Song");
        }

    }

    /**
     * Gets a list of Songs with given title.
     *
     * @param title The title to search for.
     * @return the List of Songs that match the search.
     */
    public List<Song> getSongsInAnSqlInjectionInsecureWay(String title) throws SQLException
    {
        try (Connection con = dbConnector.getConnection())
        {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Song WHERE title = '" + title + "';";
            ResultSet rs = st.getResultSet();
            List<Song> allSongs = new ArrayList<>();
            while (rs.next())
            {
                allSongs.add(getSongFromResultSetRow(rs));
            }
            return allSongs;
        }
    }

    public List<Song> getAllSongs() throws SQLException
    {
        try (Connection con = dbConnector.getConnection())
        {
            String sql = "SELECT * FROM Song";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            List<Song> allSongs = new ArrayList<>();
            while (rs.next())
            {
                Song song = getSongFromResultSetRow(rs);
                allSongs.add(song);
            }
            return allSongs;
        }
    }

    /**
     * Extracts a single song from the ResultSet at the current row
     *
     * @param rs The result set to work with
     * @return The Song represented at the current row
     * @throws SQLException
     */
    private Song getSongFromResultSetRow(ResultSet rs) throws SQLException
    {
        int SongId = rs.getInt("SongId");
        String title = rs.getString("titel");
        String artistId = rs.getString("artist");
        String categoryId = rs.getString("category");
        float time = rs.getFloat("time");
        String path = rs.getString("path");
        
        Song song = new Song(SongId, title, artistId, categoryId, time, path);
        return song;
    }
}
