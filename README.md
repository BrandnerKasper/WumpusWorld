# WumpusWorld (Work in Progress)
Wumpus World is a round based Text Adventure, in which you try to find and hunt a wumpus in a dungeon. 
The Game Logic:
For a better understanding of how the game works, I printed it and it can look like this:
<pre>
.HH.
....
..T.
SH.W
</pre>
You start in a dungeon with different rooms.
S is the Start of the player, H is a Hole, W is the Wumpus monster and T is the treasure.
In every round you have the choice btw. 2 actions: move or shoot. The clue of the game is that you only have the information of the room you are in. Rooms near a Hole or the Wumpus get Breezy or Stinky, respectively, so you know you are near one of them. It is not clear which of the neighboring rooms it is. By further moving cautiously around the dungeon, you gather information to find the wumpus and shoot him. Successfully shooting thewumpus means, that you have won the game. But be careful, you only have one shot and therefore, only one chance! If you are lucky or greedy you can find a treasure to further increase your score!

For further information on the game visit:
<url>
https://en.wikipedia.org/wiki/Hunt_the_Wumpus
</url>

This version of the game is not yet fully implemented!
