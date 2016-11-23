/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author waltersanchez
 */
public class FXMLReceiptController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextArea textArea;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Contents from receipt are "+POSMain.getReceipt());
        textArea.setText(POSMain.getReceipt());
    }    
    
}
