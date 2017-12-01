/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import mytunes_project.be.Song;
import mytunes_project.bll.SearchFilter;

/**
 *
 * @author Mikkel
 */
public class SongDAO
{

    private ObservableList<Song> songsInSearch;
    private SongDAO songDao;
    private SearchFilter searchFilter;
    private DataBaseConnector dbConnector;

    DataBaseConnector dbc = new DataBaseConnector();

    /**
     * Gets a list from the "Song" database with the songs, id, title, Artist,
     * Category, Time & Path.
     *
     * @return
     */
    public List<Song> getAllSongs()
    {

        List<Song> songs = new ArrayList();

        try (Connection con = dbc.getConnection())
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Song");
            while (rs.next())
            {
                Song currentSong = new Song();
                currentSong.setSongId(rs.getInt("SongId"));
                currentSong.setTitle(rs.getString("Title"));
                currentSong.setArtist(rs.getString("Artist"));
                currentSong.setCategory(rs.getString("Category"));
                currentSong.setTime(rs.getFloat("Time"));
                currentSong.setPath(rs.getString("Path"));

                songs.add(currentSong);

            }
        } catch (SQLException ex)
        {
            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return songs;
    }

    /**
     * Searches in the list of songs.
     */
    public void search(String searchText)
    {
        

        List<Song> allSongs = songDao.getAllSongs();
        List<Song> searchResults = searchFilter.searchBySongName(allSongs, searchText);
        songsInSearch.clear();
        songsInSearch.addAll(searchResults);

    }

    /**
     * Removes the selected song from the program, and the database.
     *
     * @param selectedSong
     */
    public void remove(Song selectedSong)
    {

        try (Connection con = dbc.getConnection())
        {
            Statement stmt = con.createStatement();
            stmt.execute("DELETE FROM Song WHERE SongId=" + selectedSong.getSongId());
        } catch (SQLException ex)
        {
            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

//    public Song createSong(String title, String artistId, String categoryId, float time, String path) throws SQLServerException, SQLException
//    {
//        try (Connection con = dbConnector.getConnection())
//        {
//            String sql = "INSERT INTO Song VALUES (?,?,?,?,?);";
//
//            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//
//            statement.setString(1, title);
//            statement.setString(2, artistId);
//            statement.setString(3, categoryId);
//            statement.setFloat(4, time);
//            statement.setString(5, path);
//
//            if (statement.executeUpdate() == 1)
//            {
//                ResultSet rs = statement.getGeneratedKeys();
//                rs.next();
//                int SongId = rs.getInt(1);
//                Song s = new Song(SongId, title, artistId, categoryId, time, path);
//                return s;
//            }
//            throw new RuntimeException("Can't create Song");
//        }
//
//    }
/**
 * Gets a list of Songs with given title.
 *
 * @param title The title to search for.
 * @return the List of Songs that match the search.
 */
//    public List<Song> getSongsInAnSqlInjectionInsecureWay(String title) throws SQLException
//    {
//        try (Connection con = dbConnector.getConnection())
//        {
//            Statement st = con.createStatement();
//            String sql = "SELECT * FROM Song WHERE title = '" + title + "';";
//            ResultSet rs = st.getResultSet();
//            List<Song> allSongs = new ArrayList<>();
//            while (rs.next())
//            {
//                allSongs.add(getSongFromResultSetRow(rs));
//            }
//            return allSongs;
//        }
//    }
//    /**
//     * This method gets all songs from the database.
//     * @return
//     * @throws SQLException 
//     */
//    public List<Song> getAllSongs() throws SQLException
//    {
//        try (Connection con = dbConnector.getConnection())
//        {
//            String sql = "SELECT * FROM Song";
//
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//
//            List<Song> allSongs = new ArrayList<>();
//            while (rs.next())
//            {
//                Song song = getSongFromResultSetRow(rs);
//                allSongs.add(song);
//            }
//            return allSongs;
//        }
//    }
/**
 * Extracts a single song from the ResultSet at the current row
 *
 * @param rs The result set to work with
 * @return The Song represented at the current row
 * @throws SQLException
 */
//    private Song getSongFromResultSetRow(ResultSet rs) throws SQLException
//    {
//        int SongId = rs.getInt("SongId");
//        String title = rs.getString("titel");
//        String artistId = rs.getString("artist");
//        String categoryId = rs.getString("category");
//        float time = rs.getFloat("time");
//        String path = rs.getString("path");
//        
//        //Song song = new Song(SongId, title, artistId, categoryId, time, path);
//        return song;
//    }
