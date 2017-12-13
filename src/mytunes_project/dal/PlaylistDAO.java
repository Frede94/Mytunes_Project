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

/**
 *
 * @author Mikkel
 */
public class PlaylistDAO
{

    public void remove(Playlist selectedPlaylist)
    {
        try (Connection con = dbc.getConnection())
        {
            Statement stmt = con.createStatement();
            stmt.execute("DELETE FROM Playlists WHERE PlaylistId=" + selectedPlaylist.getPlaylistId());
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

}
