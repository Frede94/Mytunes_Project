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
 * @author Mikkel
 */
public class SongManager
{

    private static SongDAO songDAO = new SongDAO();

    public static void remove(Song selectedSong)
    {
        songDAO.remove(selectedSong);
    }

    public SongManager()
    {

        songDAO = new SongDAO();

    }

    public List<Song> getAllSongs()
    {

        return songDAO.getAllSongs();

    }

    public void search(String searchText)
    {
        songDAO.search(searchText);
    }

<<<<<<< HEAD
    
=======
    public void remove(Song selectedSong)
    {

//        statement stmt con.createStatement();
//        stmt.execute(" DELETE FROM Song WHERE SongId = " + selectedSong.getSongId())
  
    }
>>>>>>> 88b8a0429712bf9dd76b3547af3dfe5984189abb

}
