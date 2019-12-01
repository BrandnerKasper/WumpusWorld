public class Player {
    private static Position position = new Position(0,0);

    public static Position getPlayerPosition() {
        return position;
    }

    public static void setPlayerPosition(Position position) {
        Player.position = position;
    }

    /**
     * Player can moves in every direction
     * We need to check if position we`re moving him is valid
     */
    public static void moveUp(){
        Position newPlayerPosition = new Position(getPlayerPosition().getX(),getPlayerPosition().getY()+1);
        if (position.isPositionValid(newPlayerPosition))
            {setPlayerPosition(newPlayerPosition);}
        else {
            System.out.println("There is no room for you to go! Try another Direction!");
        }
    }

    public static void moveDown(){
        Position newPlayerPosition = new Position(getPlayerPosition().getX(),getPlayerPosition().getY()-1);
        if (position.isPositionValid(newPlayerPosition))
            {setPlayerPosition(newPlayerPosition);}
        else {
            System.out.println("There is no room for you to go! Try another Direction!");
        }
    }

    public static void moveRight(){
        Position newPlayerPosition = new Position(getPlayerPosition().getX()+1,getPlayerPosition().getY());
        if (position.isPositionValid(newPlayerPosition))
            {setPlayerPosition(newPlayerPosition);}
        else {
            System.out.println("There is no room for you to go! Try another Direction!");
        }
    }

    public static void moveLeft(){
        Position newPlayerPosition = new Position(getPlayerPosition().getX()-1,getPlayerPosition().getY());
        if (position.isPositionValid(newPlayerPosition))
            {setPlayerPosition(newPlayerPosition);}
        else {
            System.out.println("There is no room for you to go! Try another Direction!");
        }
    }

    /**
     * Player can shoot in every Direction
     * 1. We check if Position we`re aiming at is valid
     * 2. We check if Room on that Position contains the Wumpus
     */

    public static void shootUp(){
        Position shootPosition = new Position(getPlayerPosition().getX(),getPlayerPosition().getY()+1);
        if (position.isPositionValid(shootPosition)){
            if (position.isWumpusShot(shootPosition)){
                System.out.println("Wow! The beast is slain you can flee this terrible place!");
                //add Score!
            }else{
                System.out.println("Shooooott! You messed up, that was the wrong room! " +
                        "Oh no... something is following the noice right to your spot...");
                //subtract Score!
            }
            Game.setGameIsOver();
        }
    }

    public static void shootDown(){
        Position shootPosition = new Position(getPlayerPosition().getX(),getPlayerPosition().getY()-1);
        if (position.isPositionValid(shootPosition)){
            if (position.isWumpusShot(shootPosition)){
                System.out.println("Wow! The beast is slain you can flee this terrible place!");
                //add Score!
            }else{
                System.out.println("Shooooott! You messed up, that was the wrong room! " +
                        "Oh no... something is following the noice right to your spot...");
                //subtract Score!
            }
            Game.setGameIsOver();
        }
    }

    public static void shootLeft(){
        Position shootPosition = new Position(getPlayerPosition().getX()-1,getPlayerPosition().getY());
        if (position.isPositionValid(shootPosition)){
            if (position.isWumpusShot(shootPosition)){
                System.out.println("Wow! The beast is slain you can flee this terrible place!");
                //add Score!
            }else{
                System.out.println("Shooooott! You messed up, that was the wrong room! " +
                        "Oh no... something is following the noice right to your spot...");
                //subtract Score!
            }
            Game.setGameIsOver();
        }
    }

    public static void shootRight(){
        Position shootPosition = new Position(getPlayerPosition().getX()+1,getPlayerPosition().getY());
        if (position.isPositionValid(shootPosition)){
            if (position.isWumpusShot(shootPosition)){
                System.out.println("Wow! The beast is slain you can flee this terrible place!");
                //add Score!
            }else{
                System.out.println("Shooooott! You messed up, that was the wrong room! " +
                        "Oh no... something is following the noice right to your spot...");
                //subtract Score!
            }
            Game.setGameIsOver();
        }
    }

}
