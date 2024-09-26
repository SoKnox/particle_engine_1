package com.particle_engine_1;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class Particle {
    PApplet main;
    PVector position, velocity;
    int c;

    Particle(float x, float y, PApplet main_) {
        this.main = main_;
        this.position = new PVector(x, y);
        this.velocity = PVector.random2D();
        this.velocity.mult(main.random(1, 3));
        this.c = main.color(255);
    }

    // Common behavior: movement and bouncing
    public void update(float speedFactor) {
        position.add(PVector.mult(velocity, speedFactor));
        if (position.x < 0 || position.x > main.width) {
            velocity.x *= -1;
        }
        if (position.y < 0 || position.y > main.height) {
            velocity.y *= -1;
        }
    }

    // Abstract method for drawing different shapes
    public abstract void display();

    public void reverse() {
        velocity.mult(-1);
    }

    public void pushAway(float mouseX, float mouseY) {
        PVector direction = PVector.sub(position, new PVector(mouseX, mouseY));
        direction.normalize();
        velocity.add(direction.mult(10));
    }

    public void setColor(float r, float g, float b) {
        c = main.color(r, g, b);
    }

    public void setPosition(float x, float y) {
        position.set(x, y);
    }

    // Abstract methods for mouse/key interactions
    public abstract void mouseClicked();
    public abstract void keyPressed();
}
