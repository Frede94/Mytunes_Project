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
import mytunes_project.be.Category;

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
                Category category = new Category(Id, name);//Id, name
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
    public void clickMore(Category c)
    {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Add Category");
        dialog.setHeaderText("Click Load Categories when done");
        dialog.setContentText("Please enter the category of your choice");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent())
        {
            

            try (Connection con = dbc.getConnection())
            {
                Statement stmt = con.createStatement();
                String sql = "INSERT INTO Category (CategoryName) VALUES (?)";
                PreparedStatement st = con.prepareStatement(sql, stmt.RETURN_GENERATED_KEYS);
                st.setString(1, result.get());
                st.executeUpdate();
                ResultSet rs = st.getGeneratedKeys();

                rs.next();
                System.out.println(rs.getString(1));

                
            } catch (SQLException ex)
            {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Your name: " + result.get());
        }

        // The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(name -> System.out.println("Your name: " + name));
    }

}
