/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.gui;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
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
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
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
    @FXML
    private JFXButton btnSaveSong;

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

    /*
    Detter skal flyttes ned i DAL laget.
    tager teksten fra som man skriver i input diaglog og uploader det til Databasen,
     så det kommer frem i comboBoxen
     */
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
    
    /**
     * This opens a FIleChooser window that will allow you to add
     * either a .mp3 or a .wav file.
     * @param event 
     */
    @FXML
    private void clickChooseFile(ActionEvent event)
    {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        chooser.getExtensionFilters().addAll(new ExtensionFilter("Audio Files", "*.mp3", "*.wav"));
        File file = chooser.showOpenDialog(new Stage());
        try
        {
            String fullPath = file.getCanonicalPath();
            txtFile.setText(fullPath);
        } catch (IOException ex)
        {
            Logger.getLogger(EditWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    SKAL FLYTTES NED I DAL!
    Kan ikke teste hjemme fra forset i skolen.
    Når man trykker save gemme den de tastede data ind i databasen
    link til hjælp: https://stackoverflow.com/questions/5752307/how-to-retrieve-value-from-jtextfield-in-java-swing
     */
    @FXML
    private void clickSaveAction(ActionEvent event)
    {
        try (Connection con = dbc.getConnection())
        {

            Statement stmt = con.createStatement();
            String sql = "INSERT INTO Song (Title, Artist, Category, Time, Path) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);     //, stmt.RETURN_GENERATED_KEYS 

            st.setString(1, txtTitel.getText());
            st.setString(2, txtArtist.getText());
            st.setInt(3, 1);
            st.setString(4, txtTime.getText());
            st.setString(5, txtFile.getText());

            st.execute();

//            ResultSet rs = st.getGeneratedKeys();
//
//            rs.next();
//            System.out.println(rs.getString(1));

            //comboCategory.setItems(SongModel.getCategories());
            // ResultSet rs = stmt.executeQuery1
        } catch (SQLException ex)
        {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

//        try (Connection con = dbc.getConnection())
//        {
//            Statement stmt = con.createStatement();
//            String sql = "INSERT INTO Song (Artist) VALUES (?)";
//            PreparedStatement st = con.prepareStatement(sql, stmt.RETURN_GENERATED_KEYS);
//            st.setString(1, txtArtist.getText());
//            st.executeUpdate();
//            ResultSet rs = st.getGeneratedKeys();
//
//            rs.next();
//            System.out.println(rs.getString(1));
//
//            //comboCategory.setItems(SongModel.getCategories());
//            // ResultSet rs = stmt.executeQuery1
//        } catch (SQLException ex)
//        {
//            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try (Connection con = dbc.getConnection())
//        {
//            Statement stmt = con.createStatement();
//            String sql = "INSERT INTO Song (Path) VALUES (?)";
//            PreparedStatement st = con.prepareStatement(sql, stmt.RETURN_GENERATED_KEYS);
//            st.setString(1, txtFile.getText());
//            st.executeUpdate();
//            ResultSet rs = st.getGeneratedKeys();
//
//            rs.next();
//            System.out.println(rs.getString(1));
//
//            //comboCategory.setItems(SongModel.getCategories());
//            // ResultSet rs = stmt.executeQuery1
//        } catch (SQLException ex)
//        {
//            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try (Connection con = dbc.getConnection())
//        {
//            Statement stmt = con.createStatement();
//            String sql = "INSERT INTO Song (Time) VALUES (?)";
//            PreparedStatement st = con.prepareStatement(sql, stmt.RETURN_GENERATED_KEYS);
//            st.setString(1, txtTime.getText());
//            st.executeUpdate();
//            ResultSet rs = st.getGeneratedKeys();
//
//            rs.next();
//            System.out.println(rs.getString(1));
//
//            //comboCategory.setItems(SongModel.getCategories());
//            // ResultSet rs = stmt.executeQuery1
//        } catch (SQLException ex)
//        {
//            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println(txtArtist.getText());
//        System.out.println(txtFile.getText());
//        System.out.println(txtTime.getText());
//        System.out.println(txtTitel.getText());
    }

}
