public class Program {

    public static void main(String[] args) {

        System.out.println("Welcome to Wumpus World. Strive through the 4 by 4 quadratic dark dungeon and try to find and hunt the Wumpus! \n " +
                "You start in the bottom left corner. \n" +
                "Your Controls are: \n" +
                "Move in the Direction: \n" +
                "W for UP \n" +
                "S for DOWN \n" +
                "A for LEFT \n" +
                "D for RIGHT \n" +
                "Shoot in the Direction: \n" +
                "I for UP \n" +
                "K for DOWN \n" +
                "J for LEFT \n" +
                "L for RIGHT \n");
        Game game = Game.getInstance();
        game.printTheGame();
        game.gameLoop();
        game.printTheGame();
    }
}
