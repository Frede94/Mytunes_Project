/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mytunes_project.be.Category;
import mytunes_project.be.Song;

/**
 *
 * @author Frederik Bærbar
 */
public class CategoryDAO
{

    DataBaseConnector dbc = new DataBaseConnector();

    public List<Category> getAllCategories()
    {
        List<Category> categories = new ArrayList();

        try (Connection con = dbc.getConnection())
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Category");
            while (rs.next())
            {
                int Id = rs.getInt("CategoryId");
                String name = rs.getString("CategoryName");
                Category category = new Category(Id, name);
                categories.add(category);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

//    public void addCategory()
//    {
//        try (Connection con = dbc.getConnection())
//        {
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("INSERT INTO Category" + "VALUES ('BOB')");
//
//        } catch (SQLException ex)
//        {
//            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        // create a Statement from the connection
//        // insert the data
//    }

}
