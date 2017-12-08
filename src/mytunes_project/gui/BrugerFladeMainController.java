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
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.embed.swing.JFXPanel;
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
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
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
//    @FXML
//    private TableView<Playlist> playlistView;

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
    @FXML
    private JFXButton addSongToPlaylistBtn;

    private MediaPlayer mp;

    private Media me;
    @FXML
    private TableView<?> playlistView;
    @FXML
    private TableColumn<Playlist, String> tableColumnPlaylistName;
    @FXML
    private TableColumn<Playlist, String> tableColumnPlaylistSongs;
    @FXML
    private TableColumn<Playlist, String> tableColumnPlaylistTime;
    
  

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //Binding list in model with ListView

        tableColumnTitle.setCellValueFactory(new PropertyValueFactory("Title"));
        tableColumnArtist.setCellValueFactory(new PropertyValueFactory("ArtistName"));
        tableColumnCategory.setCellValueFactory(new PropertyValueFactory("CategoryName"));
        tableColumnTime.setCellValueFactory(new PropertyValueFactory("Time"));

               
        songsList.setItems(songModel.getSongs());
        songModel.loadSongs();
        clickLoad();
        
        tableColumnPlaylistName.setCellValueFactory(new PropertyValueFactory("Name"));
        tableColumnPlaylistSongs.setCellValueFactory(new PropertyValueFactory("Songs"));
        tableColumnPlaylistTime.setCellValueFactory(new PropertyValueFactory("Time"));
        
        
        
      

//        volumeSlider.setValue(mp.getVolume()*100);
//        volumeSlider.valueProperty().addListener(new InvalidationListener()
//        {
//            @Override
//            public void invalidated(Observable observable)
//            {
//                mp.setVolume(volumeSlider.getValue()/100);
//            }
//        });
//        String path = new File("C:\\Users\\Frederik Bærbar\\Desktop\\Musik\\End.mp3").getAbsolutePath();
//        
//        me = new Media(new File(path).toURI().toString());
//        mp = new MediaPlayer(me);
//        mp.setAutoPlay(true);
    }

    /*
    starter den musiken når man trykker på knappen
     */
    @FXML
    private void clickedPlayButton(ActionEvent event)
    {
        new BrugerFladeMainController();
        mp.play();
//       
//        System.out.println("test");

    }

    @FXML
    private void clickSpecificSong(MouseEvent event) throws MalformedURLException
    {
        Song selectedSong = songsList.getSelectionModel().getSelectedItem();
        String path = selectedSong.getPath();
        System.out.println(path);

        URL url = Paths.get(path).toAbsolutePath().toUri().toURL();
        Media musicFile = new Media(url.toString());
        mp = new MediaPlayer(musicFile);
        mp.setVolume(0.9);
    }


    /*
    når du trykker play åbner et filechooser vindue hvor man kan finde den sang
    man vil afspille.
    DENNE METODE SKAL IKKE BRUGES HER, DET ER KUN MIDLERTIDIGT!
     */
    public void start()
    {

        String fileName = null;
        URL url;
        final CountDownLatch latch = new CountDownLatch(1);
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new JFXPanel(); // initializes JavaFX environment
                latch.countDown();
            }
        });
        try
        {
            latch.await();
        } catch (InterruptedException ex)
        {
            Logger.getLogger(BrugerFladeMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "MP3 Files", "mp3");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            fileName = chooser.getSelectedFile().toURI().toString();
        }

        mp = new MediaPlayer(new Media(fileName));
        mp.play();
    }

    /*
    CRASHER NÅR MAN TRYKKER STOP!!
    stopper medieafspilleren.
     */
    @FXML
    private void clickStopPlaying(ActionEvent event)
    {
        mp.pause();
    }


    /*
    Loader sange fra databasen, når man trykker på knappen
     */
    @FXML
    private void clickLoad()
    {
        songModel.loadSongs();
    }

    /*
    Links til Hjælp   
    http://code.makery.ch/blog/javafx-8-tableview-sorting-filtering/
    https://stackoverflow.com/questions/44317837/create-search-textfield-field-to-search-in-a-javafx-tableview
    http://www.swtestacademy.com/database-operations-javafx/
     */
    @FXML
    private void searchAction(ActionEvent event)
    {
        String searchText = filterField.getText().trim();
        if (!searchText.isEmpty())
        {
            System.out.println("hello");
            songModel.search(searchText);
        }

//        String searchText = filterField.getText().trim();
//        if (!searchText.isEmpty())
//        {
//            songModel.search(searchText);
//        }
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

    }

    public void volumeSlider()
    {
      
        
    }
    
    
//    public void volumeSlider()
//    {
//        volumeSlider.valueProperty().addListener(new InvalidationListener()
//        {
//            @Override
//            public void invalidated(Observable observable)
//            {
//                if (volumeSlider.isValueChanging())
//                {
//                    mp.setVolume(volumeSlider.getValue() / 100);
//                }
//            }
//        });
//
//    }
//    

  
/**
 * changes volume when the slider is dragged.
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
                if( volumeSlider.isValueChanging())
                {
                    mp.setVolume(volumeSlider.getValue()/100.0);
                }
            }
        });
//volumeSlider.setValue(50);
    }

    @FXML
    private void addSongToPlaylist(ActionEvent event)
    {   
       
        
        
    }
    
    
    
    
    
}
