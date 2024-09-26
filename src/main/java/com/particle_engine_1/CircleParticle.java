package com.particle_engine_1;

import processing.core.PApplet;
import processing.core.PVector;

public class CircleParticle extends Particle {

    CircleParticle(float x, float y, PApplet main_) {
        super(x, y, main_);
    }

    @Override
    public void display() {
        main.fill(c);
        main.noStroke();
        main.ellipse(position.x, position.y, 20, 20);
    }

    @Override
    public void mouseClicked() {
        setPosition(main.random(main.width), main.random(main.height)); // Teleport on click
    }

    @Override
    public void keyPressed() {
        velocity.mult(0.9f);  // Slow down on key press
    }

    // Collision detection
    public boolean isColliding(CircleParticle other) {
        float dist = PVector.dist(this.position, other.position);
        return dist < 20;  // Simple radius-based collision
    }

    public void handleCollision(CircleParticle other) {
        if (isColliding(other)) {
            this.reverse();
            other.reverse();
        }
    }
}
