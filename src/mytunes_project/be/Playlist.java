/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.be;

import java.io.Serializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author morte
 */
public class Playlist implements Serializable
{

    private int PlaylistId;
    private String PlaylistName;
    private int NumberofSongs;
    private float TotalTime;
    private ObservableList<Song> songList = FXCollections.observableArrayList();

    public ObservableList<Song> getSongList()
    {
        return songList;
    }

    public float getTotalTime()
    {
        return TotalTime;
    }

    public void setTotalTime(float TotalTime)
    {
        this.TotalTime = TotalTime;
    }

    public int getNumberofSongs()
    {
        return NumberofSongs;
    }

    public void setNumberofSongs(int NumberofSongs)
    {
        this.NumberofSongs = NumberofSongs;
    }

    public int getPlaylistId()
    {
        return PlaylistId;
    }

    public void setPlaylistId(int PlaylistId)
    {
        this.PlaylistId = PlaylistId;
    }

    public String getPlaylistName()
    {
        return PlaylistName;
    }

    public void setPlaylistName(String PlaylistName)
    {
        this.PlaylistName = PlaylistName;
    }

    @Override
    public String toString()
    {
        return "Playlist{" + "PlaylistId=" + PlaylistId + ", PlaylistName=" + PlaylistName + ", NumberofSongs=" + NumberofSongs + ", TotalTime=" + TotalTime + '}';
    }

}
