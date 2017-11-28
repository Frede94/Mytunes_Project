/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.bll;

import java.util.List;
import mytunes_project.be.Song;
import mytunes_project.dal.SongDAO;

/**
 *
 * @author Frederik Bærbar
 */
public class BLLManager
{
    private SongDAO = new SongDAO();
    public List<Song> getAllSongs() {
        return songDAO.getAllSongs();
    }
    
    public void remove(Song song)
    {
        songDAO.remove(song);
    }
}
