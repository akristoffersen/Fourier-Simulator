import java.awt.Color;
public class Grapher {
    //color is self explanatory, dx is the x distance between each point.
    public Color color;
    double dx;
    int shown;
    double starting_x;

    public Grapher(Color c, double x, double sx) {
        color = c;
        dx = x;
        starting_x = sx;
    }

    public void graph(ArrayDeque<Double> arr, int shown) {
        StdDraw.setPenRadius(0.0017);
        StdDraw.setPenColor(color);
        double x = starting_x;
        for (int i = 0; i < shown; i++) {
            StdDraw.line(x, arr.get(i), x + dx, arr.get(i + 1));
            x += dx;
        }
    }
}