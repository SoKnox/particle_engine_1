package com.particle_engine_1;

import processing.core.*;
import java.util.ArrayList;
public class Mouse
{
    PApplet p;
    ArrayList<Star> particles;
    float speedFactor;
    float influenceRadius;


    public Mouse(PApplet p, ArrayList<Star> particles, float speedFactor, float influenceRadius)
    {
        this.p = p;
        this.particles = particles;
        this.speedFactor = speedFactor;
        this.influenceRadius= influenceRadius;
    }

    //Extra Credit (20%?)
    public void mousePressed()
    {
        //Pushes stars away from where mouse is clicked
        for (Star s : particles) 
            {
                float distance = PApplet.dist(p.mouseX, p.mouseY, s.position.x, s.position.y);
                if (distance < influenceRadius) 
                    {
                    s.reverse();
                    s.pushAway(p.mouseX, p.mouseY);
                    }
            }
    }


    public void mouseMoved() //Mouse behavior 1 (3.3%)
    {
        //Change particle color based on mouse X position
        for (Star s : particles) 
            {
                s.setColor(PApplet.map(p.mouseX, 0, p.width, 0, 255), PApplet.map(p.mouseY, 0, p.height, 0, 255), 255);
            }
    }

    public void mouseDragged() //Mouse behavior 2 (3.3%)
    {
    //new stars appear when mouse is dragged
    particles.add(new Star(p.mouseX, p.mouseY, p));
    }

    public void mouseReleased() //Mouse behavior 3(3.3%) 
    {
        //When mouse is released,  stars turn yellow until the mouse is moved again
        for (Star s: particles)
        {
            s.setColor(255,255,0);
        }
    }

    public void keyPressed()  
    {
    //r puts stars in random position
    if (p.key == 'r' || p.key == 'R')
    {
        for (Star s : particles) 
        {
             s.setPosition(p.random(p.width), p.random(p.height));
        }
    }

    //Increases speed when up arrow is pressed (10%)
        if (p.keyCode == PApplet.UP) 
            {
                speedFactor += 0.5;
            }

    //Decreases speed when down arrow is pressed
        if (p.keyCode == PApplet.DOWN) 
            {
                speedFactor = PApplet.max(0.5f, speedFactor- 0.5f);
            }   


    }

    //Updates speed factor setter
    public void setSpeedFactor(float speedFactor)
    {
        this.speedFactor= speedFactor;
    }

    //recives the speed factor getter
    public float getSpeedFactor()
    {
        return this.speedFactor;
    }




}
