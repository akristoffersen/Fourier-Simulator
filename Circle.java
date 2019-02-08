/*

Fourier Circle Simulator in Java
by @akristoffersen 2019

*/

import java.util.*;

public class Circle {

    public double radius;
    public double speed;
    public double angle;
    public Circle parent;
    public ArrayList<Double> center = new ArrayList<Double>();
    public ArrayList<Double> end = new ArrayList<Double>();


    public Circle(double rad, double sp, double ang, Circle par) {
        radius = rad;
        speed = sp;
        angle = ang;
        parent = par;
        if (par == null) {
            center.add(0.0); //center x
            center.add(0.0); //center y
        }
        else {
            center.add(parent.end.get(0));
            center.add(parent.end.get(1));
        }
        end.add(Math.cos(angle) * radius + center.get(0)); // end x
        end.add(Math.sin(angle) * radius + center.get(1)); // end y
        }

    public void takestep() {
        angle = angle + speed; // adds to the angle
        if (parent instanceof Circle) { //if there is a parent
            parent.takestep(); // do the takestep for the parent, then modify the center of the current circle
            center.set(0, parent.end.get(0)); // to be the modified end of the parent circle
            center.set(1, parent.end.get(1));
        }
        /*
        else {
            System.out.println("end of the line."); //to see if we really get to the top parent (1st circle)
        }
        */
        end.set(0, Math.cos(angle) * radius + center.get(0)); //sets the circle's ends to reflect the change
        end.set(1, Math.sin(angle) * radius + center.get(1)); //in angle and center, if any
    }
}