/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.gui;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mytunes_project.be.Artist;
import mytunes_project.be.Category;
import mytunes_project.be.Song;
import mytunes_project.bll.SearchFilter;
import mytunes_project.bll.SongManager;
import mytunes_project.dal.SongDAO;

/**
 *
 * @author Jens Karlskov
 */
public class SongModel
{

    private ObservableList<Song> songsInSearch;

    private SearchFilter searchFilter = new SearchFilter();

    private SongDAO songDao = new SongDAO(); // FY FY skal flyttes

    private ObservableList<Category> categories;
    public ObservableList<Artist> artists;
    private static ObservableList<Song> songs = FXCollections.observableArrayList();

    SongManager songManager = new SongManager();

    public SongModel()
    {
        songsInSearch = FXCollections.observableArrayList();
        this.categories = FXCollections.observableArrayList();
        categories.addAll(songManager.getAllCategories());

        this.artists = FXCollections.observableArrayList();
        artists.addAll(songManager.getAllArtists());
        loadSongs();
    }

    /**
     * Removes the selected song from the list.
     *
     * @param selectedSong
     */
    static void remove(Song selectedSong)
    {
        songs.remove(selectedSong);
        SongManager.remove(selectedSong);
    }

    public ObservableList<Song> getSongs()
    {
        //return songsInView;
        return songs;
    }

    /**
     * Clears the list, and loads the songs from the database. "getAllSongs".
     */
    void loadSongs()
    {
        List<Song> loadedSongs = songManager.getAllSongs(); //undgå og throw

        songs.clear();
        songs.addAll(loadedSongs);
    }

    public void createSong(String name)
    {

    }

    ObservableList<Category> getCategories()
    {
        return categories;
    }

    ObservableList<Artist> getArtists()
    {

        return artists;
    }

    void loadCategories()
    {
        List<Category> loadedCategories = songManager.getAllCategories(); //undgå og throw

        categories.clear();
        categories.addAll(loadedCategories);
    }

    void loadArtists()
    {
        List<Artist> loadedArtists = songManager.getAllArtists();

        artists.clear();
        artists.addAll(loadedArtists);
    }

    /*
    Gemmer sange i databasen.
     */
    void saveSong(Song s)
    {
        songs.add(s);
        songManager.saveSong(s);
    }

    /*
    updatere sange som allerede er i databasen så de kan få nye oplysninger.
     */
    void saveEdit(Song editSong)
    {
        songs.add(editSong);
        songManager.saveEdit(editSong);
    }

    /*
    tager teksten fra som man skriver i input diaglog og uploader det til Databasen,
     så det kommer frem i comboBoxen
     */
    void clickMore(Category c)
    {
        categories.add(c);
        songManager.clickMore(c);
    }

    void clickAdd(Artist d)
    {
        artists.add(d);
        songManager.clickAdd(d);
    }

    /*
    Søger på det der er skrevet i søgefeltet
    skal flyttes til dal laget
     */
    void search(String searchText)
    {
        List<Song> allSongs = songDao.getAllSongs();
        List<Song> searchResults = searchFilter.searchBySongName(allSongs, searchText);
        songsInSearch.addAll(searchResults);
        songsInSearch.clear();

    }

}

//    private SongManager songManager2;
//    private final ObservableList<Song> songsInView;
//    public SongModel()
//    {
//        this.songsInView = FXCollections.observableArrayList();
//        songManager = new SongManager();
//        songsInView.addAll(songManager.getAllSongs());
//    }
//    private ObservableList<Song> songsInSearch;
//    private SongDAO songDao;
//    private SearchFilter searchFilter;
//
//    public SongModel() throws IOException
//    {
//        try
//        {
//            searchFilter = new SearchFilter();
//            songsInSearch = FXCollections.observableArrayList();
//            songDao = new SongDAO();
//            songsInSearch.addAll(songDao.getAllSongs());
//        } catch (SQLException ex)
//        {
//            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    /**
//     * Gets the observable list of all the companies in view. The list responds
//     * to changes made by the search method.
//     *
//     * @return The list of companies.
//     */
//    public ObservableList<Song> getSongList()
//    {
//        return songsInSearch;
//    }
//
//    public void search(String searchText)
//    {
//        try
//        {
//            List<Song> allSongs = songDao.getAllSongs();
//            List<Song> searchResults = searchFilter.searchBySongName(allSongs, searchText);
//            songsInSearch.clear();
//            songsInSearch.addAll(searchResults);
//        } catch (SQLException ex)
//        {
//            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
