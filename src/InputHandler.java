import java.util.Scanner;

/**
 * A Inputhandler handles the keyboard input:
 * For the Player movement:
 * - W for UP
 * - S for DOWN
 * - A for LEFT
 * - D for RIGHT
 * For the Player shoot mechanic:
 * - I for UP
 * - K for DOWN
 * - J for LEFT
 * - L for Right
 */
public class InputHandler {

    private enum Direction{
        UP,
        LEFT,
        RIGHT,
        DOWN,
        NONE
    }

    private Player player = Player.getInstance();
    private Scanner scanner = new Scanner(System.in);
    private static InputHandler inputHandler = new InputHandler();

    private InputHandler(){}

    public static InputHandler getInstance(){
        return inputHandler;
    }

    /**
     * handle keyboard Input:
     * Player movement:
     * - W for UP
     * - S for DOWN
     * - A for LEFT
     * - D for RIGHT
     * Player shoot mechanic:
     * - I for UP
     * - K for DOWN
     * - J for LEFT
     * - L for Right
     */
    public void handleInput(){

        System.out.println("Chose if you like to move or shot: ");
        char Inputchar = scanner.next().charAt(0);

        switch (Inputchar){
            case 'W':
            case 'w':
                movePlayer(Direction.UP);
                break;
            case 'S':
            case 's':
                movePlayer(Direction.DOWN);
                break;
            case 'A':
            case 'a':
                movePlayer(Direction.LEFT);
                break;
            case 'D':
            case 'd':
                movePlayer(Direction.RIGHT);
                break;
            case 'I':
            case 'i':
                playerShoot(Direction.UP);
                break;
            case 'K':
            case 'k':
                playerShoot(Direction.DOWN);
                break;
            case 'J':
            case 'j':
                playerShoot(Direction.LEFT);
                break;
            case 'L':
            case 'l':
                playerShoot(Direction.RIGHT);
                break;
            default:
                System.out.println("This is not a valid Input.");
                movePlayer(Direction.NONE);
        }
    }

    /**
     * The player can move in 4 Directions: UP, DOWN, LEFT, RIGHT
     * @param direction
     */
    private void movePlayer(Direction direction){
        switch (direction){
            case UP:
                player.moveUp();
                break;
            case DOWN:
                player.moveDown();
                break;
            case LEFT:
                player.moveLeft();
                break;
            case RIGHT:
                player.moveRight();
                break;
            case NONE:
                System.out.println("You went nowhere");
        }
    }

    /**
     * The player can shoot in 4 Directions: UP, DOWN, LEFT, RIGHT
     * @param direction
     */
    private void playerShoot(Direction direction){
        switch (direction){
            case UP:
                player.shootUp();
                break;
            case DOWN:
                player.shootDown();
                break;
            case LEFT:
                player.shootLeft();
                break;
            case RIGHT:
                player.shootRight();
                break;
            case NONE:
                System.out.println("You shot nowhere");
        }
    }
}
