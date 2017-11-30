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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private ComboBox<?> comboCategory;
    @FXML
    private TextField txtTime;
    @FXML
    private TextField txtFile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO

    }

    @FXML
    private void closeAddSongBox(ActionEvent event)
    {
        Stage stage = (Stage)btnCancelSong.getScene().getWindow();
        stage.close();
    }


       

    private void closeSongWindow(ActionEvent event)
    {
    Stage stage = (Stage) btnCancelSong.getScene().getWindow();
    stage.close();
    }

    @FXML
    private void btnChooseFile(ActionEvent event)
    {
    }
   

}
