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
    private Artist artist;
    private Category category;
    private float time;
    private String path;
    private int songId;


    /**
     * Get the value of path
     *
     * @return the value of path
     */
    public String getPath()
    {
        return path;
    }

    public String getCategoryName()
    {
        return category.getCatergoryName();
    }

    public String getArtistName()
    {
        return artist.getArtistName();
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

    public Artist getArtist()
    {
        return artist;
    }

    public void setArtist(Artist artist)
    {
        this.artist = artist;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
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
