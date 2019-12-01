public class Room {

    private String content;
    private Position position;
    private boolean isWumpus = false;
    private boolean isWumpusNear = false;
    private boolean isHole = false;
    private boolean isHoleNear = false;
    private boolean isTreasure = false;

    public Room(String content, Position position) {
        this.content = content;
        this.position = position;
    }


    public String getContent(){return content;}
    public void setContent(String content) {this.content = content;}

    public Position getPosition(){return position;}

    public boolean isWumpus() {return isWumpus;}
    public void setWumpus(boolean wumpus) {isWumpus = wumpus;}

    public boolean isWumpusNear() {return isWumpusNear;}
    public void setWumpusNear(boolean wumpusNear) {isWumpusNear = wumpusNear;}

    public boolean isHole() {return isHole;}
    public void setHole(boolean hole) {isHole = hole;}

    public boolean isHoleNear() {return isHoleNear;}
    public void setHoleNear(boolean holeNear) {isHoleNear = holeNear;}

    public boolean isTreasure() {return isTreasure;}
    public void setTreasure(boolean treasure) {isTreasure = treasure;}
}
