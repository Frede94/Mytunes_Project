/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.be;

import java.io.Serializable;

/**
 *
 * @author Frederik Bærbar
 */
public class Song implements Serializable
{
    private String title;
    private String artist;
    private String category;
    private float time;
    private String path;
    private int songId;

    

//    /**
//     * Constructs a new Song object
//     * 
//     * @param SongId
//     * @param title
//     * @param artistId
//     * @param categoryId
//     * @param time
//     * @param path
//     */
//    public Song(int SongId, String title, String artistId, String categoryId, float time, String path)
//    {
//        this.SongId = SongId;
//        this.title = title;
//        this.artistId = artistId;
//        this.categoryId = categoryId;
//        this.time = time;
//        this.path = path;
//    }
    /**
     * Get the value of path
     *
     * @return the value of path
     */
    public String getPath()
    {
        return path;
    }

    /**
     * Set the value of path
     *
     * @param path new value of path
     */
    public void setPath(String path)
    {
        this.path = path;
    }

    /**
     * Get the value of time
     *
     * @return the value of time
     */
    public float getTime()
    {
        return time;
    }

    /**
     * Set the value of time
     *
     * @param time new value of time
     */
    public void setTime(float time)
    {
        this.time = time;
    }

    /**
     * Get the value of category
     *
     * @return the value of category
     */
    public String getCategory()
    {
        return category;
    }

    /**
     * Set the value of category
     *
     * @param category new value of category
     */
    public void setCategory(String category)
    {
        this.category = category;
    }

    /**
     * Get the value of artist
     *
     * @return the value of artist
     */
    public String getArtist()
    {
        return artist;
    }

    /**
     * Set the value of artist
     *
     * @param artist new value of artist
     */
    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    /**
     * Get the value of title
     *
     * @return the value of title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Set the value of title
     *
     * @param title new value of title
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Get the value of songId
     *
     * @return the value of songId
     */
    public int getSongId()
    {
        return songId;
    }

    /**
     * Set the value of songId
     *
     * @param songId new value of songId
     */
    public void setSongId(int songId)
    {
        this.songId = songId;
    }

    @Override
    public String toString()
    {
        return "Song{" + "title=" + title + ", artist=" + artist + ", category=" + category + ", time=" + time + ", path=" + path + ", songId=" + songId + '}';
    }

}
