/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.gui;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mytunes_project.be.Playlist;
import mytunes_project.be.Song;
import mytunes_project.bll.PlaylistManager;

/**
 *
 * @author Mikkel
 */
public class PlaylistModel
{

    PlaylistManager playlistManager = new PlaylistManager();
    private ObservableList<Playlist> playlists = FXCollections.observableArrayList();
    private ObservableList<Song> songsList = FXCollections.observableArrayList();

    void savePlaylist(Playlist p)
    {
        playlists.add(p);
        playlistManager.save(p);
    }

    void loadPlaylists()
    {
        List<Playlist> loadedPlaylists = playlistManager.getAllPlaylists();

        playlists.clear();
        playlists.addAll(loadedPlaylists);

    }

    public ObservableList<Playlist> getPlaylists()
    {
        return playlists;
    }

    void remove(Playlist selectedPlaylist)
    {
        playlists.remove(selectedPlaylist);
        playlistManager.remove(selectedPlaylist);
    }

    void saveEdit(Playlist editPlaylist)
    {
        playlists.add(editPlaylist);
        playlistManager.saveEdit(editPlaylist);
    }

    void addSong(Song selectedSong, Playlist selctedPlaylist)
    {
        playlistManager.addSong(selectedSong, selctedPlaylist);
    }

    public ObservableList<Song> getSongList()
    {
        return songsList;
    }

    public void setSongsByRelation(int plId)
    {
        List<Song> songs = playlistManager.getSongsByRelation(plId);
        if (songs != null){
            songsList.setAll(songs);
        }
    }

}
