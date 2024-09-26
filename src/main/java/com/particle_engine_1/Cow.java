package com.particle_engine_1;

import processing.core.PApplet;

public class Cow {
    PApplet p; // A reference to the main PApplet class

    // Constructor that accepts a PApplet reference
    public Cow(PApplet p) {
        this.p = p;
    }

    // Method to display the cow
    public void display() {
        // Cow legs
        p.fill(255);
        p.rect(450, 475, 10, 30);
        p.rect(415, 475, 10, 30);

        // Cow body
        p.fill(255);
        p.rect(415, 450, 50, 30);

        // Spots
        p.fill(0);
        p.ellipse(430, 458, 15, 10);
        p.ellipse(450, 470, 20, 15);
        p.ellipse(455, 455, 8, 5);

        // Ears
        p.fill(0);
        p.ellipse(430, 440, 17, 8);
        p.ellipse(400, 440, 17, 8);

        // Cow head
        p.fill(255);
        p.ellipse(415, 450, 25, 35);

        // Eyes
        p.fill(0);
        p.ellipse(410, 445, 5, 5);
        p.ellipse(420, 445, 5, 5);

        // Snout
        p.fill(219, 112, 143);
        p.ellipse(415, 460, 17, 11);

        // Nostrils
        p.fill(129, 15, 35);
        p.ellipse(410, 460, 5, 5);
        p.ellipse(420, 460, 5, 5);
    }
}
