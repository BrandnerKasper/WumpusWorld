public class InputHandler {

    private enum Direction{
        UP,
        LEFT,
        RIGHT,
        DOWN,
        NONE
    }

    private Player player = Player.getInstance();
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
        movePlayer(Direction.UP);
    }

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
