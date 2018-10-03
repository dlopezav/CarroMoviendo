/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Graphics;
import javafx.scene.image.Image;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;

/**
 *
 * @author Estudiante
 */
public class LoopJuego extends AnimationTimer{
    private GraphicsContext gc;//Vista
    private Carro carro;//Modelo
    private Image fondo;
    private Image personaje;
    private Image personaje2;
    private int x=0;
    private int y=0;
    
    public LoopJuego(GraphicsContext gc){
        this.gc = gc;
        this.carro= new Carro(0,400);
        this.fondo= new Image("images/fondo.png");
        this.personaje= new Image("images/cats.gif");
        this.personaje2= new Image("images/down0.png");
        };

    @Override
    public void handle(long l) {
        //borrando escenario
        gc.clearRect(0, 0, 1024, 512);
        //Dibujando el escenario
        gc.drawImage(fondo, 0, 0);
        gc.fillRect(this.carro.getX(), this.carro.getY(), 40, 20);
        gc.fillOval(this.carro.getLlantas()[0].getX(), this.carro.getLlantas()[0].getY()+20, 10, 10);
        gc.fillOval(this.carro.getLlantas()[1].getX()+30, this.carro.getLlantas()[1].getY()+20, 10, 10);
        this.carro.mover();
        gc.drawImage(personaje2,400,30);
        gc.strokeRect(400, 30, 30, 39);
        gc.setStroke(Color.RED);
        gc.drawImage(personaje,132*x,0,132,80,20+y,200,132,80);
        gc.strokeRect(20+y, 200, 132, 80);
        
        //Colision
        Shape sRectangulo =
                new Rectangle(20+y,200,132,80);
        Shape sObstaculo =
                new Rectangle(400,30,30,39);
        Shape interseccion = SVGPath.intersect(sRectangulo, sObstaculo);
        if(interseccion.getBoundsInLocal().getWidth()!=-1){
            stop();
        }
        
        
        if(y%10==0){
            x++;
            y++;
        }else{
            y++;
        }
        if(x==5){
            x=0;
        }
        

    }
    
}
