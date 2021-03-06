class Position{
    private final int x;
    private final int y;

    private Dungeon dungeon = Dungeon.getInstance();

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isPositionValid(Position position){
        for (Room room : dungeon.roomList){
            if (room.getPosition().equals(position)){return true;}
        }
        return false;
    }

    /**
     * Returns True if the room your aiming on is the Wumpus Chamber
     * @param position
     * @return boolean
     */
    public boolean isWumpusShot(Position position){
        return dungeon.getRoomAtPosition(position).isWumpus();
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
        if (!(o instanceof Position)) return false;
        Position that = (Position) o;
        return x == that.x &&
                y == that.y;
    }
}