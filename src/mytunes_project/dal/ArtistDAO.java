/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextInputDialog;
import mytunes_project.be.Artist;
import mytunes_project.be.Category;

/**
 *
 * @author morte
 */
public class ArtistDAO
{
    DataBaseConnector dbc = new DataBaseConnector();

    public List<Artist> getAllArtists()
    {
        List<Artist> artists = new ArrayList();

        try (Connection con = dbc.getConnection())
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Artist");
            while (rs.next())
            {
                int Id = rs.getInt("ArtistId");
                String name = rs.getString("ArtistName");
                Artist artist = new Artist(Id, name);//Id, name
                artists.add(artist);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return artists;
    }
    
    
    
    
     public void clickAdd(Artist d)
    {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Add Artist");
        dialog.setHeaderText("Click Load Artists when done");
        dialog.setContentText("Please enter the artist of your choice");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent())
        {
            

            try (Connection con = dbc.getConnection())
            {
                Statement stmt = con.createStatement();
                String sql = "INSERT INTO Artist (ArtistName) VALUES (?)";
                PreparedStatement st = con.prepareStatement(sql, stmt.RETURN_GENERATED_KEYS);
                st.setString(1, result.get());
                st.executeUpdate();
                ResultSet rs = st.getGeneratedKeys();

                rs.next();
                System.out.println(rs.getString(1));

                
            } catch (SQLException ex)
            {
                Logger.getLogger(ArtistDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Your name: " + result.get());
        }

        // The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(name -> System.out.println("Your name: " + name));
    }

   

}
