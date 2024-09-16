/*
 * Sophie Knox
 * Particle Engine 1
 * 9/16/24
 * This code creates a particle engine of 500 stars. When mouse is dragged stars generate behind the mouse positionn
 * stars turn yellow when clicked, when mouse moves the star's color change and up/down arrow control speed
 * This class creates star object, stores color/speed, and makes sure the particles stay within the creen.
 */


package com.particle_engine_1;

import processing.core.*;

public class Star {
    PApplet main; //the main class - provides all the functionality of processing
    PVector position;
    PVector velocity;
    int c; //holds color

Star (float x, float y, PApplet main_)
{
    position = new PVector(x, y);
    velocity = PVector.random2D();
    velocity.mult(main_.random(1,3)); 
    c = main_.color(255); // sets defaultl color to white 
    main = main_;
}

  //Updates position + bouncing
  void update(float speedFactor) 
  {
    position.add(PVector.mult(velocity, speedFactor));
    // Bounce at screen edge (10%)
    if (position.x < 0 || position.x > main.width) 
        {
        velocity.x *= -1;
        }
    if (position.y < 0 || position.y > main.height) 
        {
        velocity.y *= -1;
        }
  }

  //Creates star shape
  void display() 
  {
    main.fill(c);
    main.noStroke();
    
    // Create a star shape at the particle's position
    float x = position.x;
    float y = position.y;
    
    //didnt know how to make star shape without using basic shapes lol
    main.triangle(x - 10, y, x + 10, y, x, y - 20);
    main.triangle(x, y - 10, x, y + 10, x + 20, y);
    main.triangle(x + 10, y, x - 10, y, x, y + 20);
    main.triangle(x, y + 10, x, y - 10, x - 20, y);
  }

  //Reverses the direction
  void reverse()
   {
    velocity.mult(-1);
   }


  //pushes stars away from where mouse is clicked
  void pushAway(float mouseX, float mouseY)
  {
    PVector direction= PVector.sub(position, new PVector(mouseX,mouseY));
    direction.normalize();
    velocity.add(direction.mult(10));
  }


  //Assigns the star's color
  void setColor(float r, float g, float b) 
  {
    c = main.color(r, g, b);
  }

  // Sets the stars position
  void setPosition(float x, float y) 
  {
    position.set(x, y);
  }

}
