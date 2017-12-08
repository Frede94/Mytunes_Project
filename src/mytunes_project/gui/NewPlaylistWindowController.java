/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.gui;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mytunes_project.be.Playlist;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class NewPlaylistWindowController implements Initializable
{

    @FXML
    private TextField playlistName;
    @FXML
    private JFXButton btnCancelPlaylist;
    @FXML
    private JFXButton btnSavePlaylist;
    @FXML
    private TableView<Playlist> playlistView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
     
    }    

    
    
    @FXML
    private void closePlaylistBox(ActionEvent event)
    {
    Stage stage = (Stage) btnCancelPlaylist.getScene().getWindow();
    stage.close();
    }

    @FXML
    private void buttonSavePlaylist(ActionEvent event)
    {
        ListView<String> list = new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList("Name", "Song", "Time"); 
        //List.(items);
        System.out.println("test");
    }
    
}
