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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;

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
    private TableView<?> songsList;
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
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
    }    

    @FXML
    private void searchAction(ActionEvent event)
    {
    }
    
}
