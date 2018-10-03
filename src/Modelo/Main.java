/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Estudiante
 */
public class Main extends Application{
    public void start(Stage stage) throws Exception {
        //Layout
       Pane panel = new Pane();
       Canvas canvas = 
               new Canvas(1024,512);
       panel.getChildren().add(canvas);
       Scene scene = 
               new Scene(panel,1024,512,Color.DARKSEAGREEN);
       //Referencia del lapiz para dibujar
       GraphicsContext gc = 
               canvas.getGraphicsContext2D();
       
       LoopJuego loop = new LoopJuego(gc);
       loop.start();
       
       stage.setTitle("Carro");
       stage.setScene(scene);
       stage.show();
       
       
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
