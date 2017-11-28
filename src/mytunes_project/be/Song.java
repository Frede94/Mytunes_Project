/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.be;

/**
 *
 * @author Frederik Bærbar
 */
public class Song
{

    //hej
    private int ID;
    private String title;
    private String artistId;
    private String categoryId;
    private float time;
    private String path;

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
     * Get the value of categoryId
     *
     * @return the value of categoryId
     */
    public String getCategoryId()
    {
        return categoryId;
    }

    /**
     * Set the value of categoryId
     *
     * @param categoryId new value of categoryId
     */
    public void setCategoryId(String categoryId)
    {
        this.categoryId = categoryId;
    }

    /**
     * Get the value of artistId
     *
     * @return the value of artistId
     */
    public String getArtistId()
    {
        return artistId;
    }

    /**
     * Set the value of artistId
     *
     * @param artistId new value of artistId
     */
    public void setArtistId(String artistId)
    {
        this.artistId = artistId;
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
     * Get the value of ID
     *
     * @return the value of ID
     */
    public int getID()
    {
        return ID;
    }

    /**
     * Set the value of ID
     *
     * @param ID new value of ID
     */
    public void setID(int ID)
    {
        this.ID = ID;
    }

    @Override
    public String toString()
    {
        return "Songs{" + "ID=" + ID + ", title=" + title + ", artistId=" + artistId + ", categoryId=" + categoryId + ", time=" + time + ", path=" + path + '}';
    }

}
