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

    private SearchFilter searchFilter = new SearchFilter();

    private SongDAO songDao = new SongDAO(); // FY FY skal flyttes

    private ObservableList<Category> categories;
    public ObservableList<Artist> artists;
    private static ObservableList<Song> songs = FXCollections.observableArrayList();
    private ObservableList<Song> songsList = FXCollections.observableArrayList();

    SongManager songManager = new SongManager();

    /*
    constructor til songmodel klassen
     */
    public SongModel()
    {

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

    /*
    Retunere kategorier
     */
    ObservableList<Category> getCategories()
    {
        return categories;
    }

    /*
    Retunere Kunstnere
     */
    ObservableList<Artist> getArtists()
    {
        return artists;
    }

    /*
    indlæser kategorier
     */
    void loadCategories()
    {
        List<Category> loadedCategories = songManager.getAllCategories(); //undgå og throw

        categories.clear();
        categories.addAll(loadedCategories);
    }

    /*
    indlæser Kunstnere
     */
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

    /*
    tager teksten fra som man skriver i input diaglog og uploader det til Databasen,
     så det kommer frem i comboBoxen
     */
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
        songs.clear();
        songs.addAll(searchResults);

    }

    /*
    fjerner den valgte sang fra playlisten
     */
    void removePSong(Song selectedPSong)
    {
        songsList.remove(selectedPSong);
        SongManager.removePSong(selectedPSong);
    }

}
