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

/**
 * FXML Controller class
 *
 * @author Jens Karlskov
 */
public class EditWindowController implements Initializable
{

    @FXML
    private TextField txtTitle;
    @FXML
    private TextField txtTime;
    @FXML
    private TextField txtFile;
    @FXML
    private ComboBox<?> comboCategory;
    @FXML
    private JFXButton btnCancelEdit;
    @FXML
    private JFXButton btnSaveEdit;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void clickMoreEditAction(ActionEvent event)
    {
    }

    @FXML
    private void clickLoadCategoriesEditAction(ActionEvent event)
    {
    }

    @FXML
    private void clickCancelEditAction(ActionEvent event)
    {
    }

    @FXML
    private void clickSaveEditAction(ActionEvent event)
    {
    }

    @FXML
    private void clickChooseFileEdit(ActionEvent event)
    {
    }

  
    
}
