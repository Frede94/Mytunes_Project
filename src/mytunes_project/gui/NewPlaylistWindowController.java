/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes_project.gui;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void closePlaylistBox(ActionEvent event)
    {
    Stage stage = (Stage) btnCancelPlaylist.getScene().getWindow();
    stage.close();
    }
    
}
