/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author waltersanchez
 */
public class Lesson01 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        final TextField tf1=new TextField();
        final TextField tf2=new TextField();
        final Label lbl=new Label();               
        btn.setText("Calculate'");
        btn.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                String x = tf1.getText();
                String y = tf2.getText();
                if(!x.isEmpty() && !y.isEmpty() )
                {
                    double xx = Double.parseDouble(x);
                    double yy = Double.parseDouble(y);
                    String result = String.valueOf(xx+yy);
                    lbl.setText(result);
                }
            }
        });        
        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.setSpacing(5);
        root.getChildren().add(tf1);
        root.getChildren().add(tf2);
        root.getChildren().add(lbl);
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
