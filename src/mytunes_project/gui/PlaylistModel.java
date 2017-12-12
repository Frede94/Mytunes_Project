/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mytunes_project.be.Playlist;
import mytunes_project.bll.PlaylistManager;

/**
 *
 * @author Mikkel
 */
public class PlaylistModel
{
    PlaylistManager playlistManager = new PlaylistManager();
    private ObservableList<Playlist> playlists = FXCollections.observableArrayList();
    

    void savePlaylist(Playlist p)
    {
        playlists.add(p);
        playlistManager.save(p);
    }
    
}
