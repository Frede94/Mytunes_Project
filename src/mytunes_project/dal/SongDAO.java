/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.dal;

import java.io.IOException;
import mytunes_project.be.Song;

/**
 *
 * @author Mikkel
 */
public class SongDAO
{

    private DataBaseConnector dbConnector;

    public SongDAO() throws IOException
    {
        dbConnector = new DataBaseConnector();
    }
    
}
