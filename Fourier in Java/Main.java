class Main {
    public static void main (String[] args) {
        Circle a; //test of basic squarewave
        Circle b;
        Circle c;
        Circle d;
        a = new Circle(4, Math.PI / 8, 0, null);
        b = new Circle(4 / 3, 3 * Math.PI / 8, 0, a);
        c = new Circle(4 / 5, 5 * Math.PI / 8, 0, b);
        d = new Circle(4 / 7, 7 * Math.PI / 8, 0, c); 
        for (int x = 0; x <= 20; x++) {
            d.takestep();
            System.out.println(d.end);
        }
    }
}