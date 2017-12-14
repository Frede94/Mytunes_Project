/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.Track;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mytunes_project.be.Playlist;
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
    private JFXListView<Song> songsOnPlaylistList;
    @FXML
    private TableView<Song> songsList;

    private ObservableList<Song> observableSongsView;
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

    private SongModel songModel = new SongModel();

    private PlaylistModel playlistModel = new PlaylistModel();
    @FXML
    private TableColumn<Song, String> tableColumnTitle;
    @FXML
    private TableColumn<Song, String> tableColumnArtist;
    @FXML
    private TableColumn<Song, String> tableColumnCategory;
    @FXML
    private TableColumn<Song, String> tableColumnTime;
    @FXML
    private JFXButton addSongToPlaylistBtn;

    private MediaPlayer mp;

    private Media me;

    private Song songPlaying;

    private Song selectedSong;

    private Playlist selectedPlaylist;

    @FXML
    private TableView<Playlist> playlistView;
    @FXML
    private TableColumn<Playlist, String> tableColumnPlaylistName;
    @FXML
    private TableColumn<Playlist, String> tableColumnPlaylistSongs;
    @FXML
    private TableColumn<Playlist, String> tableColumnPlaylistTime;

    private MediaPlayer player;
    private Song currentSong;
    private Song prevSong;
    private Song nextSong;
    private Media currentMedia;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        //Initializere Song tableView
        tableColumnTitle.setCellValueFactory(new PropertyValueFactory("Title"));
        tableColumnArtist.setCellValueFactory(new PropertyValueFactory("ArtistName"));
        tableColumnCategory.setCellValueFactory(new PropertyValueFactory("CategoryName"));
        tableColumnTime.setCellValueFactory(new PropertyValueFactory("Time"));

        songsList.setItems(songModel.getSongs());
        songModel.loadSongs();
        volumeSlider.setValue(50);
        clickLoad();

        //Initializere Playlists tableView
        tableColumnPlaylistName.setCellValueFactory(new PropertyValueFactory("PlaylistName"));
        tableColumnPlaylistSongs.setCellValueFactory(new PropertyValueFactory("NumberofSongs"));
        tableColumnPlaylistTime.setCellValueFactory(new PropertyValueFactory("TotalTime"));

        playlistView.setItems(playlistModel.getPlaylists());
        playlistModel.loadPlaylists();

    }

    /*
    starter den musiken når man trykker på knappen
     */
    @FXML
    private void clickedPlayButton(ActionEvent event) throws MalformedURLException
    {
        playSelectedSong();
    }


    /*
    stopper medieafspilleren.
     */
    @FXML
    private void clickStopPlaying(ActionEvent event)
    {

        mp.stop();

    }

    /*
    Vælger sangen man trykker på/ den markerede sang på Song TableView
     */
    @FXML
    private void clickSpecificSong(MouseEvent event) throws MalformedURLException
    {

        selectedSong = songsList.getSelectionModel().getSelectedItem();

    }

    /*
    Vælger PlayListen man trykker på/ den markerede sang på PlayList TableView
     */
    private void clickSpecificPlaylist(MouseEvent event)
    {
        selectedPlaylist = playlistView.getSelectionModel().getSelectedItem();
    }

    /*
    Loader sange fra databasen, når man trykker på knappen
     */
    @FXML
    private void clickLoad()
    {

        songModel.loadSongs();
        playlistModel.loadPlaylists();

    }

    /*
    Søger i tableView
     */
    @FXML
    private void searchAction(ActionEvent event)
    {
        String searchText = filterField.getText().trim();
        if (!searchText.isEmpty())
        {

            songModel.search(searchText);

        } else
        {
            clickLoad();
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            AddWindowController ewc = fxmlLoader.getController();
            ewc.setSongModel(songModel);
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            AddWindowController ewc = fxmlLoader.getController();
            ewc.setSongModel(songModel);
            ewc.setEditSong(songsList.getSelectionModel().getSelectedItem());
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
            NewPlaylistWindowController playlistController = fxmlLoader.getController();
            playlistController.setPlaylistModel(playlistModel);
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
            NewPlaylistWindowController playlistController = fxmlLoader.getController();
            playlistController.setPlaylistModel(playlistModel);
            playlistController.setEditPlaylist(playlistView.getSelectionModel().getSelectedItem());
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

    /*
    lukker programmet
     */
    @FXML
    private void closeApp(ActionEvent event)
    {
        System.exit(0);
    }

    /*
    Når man trykker delete åbner programmet en dialog box som spørger 
    om du er sikker på om du vil slette sangen, hvis man trykker ok
    så sletter den sangen hvis man trykker cancel gør den ingenting.
     */
    @FXML
    private void clickDelete(ActionEvent event)
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("You are about to delete a song ");
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

    }

    /*
    Åbner en Diaglog box som spørger om man er sikker på om at man
    gerne vil slette playlisten.
    Man kan vælger OK, Cancel eller bare lukker dialog boxen.
     */
    @FXML
    private void clickDeletePlaylist(ActionEvent event)
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("You are about to delete a Playlist");
        alert.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            Playlist selectedPlaylist = playlistView.getSelectionModel().getSelectedItem();
            playlistModel.remove(selectedPlaylist);
            // ... user chose OK
        } else
        {
            // ... user chose CANCEL or closed the dialog
        }
    }

    /**
     * changes volume when the slider is dragged.
     *
     * @param event
     */
    @FXML
    private void setNewVolume(MouseEvent event)
    {

        this.volumeSlider.valueProperty().addListener(new InvalidationListener()
        {
            @Override
            public void invalidated(Observable observable)
            {
                if (volumeSlider.isValueChanging())
                {
                    mp.setVolume(volumeSlider.getValue() / 100.0);
                }
            }
        });

    }

    /**
     * Tilføjer en sang til playlisten
     *
     * @param event
     */
    @FXML
    private void addSongToPlaylist(ActionEvent event)
    {

    }

    /**
     * Afspiller den forrige sang
     *
     * @param event
     */
    @FXML
    private void clikedPrevSong(ActionEvent event) throws MalformedURLException
    {
        songsList.getSelectionModel().selectPrevious();
        selectedSong = songsList.getSelectionModel().getSelectedItem();
        playSelectedSong();
    }

    /**
     * Afspiller den næste sang i rækken
     * 
     * @param event
     */
    @FXML
    private void clikedNextsSong(ActionEvent event) throws MalformedURLException
    {
        songsList.getSelectionModel().selectNext();
        selectedSong = songsList.getSelectionModel().getSelectedItem();
        playSelectedSong();
    }

    /*
    Tager den sang som er selected, og gør den klar til brug.
    når en sang er valgt kan man trykke på clickedPlayButton metoden (play/pause knap(
     */
    private void playSelectedSong() throws MalformedURLException
    {
        if (selectedSong.equals(songPlaying))
        {
            if (mp.getStatus() == MediaPlayer.Status.PLAYING)//selectedSong.equals(selectedSong)
            {
                System.out.println("hello det virker!!");
                mp.pause();

            } else
            {
                System.out.println("hello det virker ikke!!");
                mp.play();

            }
        } else
        {
            if (mp != null)
            {
                mp.stop();
            }

            String path = selectedSong.getPath();
            System.out.println(path);

            URL url = Paths.get(path).toAbsolutePath().toUri().toURL();
            Media musicFile = new Media(url.toString());
            mp = new MediaPlayer(musicFile);
            songPlaying = selectedSong;
            mp.setVolume(volumeSlider.getValue() / 100);
            mp.play();

        }
    }

}
