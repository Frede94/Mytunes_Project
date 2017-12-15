/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.bll;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mytunes_project.be.Artist;
import mytunes_project.be.Category;
import mytunes_project.be.Song;
import mytunes_project.dal.ArtistDAO;
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
    private ArtistDAO artistDAO;
    private static ObservableList<Song> songs = FXCollections.observableArrayList();
    private SearchFilter searchFilter = new SearchFilter();

    /**
     * Removes the selected song.
     *
     * @param selectedSong
     */
    public static void remove(Song selectedSong)
    {
        songDAO.remove(selectedSong);
    }

    public static void removePSong(Song selectedPSong)
    {
        songDAO.removePSong(selectedPSong);
    }

    /*
    Kalder Vores BLL Songmanager Klasse
     */
    public SongManager()
    {
        categoryDAO = new CategoryDAO();
        songDAO = new SongDAO();
        artistDAO = new ArtistDAO();

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
     *
     * @return All Categories from the database.
     */
    public List<Category> getAllCategories()
    {
        return categoryDAO.getAllCategories();
    }

    /**
     *
     * @return All Artists from the database.
     */
    public List<Artist> getAllArtists()
    {
        return artistDAO.getAllArtists();
    }

    /*
    gemmer sangen man taster i databasen.
     */
    public void saveSong(Song s)
    {
        songDAO.saveSong(s);
    }

    /*
    updatere sange som allerede er i databasen så de kan få nye oplysninger.
     */
    public void saveEdit(Song editSong)
    {
        songDAO.saveEdit(editSong);
    }

    /*
    tager teksten fra som man skriver i input diaglog og uploader det til Databasen,
    så det kommer frem i comboBoxen
     */
    public void clickMore(Category c)
    {
        categoryDAO.clickMore(c);
    }

    /*
    tager teksten fra som man skriver i input diaglog og uploader det til Databasen,
    så det kommer frem i comboBoxen
     */
    public void clickAdd(Artist d)
    {
        artistDAO.clickAdd(d);
    }

}
