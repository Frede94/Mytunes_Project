/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.bll;

import java.util.List;
import mytunes_project.be.Playlist;
import mytunes_project.dal.PlaylistDAO;

/**
 *
 * @author Mikkel
 */
public class PlaylistManager
{

    private PlaylistDAO playlistDAO = new PlaylistDAO();

    public void save(Playlist p)
    {
        playlistDAO.save(p);
    }

    public List<Playlist> getAllPlaylists()
    {
        return playlistDAO.getAllPlaylists();
    }
}
