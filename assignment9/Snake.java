package assignment9;

import java.util.LinkedList;

public class Snake {

    private static final double SEGMENT_SIZE = 0.02;
    private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
    private LinkedList<BodySegment> segments;
    private double deltaX;
    private double deltaY;

    public Snake() {
        segments = new LinkedList<>();
        segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE));  // Start in middle of the screen
        deltaX = 0;
        deltaY = 0;
    }

    public void changeDirection(int direction) {
        if (direction == 1) { // Up
            deltaY = MOVEMENT_SIZE;
            deltaX = 0;
        } else if (direction == 2) { // Down
            deltaY = -MOVEMENT_SIZE;
            deltaX = 0;
        } else if (direction == 3) { // Left
            deltaX = -MOVEMENT_SIZE;
            deltaY = 0;
        } else if (direction == 4) { // Right
            deltaX = MOVEMENT_SIZE;
            deltaY = 0;
        }
    }


    public void move() {
        // Create a new position for the head
        double newHeadX = segments.getFirst().getX() + deltaX;
        double newHeadY = segments.getFirst().getY() + deltaY;

        // Move the body
        for (int i = segments.size() - 1; i > 0; i--) { //goes through each segment , sanke's head --> each segment takes the position of the last one.
            BodySegment current = segments.get(i);
            BodySegment previous = segments.get(i - 1);
            current.setPosition(previous.getX(), previous.getY());
        }

        // Update the head's position last
        segments.getFirst().setPosition(newHeadX, newHeadY);
    }


    public void draw() {
        for (BodySegment segment : segments) {
            segment.draw();
        }
    }

    public boolean eatFood(Food f) {
        BodySegment head = segments.getFirst();
        if (Math.hypot(head.getX() - f.getX(), head.getY() - f.getY()) < SEGMENT_SIZE + Food.FOOD_SIZE) {
            // Note the position of the last segment before adding a new one
            BodySegment tail = segments.getLast();
            double tailX = tail.getX();
            double tailY = tail.getY();

            // Add a new segment at the position of the tail
            segments.add(new BodySegment(tailX, tailY, SEGMENT_SIZE));

            return true;
        }
        return false;
    }




    public boolean isInbounds() {
        BodySegment head = segments.getFirst();
        return head.getX() >= 0 && head.getX() <= 1 && head.getY() >= 0 && head.getY() <= 1;
    }}


   
