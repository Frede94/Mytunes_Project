/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mytunes_project.be.Playlist;
import mytunes_project.be.Song;

/**
 *
 * @author Mikkel
 */
public class PlaylistDAO
{

    SongDAO songDAO = new SongDAO();

    /**
     * Removes a plislist from the application and the database.
     *
     * @param selectedPlaylist
     */
    public void remove(Playlist selectedPlaylist)
    {
        try (Connection con = dbc.getConnection())
        {
            Statement stmt = con.createStatement();
            stmt.execute("DELETE FROM PLSRelation WHERE PLId =" + selectedPlaylist.getPlaylistId() + ";DELETE FROM Playlists WHERE PlaylistId=" + selectedPlaylist.getPlaylistId());
            
        } catch (SQLException ex)
        {
            Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    DataBaseConnector dbc = new DataBaseConnector();

    public void save(Playlist p)
    {
        try (Connection con = dbc.getConnection())
        {
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO Playlists (PlaylistName) VALUES (?)";
            PreparedStatement st = con.prepareStatement(sql); //,stmt.RETURN_GENERATED_KEYS
            st.setString(1, p.getPlaylistName());
            st.execute();
        } catch (SQLException ex)
        {
            Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public List<Playlist> getAllPlaylists()
    {
        List<Playlist> playlists = new ArrayList();

        try (Connection con = dbc.getConnection())
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Playlists");
            while (rs.next())
            {
                Playlist currentPlaylist = new Playlist();
                currentPlaylist.setPlaylistId(rs.getInt("PlaylistId"));
                currentPlaylist.setPlaylistName(rs.getString("PlaylistName"));
                currentPlaylist.setNumberofSongs(rs.getInt("NumberofSongs"));
                currentPlaylist.setTotalTime(rs.getFloat("TotalTime"));

                playlists.add(currentPlaylist);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return playlists;
    }

    /**
     * Updates the database with the new name for a playlist.
     *
     * @param editPlaylist
     */
    public void saveEdit(Playlist editPlaylist)
    {
        try (Connection con = dbc.getConnection())
        {
            String queryPlaylistName = "update Playlists set PlaylistName = ? where PlaylistId=" + editPlaylist.getPlaylistId();

            PreparedStatement preparedStmtPlaylistName = con.prepareStatement(queryPlaylistName);

            preparedStmtPlaylistName.setString(1, editPlaylist.getPlaylistName());

            preparedStmtPlaylistName.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addSong(Song selectedSong, Playlist selectedPlaylist)
    {
        try (Connection con = dbc.getConnection())
        {
            String sql = "INSERT INTO PLSRelation (PLId, SId) VALUES (?, ?);";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, selectedPlaylist.getPlaylistId());
            stmt.setInt(2, selectedSong.getSongId());
            System.out.println(stmt.toString());
            stmt.execute();
        } catch (SQLException ex)
        {
            Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Song> getSongsByRelation(int plId)
    {
        List<Song> songs = new ArrayList();
        List<Integer> songId = new ArrayList();

        try (Connection con = dbc.getConnection())
        {
            String sql = "SELECT * FROM PLSRelation WHERE PLId =" + plId;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {

                songId.add(rs.getInt("SId"));
            }

            if (!songId.isEmpty())
            {
                sql = "SELECT * FROM Song WHERE SongId =" + songId.get(0);

                for (int i = 1; i < songId.size(); i++)
                {
                    sql = sql + "OR SongId =" + songId.get(i);

                }
            } else
            {
                return null;
            }
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next())
            {

                Song currentSong = new Song();

                currentSong.setSongId(rs.getInt("SongId"));
                currentSong.setArtist(songDAO.getArtist(rs.getInt("ArtistId")));
                currentSong.setCategory(songDAO.getCategory(rs.getInt("CategoryId")));
                currentSong.setTime(rs.getFloat("Time"));
                currentSong.setTitle(rs.getString("Title"));
                currentSong.setPath(rs.getString("Path"));
                songs.add(currentSong);

            }
            return songs;
        } catch (SQLException ex)
        {
            Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
