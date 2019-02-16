import java.awt.Color;
public class Main {
    public static void main (String[] args) {
        //makinfg the graph
        ArrayDeque<Double> yvalues = new ArrayDeque<>(200);
        Grapher grapher = new Grapher(StdDraw.BLACK, 50, 5000);

        double T = Double.parseDouble(args[0]);
        Circle a; //test of basic squarewave
        Circle b;
        Circle c;
        Circle d;
        Circle e;
        Circle f;
        double base_radius = 1400;
        double base_speed = Math.PI / 64;
        
        //demos:
        a = new Circle(base_radius, Math.PI / 64, 0, null);
        b = new Circle(base_radius / 3, 3 * base_speed, 0, a);
        c = new Circle(base_radius / 5, 5 * base_speed, 0, b);
        d = new Circle(base_radius / 7, 7 * base_speed, 0, c);
        e = new Circle(base_radius / 9, 9 * base_speed, 0, d);
        f = new Circle(base_radius / 9, 11 * base_speed, 0, e);
        
        /*
        a = new Circle(base_radius, base_speed, 0, null);
        b = new Circle(base_radius / 2, -2 * base_speed, 0, a);
        c = new Circle(base_radius / 3, 3 * base_speed, 0, b);
        d = new Circle(base_radius / 4, -4 * base_speed, 0, c);
        f = d;
        */

        //Standard Drawing section
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(1400, 700);
        StdDraw.setXscale(-3000 , 11000);
        StdDraw.setYscale(-3500, 3500);
        

        Double time = 0.0;
        while (time < T) {
            if (yvalues.size() >= 199) {
                yvalues.removeLast();
            }
            yvalues.addFirst(f.end[1]);
            grapher.graph(yvalues, yvalues.size() - 1);
            f.takestep();
            f.draw();
            f.draw_line();
            //System.out.println(f.end[0] + " " + f.end[1]);
            time++;
            StdDraw.show();
            StdDraw.pause(20);
            StdDraw.clear();
        }
    }
}