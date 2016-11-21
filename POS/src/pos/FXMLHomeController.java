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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author waltersanchez
 */
public class FXMLHomeController implements Initializable {
    @FXML
    TextField inputName;
    @FXML
    TextField inputQty;
    @FXML
    TextField inputPrice;
    @FXML
    ComboBox<String> category;
     @FXML
    Label labelError;           
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       category.getItems().add("Beers");
       category.getItems().add("Soft Drinks");
       category.getItems().add("Spirits");
       category.getItems().add("Wines");
       
    }   
    
    @FXML
    private void handleAdd(ActionEvent event)
    {
      String name=inputName.getText().trim();
      String qty =inputQty.getText().trim();
      String price=inputPrice.getText().trim();      
      String cat= category.getSelectionModel().getSelectedItem();
      if(!name.isEmpty() && !qty.isEmpty() && !price.isEmpty() && !cat.isEmpty())
      {
          DBOps.saveProduct(name,Integer.parseInt(qty),Integer.parseInt(price), cat);
          System.out.println("Added");
          inputName.clear();
          inputQty.clear();
          inputPrice.clear();
      }else
      {
          labelError.setVisible(true);
      }
      
    }
     @FXML
    private void handleViewProductsBtn(ActionEvent event) throws IOException
    {
            Button btn=(Button)event.getSource();
            Stage stage=(Stage) btn.getScene().getWindow();
            Parent parent =FXMLLoader.load(getClass().getResource("FXMLViewProducts.fxml"));
            Scene scene=new Scene(parent);
            stage.setScene(scene);
      
    }
    
}
