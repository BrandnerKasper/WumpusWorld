import java.util.ArrayList;
import java.util.List;

/**
 * A Dungeon is a 2-dim. Field of Rooms.
 */
public class Dungeon {

    private static int height = 4;
    private static int width = 4;
    private static int roomID = 0;

    private static int roomNumber = height*width;
    private static int holeNumber = height-1;

    //maybe make private!
    public List<Room> roomList = new ArrayList<>(height*width);

    private static Dungeon dungeon = new Dungeon();

    private Dungeon() {
        initDungeon(height,width);
        setPlayerStart();
        setHoles();
        setWumpus();
        setTreasure();
    }

    public static Dungeon getInstance(){
        return dungeon;
    }

    /**
     * We initialize an empty maze with '.' as content.
     * @param height
     * @param width
     */
    private void initDungeon(int height, int width){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Room room = new Room(".", new Position(j, i), roomID);
                roomList.add(room);
                roomID++;
            }
        }
    }

    /**
     * We set the player position at the bottom left corner.
     */
    private void setPlayerStart(){
        roomList.get(0).setContent("S");
    }

    /**
     * At next we set the Holes in our dungeon, we randomly choose the places.
     */
    private void setHoles(){
        for (int i=0; i<holeNumber;i++){
            int randomRoomNumber = (int)((Math.random()*roomNumber));
            if (isRoomEmpty(randomRoomNumber)){
                roomList.get(randomRoomNumber).setContent("H");
                roomList.get(randomRoomNumber).setHole(true);
                makeRoomsAroundBreezy(randomRoomNumber);
            }else {
                i--;
            }
        }
    }

    /**
     * Every room around a room with a Hole get`s breezy so the player knows he is near a hole.
     * @param roomNumber
     */
    private void makeRoomsAroundBreezy(int roomNumber){
        if (isRoomNumberValid(roomNumber+1)){roomList.get(roomNumber+1).setHoleNear(true);}
        if (isRoomNumberValid(roomNumber-1)){roomList.get(roomNumber-1).setHoleNear(true);}
        if (isRoomNumberValid(roomNumber+width)){roomList.get(roomNumber+width).setHoleNear(true);}
        if (isRoomNumberValid(roomNumber-width)){roomList.get(roomNumber-width).setHoleNear(true);}
    }

    /**
     * At next we set the wumpus randomly in the dungeon on a room that is free.
     */
    private void setWumpus(){
        boolean wumpusIsSet = false;
        while (!wumpusIsSet) {
            int randomRoomNumber = (int) ((Math.random() * roomNumber));
            if (isRoomEmpty(randomRoomNumber)) {
                roomList.get(randomRoomNumber).setContent("W");
                roomList.get(randomRoomNumber).setWumpus(true);
                makeRoomsAroundStinky(randomRoomNumber);
                wumpusIsSet = true;
            }
        }
    }

    /**
     * The rooms around the wumpus get stinky so the player knows he is near the wumpus.
     * @param roomNumber
     */
    private void makeRoomsAroundStinky(int roomNumber){
        if (isRoomNumberValid(roomNumber+1)){roomList.get(roomNumber+1).setWumpusNear(true);}
        if (isRoomNumberValid(roomNumber-1)){roomList.get(roomNumber-1).setWumpusNear(true);}
        if (isRoomNumberValid(roomNumber+width)){roomList.get(roomNumber+width).setWumpusNear(true);}
        if (isRoomNumberValid(roomNumber-width)){roomList.get(roomNumber-width).setWumpusNear(true);}
    }

    /**
     * At last we set the Treasure randomly at a free room.
     */
    private void setTreasure(){
        boolean treasureIsSet = false;
        while (!treasureIsSet) {
            int randomRoomNumber = (int) ((Math.random() * roomNumber));
            if (isRoomEmpty(randomRoomNumber)) {
                roomList.get(randomRoomNumber).setContent("T");
                roomList.get(randomRoomNumber).setTreasure(true);
                treasureIsSet = true;
            }
        }
    }

    private boolean isRoomEmpty(int roomNumber){
        return roomList.get(roomNumber).getContent().equals(".");
    }

    public Room getRoomAtPosition(Position position){
        for (Room room : roomList){
            if (room.getPosition().equals(position)){
                return room;
            }
        }
        throw new IllegalArgumentException("invalid position");
    }

    public boolean isRoomNumberValid(int ID){
        for (Room room : roomList){
            if (room.getID() == ID){return true;}
        }
        return false;
    }

    /**
     * We print the maze upside down, so the maze starts in the bottom left corner
     */
    public void printDungeon(){
        StringBuilder dungeonString = new StringBuilder();
        for (int i = height-1; i >=0; i--) {
            for (int j = 0; j < width; j++) {
                Room room = getRoomAtPosition(new Position(j, i));
                dungeonString.append(room.getContent());
            }
            dungeonString.append("\n");
        }
        System.out.println(dungeonString.toString());
    }

}
