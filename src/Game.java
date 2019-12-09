public class Game {

    private Scoresystem scoresystem = Scoresystem.getInstance();
    private static boolean gameIsOver = false;
    private Dungeon dungeon = Dungeon.getInstance();
    private InputHandler inputHandler = InputHandler.getInstance();
    private Player player = Player.getInstance();

    private static Game game = new Game();

    private Game() {}

    public static Game getInstance(){
        return game;
    }

    /**
     * While the game is not over the player get`s a information update on the room he currently is
     * and can choose to move or shoot.
     */
    public void gameLoop(){
        while (!gameIsOver){
            getUpdateOnRoom();
            //Problem if game is over player can still move one more time.. we need to catch that
            if (!gameIsOver) {inputHandler.handleInput();}
        }

        System.out.println("The game is Over.");
        System.out.println("Your Score: " + scoresystem.getScore());
    }

    /**
     * This gives the player an update on his current room position. So he can choose where to go resp. where to shoot
     */
    private void getUpdateOnRoom(){
        Room currentRoom = dungeon.getRoomAtPosition(player.getPlayerPosition());
        if (currentRoom.isWumpus()){
            setGameIsOver();
            System.out.println("The stench is getting too thick! You loose control over your body... you blacked out...");
            scoresystem.updateScore(scoresystem.getGetKilledScore());
        }
        else if (currentRoom.isHole()){
            setGameIsOver();
            System.out.println("Oh no! You fall into a dark seemingly endless pit!");
            scoresystem.updateScore(scoresystem.getGetKilledScore());
        }
        else if (currentRoom.isTreasure()){
            System.out.println("Wow, you found the treasure!");
            scoresystem.updateScore(scoresystem.getFoundTreasureScore());
        }
        if (currentRoom.isHoleNear()){
            System.out.println("SHHHHHHHZZZZZZ a freezing cold breeze is crawling up to your bones. A Hole must be near by!");
        }
        if (currentRoom.isWumpusNear()){
            System.out.println("WRGGHHHH a terrible stench is reeking up your nose. The Wumpus must be near by!");
        }
        else {
            System.out.println("WOW you feel totally fine. There seems no danger near!");
        }
    }

    public static void setGameIsOver(){
        gameIsOver = true;
    }

    public void printTheGame(){
        dungeon.printDungeon();
    }
}
