/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.bll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import mytunes_project.be.Song;
import mytunes_project.dal.SongDAO;

/**
 *
 * @author Mikkel
 */
public class SongManager
{

    private SongDAO songDAO;

    public SongManager() throws Exception
    {
        try
        {
            songDAO = new SongDAO();
        } catch (IOException ex)
        {
            throw new Exception(ex);
        }
    }

    public List<Song> getAllSongs() throws Exception
    {
        try
        {
            return songDAO.getAllSongs();
        } catch (SQLException ex)
        {
            throw new Exception(ex);
        }
    }

    public void search(String searchText)
    {
        songDAO.search(searchText);
    }

   
}
