public class InputHandler {

    private enum Direction{
        UP,
        LEFT,
        RIGHT,
        DOWN,
        NONE
    }

    public void handleInput(){
        /**
         * handle keyboard Input
         * W for UP
         * S for DOWN
         * A for LEFT
         * D for RIGHT
         */
    }

    private void movePlayer(Direction direction){
        switch (direction){
            case UP:
                Player.moveUp();
                break;
            case DOWN:
                Player.moveDown();
                break;
            case LEFT:
                Player.moveLeft();
                break;
            case RIGHT:
                Player.moveRight();
                break;
            case NONE:
                System.out.println("You went nowhere");
        }
    }

    private void playerShoot(Direction direction){
        switch (direction){
            case UP:
                Player.shootUp();
                break;
            case DOWN:
                Player.shootDown();
                break;
            case LEFT:
                Player.shootLeft();
                break;
            case RIGHT:
                Player.shootRight();
                break;
            case NONE:
                System.out.println("You shot nowhere");
        }
    }
}
