/*
 * Sophie Knox
 * Particle Engine 1
 * 9/16/24
 * This code creates a particle engine of 500 stars. When mouse is dragged stars generate behind the mouse positionn
 * stars turn yellow when clicked, when mouse moves the star's color change and up/down arrow control speed
 * This class controls all the mouse and keyboard funtions and setsup the dispay.
 */



package com.particle_engine_1;

import processing.core.*;
import java.util.ArrayList;

public class Main extends PApplet 
{
    public static void main(String[] args) 
    {
        
        PApplet.main("com.particle_engine_1.Main");
    
    }

    public void settings()
    {
        size (800,600); //screen bigger than default
    }

    ArrayList<Star> particles;
    int numParticles = 500; //Has 500 particles (10%)
    float speedFactor = 1;  //Variable for controlling speed via keyboard
    float influenceRadius = 200;  //radius around the mouse click to reverse particle direction
    Mouse mouse;

    public void setup() 
    {
        //ArrayList (15%)
        particles = new ArrayList<Star>(); //Particle class with data and behavior (15%)

        //500 particles (10%)
        for (int i = 0; i < numParticles; i++) 
            {
                particles.add(new Star(random(width), random(height), this));
            }


        //Initalize Mouse
        mouse = new Mouse(this, particles,speedFactor,influenceRadius);
    }

    public void draw() 
    {
        background(0); 

        //Updates the display all particles
        for (Star p : particles) 
            {
                p.update(speedFactor);
                p.display();
            }
    }
  

    //Extra Credit (20%?)
    public void mousePressed()
    {
        mouse.mousePressed();
    }


    public void mouseMoved() //Mouse behavior 1 (3.3%)
    {
        //Change particle color based on mouse X position
        mouse.mouseMoved();
    }

    public void mouseDragged() //Mouse behavior 2 (3.3%)
    {
    //new stars appear when mouse is dragged
        mouse.mouseDragged();
    }

    public void mouseReleased() //Mouse behavior 3(3.3%) 
    {
        //When mouse is released,  stars turn yellow until the mouse is moved again
        mouse.mouseReleased();
    }

    public void keyPressed()  
    {
    //r puts stars in random position,up speeds, down slows
    mouse.keyPressed();
    speedFactor = mouse.getSpeedFactor();//updates speedFactor

    }
}