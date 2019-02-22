/*

Fourier Circle Simulator in Java
by @akristoffersen 2019

*/
public class Circle {

    public double radius;
    public double speed;
    public double angle;
    public Circle parent;
    public double[] center = new double[2];
    public double[] end = new double[2];


    public Circle(double rad, double sp, double ang, Circle par) {
        radius = rad;
        speed = sp;
        angle = ang;
        parent = par;
        if (par == null) {
            center[0] = 0.0; //center x
            center[1] = 0.0; //center y
        }
        else {
            center[0] = parent.end[0];
            center[1] = parent.end[1];
        }
        end[0] = Math.cos(angle) * radius + center[0]; // end x
        end[1] = Math.sin(angle) * radius + center[1]; // end y
        }

    public void takestep() {
        angle = angle + speed; // adds to the angle
        if (parent instanceof Circle) { //if there is a parent
            parent.takestep(); // do the takestep for the parent, then modify the center of the current circle
            center[0] = parent.end[0]; // to be the modified end of the parent circle
            center[1] = parent.end[1];
        }
        end[0] = Math.cos(angle) * radius + center[0]; //sets the circle's ends to reflect the change
        end[1] = Math.sin(angle) * radius + center[1]; //in angle and center, if any
    }

    public void draw() {
        //drawing circle
        
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenRadius();
        StdDraw.circle(center[0], center[1], radius);

        //drawing line from center to end.
        StdDraw.setPenRadius(0.0017);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(center[0], center[1], end[0], end[1]);

        //drawing ends/points and recursive call.
        StdDraw.setPenRadius(0.017);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(end[0],end[1]);

        if (this.parent == null) {
            StdDraw.point(center[0], center[1]);
        } else {
            this.parent.draw();
        }
    }

    public void draw_line() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.0017);
        StdDraw.line(this.end[0], this.end[1], 5000, this.end[1]);
    }

    //Demos

    public static Circle sawTooth(double rad, double speed, int rez) {
        Circle a = new Circle(rad / rez, speed * rez, 0, null);
        if (rez > 1) {
            a.parent = squareWave(rad, speed, rez - 1);
        }
        return a;
    }

    public static Circle squareWave(double rad, double speed, int rez) {
        Circle a = null;
        int multi = 1;
        for (int i = 0; i < rez; i++) {
            a = new Circle(rad / multi, speed * multi, 0, a);
            multi += 2;
        }
        return a;
    }
}