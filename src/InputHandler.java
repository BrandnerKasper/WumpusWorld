public class InputHandler {

    private enum Direction{
        UP,
        LEFT,
        RIGHT,
        DOWN,
        NONE
    }

    //better somewhere else!
    private Player player;


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
                movePlayerUP();
                break;
            case DOWN:
                movePlayerDown();
                break;
            case LEFT:
                movePlayerLeft();
                break;
            case RIGHT:
                movePlayerRight();
                break;
            case NONE:
                System.out.println("You went nowhere");
        }
    }

    //better in player class
    private void movePlayerUP(){
        player.setPlayerPosition(new RoomPosition(player.getPlayerPosition().getX()+1, player.getPlayerPosition().getY()));
    }
    private void movePlayerDown(){
        player.setPlayerPosition(new RoomPosition(player.getPlayerPosition().getX()-1, player.getPlayerPosition().getY()));
    }
    private void movePlayerLeft(){
        player.setPlayerPosition(new RoomPosition(player.getPlayerPosition().getX(), player.getPlayerPosition().getY()-1));
    }
    private void movePlayerRight(){
        player.setPlayerPosition(new RoomPosition(player.getPlayerPosition().getX(), player.getPlayerPosition().getY()+1));
    }
}
