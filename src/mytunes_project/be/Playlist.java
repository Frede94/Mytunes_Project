/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.be;

import java.io.Serializable;

/**
 *
 * @author morte
 */
public class Playlist implements Serializable
{

    private int PlaylistId;
    private String PlaylistName;
    private int NumberofSongs;

//    public Playlist(int PlaylistId, String PlaylistName, int NumberofSongs)
//    {
//        this.PlaylistId = PlaylistId;
//        this.PlaylistName = PlaylistName;
//        this.NumberofSongs = NumberofSongs;
//    }
//
//    public Playlist()
//    {
//        
//    }



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
        return "Playlist{" + "PlaylistId=" + PlaylistId + ", PlaylistName=" + PlaylistName + ", NumberofSongs=" + NumberofSongs + '}';
    }
    
    
}
