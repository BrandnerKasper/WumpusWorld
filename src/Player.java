public class Player {
    private RoomPosition position;
    private int shootCounter;

    public Player() {
        position = new RoomPosition(0,0);
    }

    public RoomPosition getPlayerPosition() {
        return position;
    }

    public void setPlayerPosition(RoomPosition position) {
        this.position = position;
    }

    //Player can shoot in every direction
    public void shoot(){

    }

}
