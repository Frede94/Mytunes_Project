/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.gui;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author morte
 */
public class SongInfo
{
    
    private ObservableList<Song> songs
            = FXCollections.observableArrayList();
    private BLLManager bllManager = new BLLManager();
    
    public ObservableList<Song> getSongs() 
    {
        return songs;
    }
    
    public void loadSongs()
    {
        List<Song> loadedSongs = bllManager.getAllCars();
        
        songs.clear();
        songs.addAll(loadedSongs);
    }
    
    public void remove(Song selectedSong)
    {
        songs.remove(selectedSong);
        bllManager.remove(selectedSong);
    }
}
