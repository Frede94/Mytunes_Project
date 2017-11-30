/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.gui;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import mytunes_project.be.Category;
import mytunes_project.dal.CategoryDAO;
import mytunes_project.dal.DataBaseConnector;

/**
 * FXML Controller class
 *
 * @author Frederik Bærbar
 */
public class EditWindowController implements Initializable
{

    @FXML
    private JFXButton btnCancelSong;
    @FXML
    private TextField txtTitel;
    @FXML
    private TextField txtArtist;
    @FXML
    private ComboBox<Category> comboCategory;
    @FXML
    private TextField txtTime;
    @FXML
    private TextField txtFile;

    private SongModel songModel;
   
    DataBaseConnector dbc = new DataBaseConnector();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

    }

    @FXML
    private void closeAddSongBox(ActionEvent event)
    {
        Stage stage = (Stage) btnCancelSong.getScene().getWindow();
        stage.close();
    }

    public void setSongModel(SongModel songModel)
    {
        this.songModel = songModel;
        comboCategory.setItems(songModel.getCategories());
    }

    private void closeSongWindow(ActionEvent event)
    {
        Stage stage = (Stage) btnCancelSong.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void clickMoreAction(ActionEvent event)
    {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Add Category");
        dialog.setHeaderText("Look, a Text Input Dialog");
        dialog.setContentText("Please enter your name:");

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
            
            
            //comboCategory.setItems(SongModel.getCategories());
            
           // ResultSet rs = stmt.executeQuery1

        } catch (SQLException ex)
        {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("Your name: " + result.get());
        }

        // The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(name -> System.out.println("Your name: " + name));
    }

    @FXML
    private void clickChooseFile(ActionEvent event)
    {

    }

    @FXML
    private void clickSaveAction(ActionEvent event)
    {

    }

}
