public class Game {

    private Scoresystem scoresystem = Scoresystem.getInstance();
    private static boolean gameIsOver = false;
    private Dungeon dungeon = Dungeon.getInstance();
    private InputHandler inputHandler = InputHandler.getInstance();
    private Player player = Player.getInstance();

    private static Game game = new Game();

    private Game() {
        dungeon.printDungeon();
    }

    public static Game getInstance(){
        return game;
    }

    public void gameLoop(){
        while (!gameIsOver){
            getUpdateOnRoom();
            //Problem if game is over player can still move one more time.. we need to catch that
            if (!gameIsOver) {inputHandler.handleInput();}
        }

        System.out.println("The game is Over.");
        System.out.println("Your Score: " + scoresystem.getScore());
    }

    private void getUpdateOnRoom(){
        Room currentRoom = dungeon.getRoomAtPosition(player.getPlayerPosition());
        if (currentRoom.isWumpus()){
            setGameIsOver();
            System.out.println("Oh no! You fall into a dark seemingly endless pit!");
            scoresystem.updateScore(scoresystem.getGetKilledScore());

        }
        if (currentRoom.isHole()){
            setGameIsOver();
            System.out.println("The stench is getting too thick! You loose control over your body... you blacked out...");
            scoresystem.updateScore(scoresystem.getGetKilledScore());
        }
        if (currentRoom.isTreasure()){
            System.out.println("Wow, you found the treasure!");
            scoresystem.updateScore(scoresystem.getFoundTreasureScore());
        }
        String updateString = "In the place you are it is: \n Breezy: " + currentRoom.isHoleNear() + "\n Stinky: " + currentRoom.isWumpusNear();
        System.out.println(updateString);
    }

    public static void setGameIsOver(){
        gameIsOver = true;
    }
}
