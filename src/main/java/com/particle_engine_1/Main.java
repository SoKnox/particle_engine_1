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
        System.out.println("");
    }

    public void settings()
    {
        size (800,600); //screen bigger than default
    }

    ArrayList<Star> particles;
    int numParticles = 500; //Has 500 particles (10%)
    float speedFactor = 1;  //Variable for controlling speed via keyboard
    float influenceRadius = 200;  //Increased radius around the mouse click to reverse particle direction

    public void setup() 
    {
        //ArrayList (15%)
        particles = new ArrayList<Star>(); //Particle class with data and behavior (15%)

        //500 particles (10%)
        for (int i = 0; i < numParticles; i++) 
            {
                particles.add(new Star(random(width), random(height), this));
            }
    }

    public void draw() 
    {
        background(0); //background 0

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
        //Pushes stars away from where mouse is clicked
        for (Star p : particles) 
            {
                float distance = dist(mouseX, mouseY, p.position.x, p.position.y);
                if (distance < influenceRadius) 
                    {
                    p.reverse();
                    p.pushAway(mouseX, mouseY);
                    }
            }
    }


    public void mouseMoved() //Mouse behavior 1 (3.3%)
    {
        //Change particle color based on mouse X position
        for (Star p : particles) 
            {
                p.setColor(map(mouseX, 0, width, 0, 255), map(mouseY, 0, height, 0, 255), 255);
            }
    }

    public void mouseDragged() //Mouse behavior 2 (3.3%)
    {
    //new stars appear when mouse is dragged
    particles.add(new Star(mouseX, mouseY, this));
    }

    public void mouseReleased() //Mouse behavior 3(3.3%) 
    {
        //When mouse is released,  stars turn yellow until the mouse is moved again
        for (Star p: particles)
        {
            p.setColor(255,255,0);
        }
    }

    public void keyPressed()  
    {
    //r puts stars in random position
    if (key == 'r' || key == 'R')
    {
        for (Star p : particles) 
        {
        p.setPosition(random(width), random(height));
        }
    }

    //Increases speed when up arrow is pressed (10%)
        if (keyCode == UP) 
            {
                speedFactor += 0.5;
            }

    //Decreases speed when down arrow is pressed
        if (keyCode == DOWN) 
            {
                speedFactor = max(0.5f, speedFactor- 0.5f);
            }   


    }
}