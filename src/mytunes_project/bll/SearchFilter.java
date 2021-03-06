/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.bll;

import java.util.ArrayList;
import java.util.List;
import mytunes_project.be.Song;

/**
 *
 * @author Jens Karlskov
 */
public class SearchFilter
{
    /*
    Søger efter specifikke elementer i vores Lister/Database
    */
    public List<Song> searchBySongName(List<Song> songs, String query)
    {
        List<Song> searResult = new ArrayList<Song>();

        for (Song song : songs)
        {
            if (song.getTitle().toLowerCase().contains(query.toLowerCase()))
            {
                searResult.add(song);
            } else if (song.getArtistName().toLowerCase().contains(query.toLowerCase()))
            {
                searResult.add(song);
            } else if (song.getCategoryName().toLowerCase().contains(query.toLowerCase()))
            {
                searResult.add(song);
            }
        }

        return searResult;
    }
}
