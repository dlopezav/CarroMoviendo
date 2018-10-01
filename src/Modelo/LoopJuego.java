/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Estudiante
 */
public class LoopJuego extends AnimationTimer{
    private GraphicsContext gc;//Vista
    private Carro carro;//Modelo
    
    public LoopJuego(GraphicsContext gc){
        this.gc = gc;
        this.carro= new Carro(0,200);
        this.carro.getLlantas()[0]=new Llanta(0,240);
        this.carro.getLlantas()[1]=new Llanta(60,240);
    }

    @Override
    public void handle(long l) {
        gc.clearRect(0, 0, 500, 500);
        //Dibujando el escenario
        gc.fillRect(this.carro.getX(), this.carro.getY(), 80, 40);
        gc.fillOval(this.carro.getLlantas()[0].getX(), this.carro.getLlantas()[0].getY(), 20, 20);
        gc.fillOval(this.carro.getLlantas()[1].getX(), this.carro.getLlantas()[1].getY(), 20, 20);
        this.carro.mover();
        
    }
    
}
