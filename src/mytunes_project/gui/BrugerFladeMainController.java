/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mytunes_project.be.Song;

/**
 *
 * @author Frederik Bærbar
 */
public class BrugerFladeMainController implements Initializable
{

    @FXML
    private Label label;
    @FXML
    private JFXListView<?> songsOnPlaylistList;
    @FXML
    private TableView<Song> songsList;
    @FXML
    private JFXButton newPlaylistBtn;
    @FXML
    private JFXButton editPlaylistBtn;
    @FXML
    private JFXButton deletePlaylistBtn;
    @FXML
    private JFXButton deleteSongPlaylistBtn;
    @FXML
    private JFXButton addSongBtn;
    @FXML
    private JFXButton editSongsBtn;
    @FXML
    private JFXButton deleteSongBtn;
    @FXML
    private JFXButton closeBtn;
    @FXML
    private JFXTextField filterField;
    @FXML
    private JFXButton searchBtn;
    @FXML
    private JFXButton btnUp;
    @FXML
    private JFXButton btnDown;
    @FXML
    private JFXButton prevSongBtn;
    @FXML
    private JFXButton playPauseBtn;
    @FXML
    private JFXButton nextSongBtn;
    @FXML
    private Slider volumeSlider;
    @FXML
    private TableView<?> playlistView;

    private SongModel songModel = new SongModel();

    //private SongModel songModel = new SongModel();
    @FXML
    private TableColumn<Song, String> tableColumnTitle;
    @FXML
    private TableColumn<Song, String> tableColumnArtist;
    @FXML
    private TableColumn<Song, String> tableColumnCategory;
    @FXML
    private TableColumn<Song, String> tableColumnTime;
<<<<<<< HEAD
    @FXML
    private JFXButton addSongToPlaylistBtn;
=======

    @FXML
    private JFXButton addSongToPlaylistBtn;
   

>>>>>>> bd4f2d74298ce92f2a75147b0dc3f97578fee526

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //Binding list in model with ListView
        //songsList.setItems(songModel.getSongs());
        tableColumnTitle.setCellValueFactory(new PropertyValueFactory("Title"));
        tableColumnArtist.setCellValueFactory(new PropertyValueFactory("Artist"));
        tableColumnCategory.setCellValueFactory(new PropertyValueFactory("Category"));
        tableColumnTime.setCellValueFactory(new PropertyValueFactory("Time"));
//        tableColumnSongId.setCellValueFactory(new PropertyValueFactory("SongId"));
//        tableColumnPath.setCellValueFactory(new PropertyValueFactory("Path"));

        songsList.setItems(songModel.getSongs());

        clickLoad();
    }

    @FXML
    private void clickLoad()
    {
        songModel.loadSongs();
    }

    @FXML
    private void searchAction(ActionEvent event)
    {
        String searchText = filterField.getText().trim();
        if (!searchText.isEmpty())
        {
            songModel.search(searchText);
        }
    }


    /*
    opens new window when you press the add btn
     */
    @FXML
    private void addSongAction(ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Edit/add Songs");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    /*
    opens new window when you press the Edit btn
     */
    @FXML
    private void editSongAction(ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Edit/add Songs");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /*
    opens new window when you press the New playlist btn
     */
    @FXML
    private void newPlaylistOnAction(ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewPlaylistWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("New Playlist");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * opens a new window when you press the edit playlist btn
     *
     * @param event
     */
    @FXML
    private void editPlaylistOnAction(ActionEvent event)
    {

        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewPlaylistWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Edit Playlist");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
<<<<<<< HEAD
    private void closeApp(ActionEvent event)
    {
        System.exit(0);
=======
    private void clickDelete(ActionEvent event)
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            Song selectedSong = songsList.getSelectionModel().getSelectedItem();

            songModel.remove(selectedSong);
            // ... user chose OK
        } else
        {
            // ... user chose CANCEL or closed the dialog
        }
//        Song selectedSong = songsList.getSelectionModel().getSelectedItem();
//
//        songModel.remove(selectedSong);
>>>>>>> 401e5fd7a8a3457389032f8a76cdb8b690bf4c98
    }

}
