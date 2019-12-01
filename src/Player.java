public class Player {
    private Position position;
    private int shootCounter;

    public Player() {
        position = new Position(0,0);
    }

    public Position getPlayerPosition() {
        return position;
    }

    public void setPlayerPosition(Position position) {
        this.position = position;
    }


    /**
     * Player moves in every direction
     */
    public void moveUp(){
        Position newPlayerPosition = new Position(getPlayerPosition().getX(),getPlayerPosition().getY()+1);
        if (position.isPositionValid(newPlayerPosition))
            {setPlayerPosition(newPlayerPosition);}
        else {
            System.out.println("There is no room for you to go! Try another Direction!");
        }
    }

    public void moveDown(){
        Position newPlayerPosition = new Position(getPlayerPosition().getX(),getPlayerPosition().getY()-1);
        if (position.isPositionValid(newPlayerPosition))
            {setPlayerPosition(newPlayerPosition);}
        else {
            System.out.println("There is no room for you to go! Try another Direction!");
        }
    }

    public void moveRight(){
        Position newPlayerPosition = new Position(getPlayerPosition().getX()+1,getPlayerPosition().getY());
        if (position.isPositionValid(newPlayerPosition))
            {setPlayerPosition(newPlayerPosition);}
        else {
            System.out.println("There is no room for you to go! Try another Direction!");
        }
    }

    public void moveLeft(){
        Position newPlayerPosition = new Position(getPlayerPosition().getX()-1,getPlayerPosition().getY());
        if (position.isPositionValid(newPlayerPosition))
            {setPlayerPosition(newPlayerPosition);}
        else {
            System.out.println("There is no room for you to go! Try another Direction!");
        }
    }

    public void shootUp(){

    }

    public void shootDown(){

    }

    public void shootLeft(){

    }

    public void shootRight(){

    }

}
