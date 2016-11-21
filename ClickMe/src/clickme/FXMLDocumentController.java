/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickme;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author waltersanchez
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TableView<Person> table;
    @FXML
    private TableColumn<Person,String> columnNames;
    @FXML
    private TableColumn<Person,String>  columnEmail;
    @FXML
    private TableColumn<Person,String>  columnAge;
    @FXML
    private TableColumn<Person,String>  columnCity;
    
    @FXML
    private TextField inputEmail;
       
    @FXML
    private TextField inputAge;
       
    @FXML
    private TextField inputNames;
    
    @FXML
    private TextField inputCity;
      
    private ObservableList<Person> data =FXCollections.observableArrayList();
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        //label.setText("Hello World!");
        String names= inputNames.getText().trim();
        String email= inputEmail.getText().trim();
        String age= inputAge.getText().trim();
        String city= inputCity.getText().trim();
        if(!names.isEmpty() && !email.isEmpty() && !age.isEmpty() && !city.isEmpty())
        {
          data.add(new Person(names, email,age,city));
          DBOps.save(names, email, age, city);
          inputNames.setText("");
          inputEmail.setText("");
          inputAge.setText("");
          inputCity.setText("");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        columnAge.setCellValueFactory(cellData->cellData.getValue().ageProperty());
        columnEmail.setCellValueFactory(cellData->cellData.getValue().emailProperty());
        columnNames.setCellValueFactory(cellData->cellData.getValue().namesProperty());
        columnCity.setCellValueFactory(cellData->cellData.getValue().cityProperty());
        
        /*data.add(new Person("John Mark","mark@yahoo.com","Bangok","23"));
        data.add(new Person("Hellen Mwangi","hellen@yahoo.com","Nairobi","76"));
        data.add(new Person("Geofrey Omolo","omolo@yahoo.com","Mombasa","34"));
        data.add(new Person("Mary Atieno","atieno@yahoo.com","Nyeri","55"));*/
        
        ArrayList<Person> all= DBOps.getData();
        
        for (Person p : all) {
            data.add(p);
        }
        
        // TODO
        
        table.setItems(data);
    }    
    
}
