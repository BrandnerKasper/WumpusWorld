public class Game {

    private Scoresystem scoresystem;
    private static boolean gameIsOver = false;
    private Dungeon dungeon;
    private InputHandler inputHandler;

    public Game() {
        dungeon = new Dungeon();
        dungeon.printDungeon();

        inputHandler = new InputHandler();
        scoresystem = new Scoresystem();
    }

    public void gameLoop(){
        while (!gameIsOver){
            inputHandler.handleInput();
            getUpdate();
        }
    }

    private void getUpdate(){
        Room currentRoom = Dungeon.getRoomAtPosition(Player.getPlayerPosition());
        if (currentRoom.isWumpus()){gameIsOver=true;}
        if (currentRoom.isHole()){gameIsOver=true;}
        if (currentRoom.isTreasure()){
            System.out.println("Wow, you found the treasure!");
            //add score
        }
        String updateString = "In the place you are it is: \n Breezy: " + currentRoom.isHoleNear() + "\n Stinky: " + currentRoom.isWumpusNear();
        System.out.println(updateString);
    }

    public static void setGameIsOver(){
        gameIsOver = true;
    }
}
