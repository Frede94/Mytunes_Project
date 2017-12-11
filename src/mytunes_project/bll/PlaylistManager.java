/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.bll;

import mytunes_project.be.Playlist;
import mytunes_project.dal.PlaylistDAO;

/**
 *
 * @author Mikkel
 */
public class PlaylistManager
{
    
    private PlaylistDAO playlistDAO;

    public void clickMore(Playlist p)
    {
        playlistDAO.clickMore(p);
    }
    
}
