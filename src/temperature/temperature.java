/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperature;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author LapCity
 */

public class temperature extends Application {
     RadioButton ra;
    RadioButton ra1;
    Label res;
     TextField text;
    @Override
    public void start(Stage primaryStage) {
       Label la= new Label("Enter celsius temperature :");
        res=new Label("New The temperature");
       la.setAlignment(Pos.CENTER);
        ToggleGroup tag= new ToggleGroup();
       text= new TextField();
        text.setMinWidth(260);
       la.setPadding(new Insets(20));
       text.setAlignment(Pos.CENTER_LEFT);
         ra=new RadioButton();
         ra.setText("Fahrenheit ");
         re r=new re();
         ra.addEventFilter(MouseEvent.MOUSE_CLICKED, r);
          ra1=new RadioButton();
           ra1.addEventFilter(MouseEvent.MOUSE_CLICKED, r);
          ra1.setText("Kelvin");
       ra.setToggleGroup(tag);
        ra1.setToggleGroup(tag);
        HBox b= new HBox(20,ra,ra1);
        b.setAlignment(Pos.CENTER);
        VBox vb=new VBox(10,la,text,b, res);
        vb.setAlignment(Pos.CENTER);
         AnchorPane an= new  AnchorPane(vb);
        Scene scene = new Scene(an,260,300);
        primaryStage.setTitle(" Temperature converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
      private class re implements EventHandler<Event>{

        @Override
        public void handle(Event event) {
        double c=0 ;
         c= Double.parseDouble(text.getText());
            if(event.getSource() == ra){
                    res.setText(("New The temperature: " +((c* 9/5) + 32)));
           
        }else if(event.getSource()==ra1){
                    res.setText( "New The temperature: " + (c+ 273.15));

        }
        
    }
    
}
}