/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.gui;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mytunes_project.be.Song;
import mytunes_project.bll.SongManager;

/**
 *
 * @author Jens Karlskov
 */
public class SongModel
{

    private static ObservableList<Song> songs = FXCollections.observableArrayList();

    SongManager songManager = new SongManager();

    static void remove(Song selectedSong)
    {
        songs.remove(selectedSong);
        SongManager.remove(selectedSong);
    }

//    private SongManager songManager2;
//    private final ObservableList<Song> songsInView;
//    public SongModel()
//    {
//        this.songsInView = FXCollections.observableArrayList();
//        songManager = new SongManager();
//        songsInView.addAll(songManager.getAllSongs());
//    }
    public ObservableList<Song> getSongs()
    {
        //return songsInView;
        return songs;
    }

    public void search(String searchText)
    {
        songManager.search(searchText);
    }

    void loadSongs()
    {
        List<Song> loadedSongs = songManager.getAllSongs(); //undgå og throw

        songs.clear();
        songs.addAll(loadedSongs);
    }

    public void createSong(String name)
    {

    }

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

    }
}
