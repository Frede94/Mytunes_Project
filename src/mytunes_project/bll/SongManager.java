/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.bll;

import java.util.List;
import mytunes_project.be.Category;
import mytunes_project.be.Song;
import mytunes_project.dal.CategoryDAO;
import mytunes_project.dal.SongDAO;

/**
 *
 * @author Mikkel
 */
public class SongManager
{

    private static SongDAO songDAO = new SongDAO();
    private CategoryDAO categoryDAO;

    /**
     * Removes the selected song.
     * @param selectedSong 
     */
    public static void remove(Song selectedSong)
    {
        songDAO.remove(selectedSong);
    }

    public SongManager()
    {
        categoryDAO = new CategoryDAO();
        songDAO = new SongDAO();

    }
/**
 * 
 * @return a list of all songs in the database.
 */
    public List<Song> getAllSongs()
    {

        return songDAO.getAllSongs();

    }
/**
 * Searches in the songDAO.
 * @param searchText 
 */
    public void search(String searchText)
    {
        songDAO.search(searchText);
    }
/**
 * 
 * @return All Categories from the database.
 */
    public List<Category> getAllCategories()
    {
         return categoryDAO.getAllCategories();
    }

//    public void addCategory()
//    {
//        categoryDAO.addCategory();
//    }

    public void saveSong(Song s)
    {
        songDAO.saveSong(s);
    }

    public void saveEdit(Song editSong)
    {
        songDAO.saveEdit(editSong);
    }

    


}
