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
import mytunes_project.be.Artist;
import mytunes_project.be.Category;
import mytunes_project.be.Song;
import mytunes_project.dal.CategoryDAO;
import mytunes_project.dal.DataBaseConnector;

/**
 * FXML Controller class
 *
 * @author Frederik Bærbar
 */
public class AddWindowController implements Initializable
{

    @FXML
    private JFXButton btnCancelSong;
    @FXML
    private TextField txtTitel;
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

    private Song editSong;
    @FXML
    private ComboBox<Artist> comboArtist;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

    }

    /*
    Lukker AddSong.Fxml vinduet
     */
    @FXML
    private void closeAddSongBox(ActionEvent event)
    {
        Stage stage = (Stage) btnCancelSong.getScene().getWindow();
        stage.close();
    }

    /*
    Loader categorierne i vores combobox
     */
    @FXML
    private void clickLoadCatsAction(ActionEvent event)
    {
        songModel.loadCategories();
    }

    /*
    sætter SongModel i denne klasse, og henter kategorier
     */
    public void setSongModel(SongModel songModel)
    {
        this.songModel = songModel;
        comboCategory.setItems(songModel.getCategories());
        comboArtist.setItems(songModel.getArtists());
    }

    /*
    Lukker vinduet
     */
    private void closeSongWindow(ActionEvent event)
    {
        Stage stage = (Stage) btnCancelSong.getScene().getWindow();
        stage.close();
    }

    /*
   
    tager teksten fra som man skriver i input diaglog og uploader det til Databasen,
     så det kommer frem i comboBoxen
     */
    @FXML
    private void clickMoreAction(ActionEvent event)
    {
        Category c = new Category();
        songModel.clickMore(c);
    }

    /**
     * This opens a FIleChooser window that will allow you to add either a .mp3
     * or a .wav file. It will also display the path of the file in a textbox.
     *
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
            Logger.getLogger(AddWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    
    Når man trykker save gemme den de tastede data ind i databasen
    link til hjælp: https://stackoverflow.com/questions/5752307/how-to-retrieve-value-from-jtextfield-in-java-swing
     */
    @FXML
    private void clickSaveAction(ActionEvent event)
    {
        if (editSong == null)
        {
            Song s = new Song();
            s.setTime(Integer.parseInt(txtTime.getText()));
            s.setTitle(txtTitel.getText());
            s.setCategory(comboCategory.getSelectionModel().getSelectedItem());
            s.setArtist(comboArtist.getSelectionModel().getSelectedItem());
            s.setPath(txtFile.getText());
            songModel.saveSong(s);
        } else
        {
            editSong.setTime(Integer.parseInt(txtTime.getText()));
            editSong.setTitle(txtTitel.getText());
            editSong.setCategory(comboCategory.getSelectionModel().getSelectedItem());
            editSong.setArtist(comboArtist.getSelectionModel().getSelectedItem());
            editSong.setPath(txtFile.getText());
            songModel.saveEdit(editSong);
        }
        Stage stage = (Stage) btnCancelSong.getScene().getWindow();
        stage.close();

    }

    /*
    tager teksten fra den valgte sang og sætter det ind i tekstfelterne
     */
    public void setEditSong(Song selectedItem)
    {
        editSong = selectedItem;
        txtTitel.setText(editSong.getTitle());

        //editSong.setTime(Float.parseFloat(txtTime.getText()));
        txtFile.setText(editSong.getPath());
    }

    @FXML
    private void clickAddAction(ActionEvent event)
    {
        Artist d = new Artist();
             
        songModel.clickAdd(d);
    }

        
}
