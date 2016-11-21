/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author waltersanchez
 */
public class FXMLViewProductsController implements Initializable {
    private ObservableList<Item> collection=FXCollections.observableArrayList();
    
    ArrayList<Item> data;
    @FXML
    TableView<Item> table;
    
    @FXML
    TableColumn<Item,String> columnName;
    
    @FXML
    TableColumn<Item,Integer> columnQty;
    
    @FXML
    TableColumn<Item,Integer> columnTotal;
    
    @FXML
    GridPane grid;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data=DBOps.getData();
       //collection.addAll();
        table.setItems(collection);
        columnName.setCellValueFactory(celldata->celldata.getValue().nameProperty());
        columnQty.setCellValueFactory(cellData->cellData.getValue().qtyProperty().asObject());
        columnTotal.setCellValueFactory(cellData->cellData.getValue().totalProperty().asObject());
        int btns=0;
        int count = data.size();
        for(int y = 0; y < 7; y++) 
        {
            for(int x = 0; x < 4; x++) {
                if(btns<count)
                {
                    Item i=data.get(btns);
                    addButtons(i.getName(), btns, x, y);
                    btns++;
                }else
                {
                  break;
                }
            }
        }
        
    }    
    
    private void addButtons(String title, int pos, int x, int y)
    {
        Button btn=new Button(title);
        btn.setPrefHeight(27);
        btn.setPrefWidth(89);
        grid.add(btn, x, y);
        btn.setOnAction((ActionEvent event) -> {
            Item i=data.get(pos);
            collection.add(i);
            table.getSelectionModel().select(pos);
        });
       
    
    }
    
    @FXML
    private void handleAddAction(ActionEvent event) throws IOException{
   
            Button btn=(Button)event.getSource();
            Stage stage=(Stage) btn.getScene().getWindow();
            Parent parent =FXMLLoader.load(getClass().getResource("FXMLHome.fxml"));
            Scene scene=new Scene(parent);
            stage.setScene(scene);
        
    }
    @FXML
    private void handleIncrement(ActionEvent event)
    {
        int pos=table.getSelectionModel().getSelectedIndex();
        Item x =table.getSelectionModel().getSelectedItem();
        if(x.getQty()>0){
        int qty=x.getQty()+1;
        x.setQty(qty);
        x.setTotal(x.getQty()*x.getPrice());
        }
        collection.set(pos, x);  
        System.out.println(x.getQty()+" x "+x.getPrice());
       
        
    }
        @FXML
    private void handleDecrement(ActionEvent event)
    {
        int pos=table.getSelectionModel().getSelectedIndex();
        Item x =table.getSelectionModel().getSelectedItem();
        if(x.getQty()>1){
        int qty=x.getQty()-1;
        x.setQty(qty);
        x.setTotal(x.getQty()*x.getPrice());
        }
        collection.set(pos, x);      
         System.out.println(x.getQty()+" x "+x.getPrice());
    }
    @FXML
    private void handleRemove(ActionEvent event)
    {
        int pos=table.getSelectionModel().getSelectedIndex();
         collection.remove(pos);  
         table.getSelectionModel().select(pos);
    }
}
