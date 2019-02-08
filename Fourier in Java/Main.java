class Main {
    public static void main (String[] args) {
        double T = Double.parseDouble(args[0]);
        Circle a; //test of basic squarewave
        Circle b;
        Circle c;
        Circle d;
        double base_radius = 100;
        a = new Circle(4, Math.PI / 8, 0, null);
        b = new Circle(4 / 3, 3 * Math.PI / 8, 0, a);
        c = new Circle(4 / 5, 5 * Math.PI / 8, 0, b);
        d = new Circle(4 / 7, 7 * Math.PI / 8, 0, c);

        //Standard Drawing section
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-25, 25);
        

        Double time = 0.0;
        while (time < T) {
            d.takestep();
            d.draw();
            System.out.println(d.end[0] + " " + d.end[1]);
            time++;
            StdDraw.show();
            StdDraw.pause(200);
            StdDraw.clear();
        }
    }
}