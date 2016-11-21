/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 *
 * @author waltersanchez
 */
public class FXMLLoginController implements Initializable {
    @FXML
    Label labelError;
    @FXML
    private Label label;
    @FXML
    TextField inputUsername;
    @FXML
    PasswordField inputPassword;
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        String username=inputUsername.getText().trim();
        String password=inputPassword.getText().trim();
        if(DBOps.login(username, password))
        {
            Button btn=(Button)event.getSource();
            Stage stage=(Stage) btn.getScene().getWindow();
            Parent parent =FXMLLoader.load(getClass().getResource("FXMLViewProducts.fxml"));
            Scene scene=new Scene(parent);
            stage.setScene(scene);
        }
        else
        {
           labelError.setVisible(true);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
