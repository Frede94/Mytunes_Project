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
public class Artists
{
    
    private int ArtistId;

    private String ArtistName;

    public Artists(int ArtistId, String ArtistName)
    {
        this.ArtistId = ArtistId;
        this.ArtistName = ArtistName;
    }
    
    /**
     * Get the value of ArtistName
     *
     * @return the value of ArtistName
     */
    public String getArtistName()
    {
        return ArtistName;
    }

    /**
     * Set the value of ArtistName
     *
     * @param ArtistName new value of ArtistName
     */
    public void setArtistName(String ArtistName)
    {
        this.ArtistName = ArtistName;
    }

    /**
     * Get the value of ArtistId
     *
     * @return the value of ArtistId
     */
    public int getArtistId()
    {
        return ArtistId;
    }

    /**
     * Set the value of ArtistId
     *
     * @param ArtistId new value of ArtistId
     */
    public void setArtistId(int ArtistId)
    {
        this.ArtistId = ArtistId;
    }

    @Override
    public String toString()
    {
        return "Artists{" + "ArtistId=" + ArtistId + ", ArtistName=" + ArtistName + '}';
    }
    

}
