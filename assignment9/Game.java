package assignment9;

import edu.princeton.cs.introcs.StdDraw;
import java.awt.event.KeyEvent;

public class Game {

    private Snake snake;
    private Food food;

    public Game() {
        StdDraw.enableDoubleBuffering();
        snake = new Snake();
        food = new Food();
        score = 0;  // Initialize score
    }


    public void play() {
        while (snake.isInbounds()) { //in boundaries
            int dir = getKeypress();
            snake.changeDirection(dir); //follow keys
            snake.move();
            if (snake.eatFood(food)) {
                food = new Food();  // Create new food if eaten
                score += 10;  // Increase score
            }
            updateDrawing();
            StdDraw.pause(20);  
        }
        // Display game over screen and score if snake isn't in bounds
        System.out.println("Game Over! Your score: " + score);
    }

    private int getKeypress() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_W)) {
            return 1; // Up
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
            return 2; // Down
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
            return 3; // Left
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
            return 4; // Right
        } else {
            return -1; // No key pressed
        }
    }


    private void updateDrawing() {
        StdDraw.clear();
        snake.draw();
        food.draw();

        // Display the score
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(0.1, 0.95, "Score: " + score);  // Positioning the score at the top left

        StdDraw.show();
        StdDraw.pause(50);  // Pause for a short time
    }


    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
    
    private int score;

}
