public class Room {

    private String content;
    private RoomPosition position;
    private boolean isWumpus = false;
    private boolean isWumpusNear = false;
    private boolean isHole = false;
    private boolean isHoleNear = false;
    private boolean isTreasure = false;

    public Room(String content, RoomPosition position) {
        this.content = content;
        this.position = position;
    }


    public String getContent(){return content;}
    public void setContent(String content) {this.content = content;}

    public RoomPosition getPosition(){return position;}

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

class RoomPosition{
    private final int x;
    private final int y;

    public RoomPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "RoomPosition{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    //We override the default equals Method, so the position of two RoomPosition will be compared not the instance!
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomPosition)) return false;
        RoomPosition that = (RoomPosition) o;
        return x == that.x &&
                y == that.y;
    }
}
