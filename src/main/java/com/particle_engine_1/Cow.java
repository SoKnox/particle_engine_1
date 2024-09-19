package com.particle_engine_1;

public class Cow
 {

    void display ()
    {//cow legs
fill (255);
rect (450,475, 10,30);
rect (415,475, 10,30);

//cowbody
fill (255);
rect (415, 450, 50,30);

//spots
fill(0);
ellipse(430, 458, 15, 10);
ellipse(450, 470, 20, 15);
ellipse(455, 455, 8, 5);


//ears 
fill(0);
ellipse(430, 440, 17, 8);
ellipse(400, 440, 17, 8);

//cow head
fill (255);
ellipse(415, 450, 25, 35);

//eyes
fill (0);
ellipse(410, 445, 5, 5);
ellipse(420, 445, 5, 5);

//snoute
fill (219,112,143);
ellipse(415, 460, 17, 11);

//nostroiles 
fill (129, 15, 35);
ellipse(410, 460, 5, 5);
ellipse(420, 460, 5, 5);

}
}
