/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author waltersanchez
 */
public class POSMain extends Application {
    static Stage mainStage;
    static String data="";
    @Override
    public void start(Stage stage) throws Exception {
        this.mainStage=stage;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));        
        Scene scene = new Scene(root);        
        mainStage.setScene(scene);
        mainStage.show();
    }
    
    public static void setReceipt(String text) {
        data=text;
    }
    
    public static String getReceipt()
    {
     return data;
    }
    
    
    public static Stage getMainStage() {
        return mainStage;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
