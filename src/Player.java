public class Player {

    private Scoresystem scoresystem = Scoresystem.getInstance();
    private Position position;
    private static Player player = new Player();

    private Player(){
        position = new Position(0,0);
    };


    public static Player getInstance(){
        return player;
    }

    public Position getPlayerPosition() {
        return position;
    }

    public void setPlayerPosition(Position position) {
        this.position = position;
    }

    /**
     * Player can moves in every direction
     * We need to check if position we`re moving him is valid
     * If player moves we update the score!
     */
    public void moveUp(){
        Position newPlayerPosition = new Position(player.getPlayerPosition().getX(),player.getPlayerPosition().getY()+1);
        if (player.position.isPositionValid(newPlayerPosition))
            {
                player.setPlayerPosition(newPlayerPosition);
                scoresystem.updateScore(scoresystem.getChangedRoomScore());
            }
        else {
            System.out.println("There is no room for you to go! Try another Direction!");
        }
    }

    public void moveDown(){
        Position newPlayerPosition = new Position(player.getPlayerPosition().getX(),player.getPlayerPosition().getY()-1);
        if (player.position.isPositionValid(newPlayerPosition))
        {
            player.setPlayerPosition(newPlayerPosition);
            scoresystem.updateScore(scoresystem.getChangedRoomScore());

        }
        else {
            System.out.println("There is no room for you to go! Try another Direction!");
        }
    }

    public void moveRight(){
        Position newPlayerPosition = new Position(player.getPlayerPosition().getX()+1,player.getPlayerPosition().getY());
        if (player.position.isPositionValid(newPlayerPosition))
        {
            player.setPlayerPosition(newPlayerPosition);
            scoresystem.updateScore(scoresystem.getChangedRoomScore());
        }
        else {
            System.out.println("There is no room for you to go! Try another Direction!");
        }
    }

    public void moveLeft(){
        Position newPlayerPosition = new Position(player.getPlayerPosition().getX()-1,player.getPlayerPosition().getY());
        if (player.position.isPositionValid(newPlayerPosition))
        {
            player.setPlayerPosition(newPlayerPosition);
            scoresystem.updateScore(scoresystem.getChangedRoomScore());
        }
        else {
            System.out.println("There is no room for you to go! Try another Direction!");
        }
    }

    /**
     * Player can shoot in every Direction
     * 1. We check if Position we`re aiming at is valid
     * 2. We check if Room on that Position contains the Wumpus
     */

    public void shootUp(){
        Position shootPosition = new Position(player.getPlayerPosition().getX(),player.getPlayerPosition().getY()+1);
        updateShoot(shootPosition);
    }

    public void shootDown(){
        Position shootPosition = new Position(player.getPlayerPosition().getX(),player.getPlayerPosition().getY()-1);
        updateShoot(shootPosition);
    }

    public void shootRight(){
        Position shootPosition = new Position(player.getPlayerPosition().getX()+1,player.getPlayerPosition().getY());
        updateShoot(shootPosition);
    }

    public void shootLeft(){
        Position shootPosition = new Position(player.getPlayerPosition().getX()-1,player.getPlayerPosition().getY());
        updateShoot(shootPosition);
    }

    /**
     * We test if the position we shoot at is valid. If it`s valid two things can happen:
     * We shot the wumpus and win the game
     * We shot the wrong room and the game is over.
     * @param shootPosition
     */
    private void updateShoot(Position shootPosition) {
        if (player.position.isPositionValid(shootPosition)){
            if (player.position.isWumpusShot(shootPosition)){
                System.out.println("Wow! The beast is slain you can flee this terrible place!");
                scoresystem.updateScore(scoresystem.getKilledWumpusScore());
            }else {
                System.out.println("Shooooott! You messed up, that was the wrong room! " +
                        "Oh no... something is following the noice right to your spot...");
                scoresystem.updateScore(scoresystem.getGetKilledScore());
            }
            Game.setGameIsOver();
        }else {
            System.out.println("Wait! There is no room for you to shoot!");
        }
    }

}
