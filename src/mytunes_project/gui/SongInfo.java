/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.gui;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mytunes_project.be.Song;


/**
 *
 * @author morte
 */
public class SongInfo
{
    
<<<<<<< HEAD
//    private ObservableList<Song> songs
//            = FXCollections.observableArrayList();
//    private SongManager songManager = new SongManager();
//    
//    public ObservableList<Song> getSongs() 
//    {
//        return songs;
//    }
//    
//    public void loadSongs()
//    {
//        List<Song> loadedSongs = songManager.getAllSongs();
//        
//        songs.clear();
//        songs.addAll(loadedSongs);
//    }
//    
//    public void remove(Song selectedSong)
//    {
//        songs.remove(selectedSong);
//        songManager.remove(selectedSong);
//    }
=======
    private ObservableList<Song> songs
            = FXCollections.observableArrayList();

    
    public ObservableList<Song> getSongs() 
    {
        return songs;
    }
    
    public void loadSongs()
    {
        List<Song> loadedSongs = bllManager.getAllSongs();
        
        songs.clear();
        songs.addAll(loadedSongs);
    }
    
    public void remove(Song selectedSong)
    {
        songs.remove(selectedSong);
        bllManager.remove(selectedSong);
    }
>>>>>>> 27b3422361d9f00c64da7571491e586b53ccf752
}
