/*
 * Sophie Knox
 * Particle Engine 1
 * 9/16/24
 * This code creates a particle engine of 500 stars. When mouse is dragged stars generate behind the mouse positionn
 * stars turn yellow when clicked, when mouse moves the star's color change and up/down arrow control speed
 * This class creates star object, stores color/speed, and makes sure the particles stay within the creen.
 */


 package com.particle_engine_1;

 import processing.core.PApplet;
 
 public class Star extends Particle {
 
   Star(float x, float y, PApplet main_) {
       super(x, y, main_);
   }
 
   @Override
   public void display() {
       main.fill(c);
       main.noStroke();
       main.triangle(position.x - 10, position.y, position.x + 10, position.y, position.x, position.y - 20);
       main.triangle(position.x, position.y - 10, position.x, position.y + 10, position.x + 20, position.y);
   }
 
   @Override
   public void mouseClicked() {
       setColor(main.random(255), main.random(255), main.random(255)); // Change to a random color on click
   }
 
   @Override
   public void keyPressed() {
       velocity.mult(1.1f);  // Increase speed on key press
   }
 }
 