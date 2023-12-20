package assignment9;

import edu.princeton.cs.introcs.StdDraw;
import java.util.Random;

public class Food {

    public static final double FOOD_SIZE = 0.02;
    private double x, y;

    public Food() {
        Random random = new Random();
        x = random.nextDouble();
        y = random.nextDouble();
    }

    public void draw() {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(x, y, FOOD_SIZE);
    }

    // Getters for position
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
