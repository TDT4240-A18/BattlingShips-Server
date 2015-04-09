# BattlingShips-Server
####Server side of BattlingShips.

The game is a blend of the classic battleship game and wumpus world. The player opens the welcome screen and checks if there is some available game to join. When the player joins the game he has to choose a name, then wait for other people to join. When the game starts all players are moved to game board screen and players start to play. A player has to wait for his turn to perform any action. Player can either move or shoot, when a player is shot, he loses one life, if it was the last one he loses the game. The last one standing wins the game. 

##Description of the game
Multiplayer battling ships:
- The game has a board of tiles.
- The player is a ship that fills one tile. 
- The players is spawned in (at least 2 tiles between each other?, randomly?, partially randomly?, set position?)
- All players can only see the tile they are on and the tiles it has been on. 
- The player has 3 different actions it can make, either shoot, move to a tile close to its current tile or skip doing an action
- If a player is hit by another player, they lose a life
- If a player lose all their life they sink.
- A player wins when it is the only living entity on the board
- Players take turns to do their actions.
- If a boat try to move to a tile where another boat is then it stays at its original tile (but can see the tile it tried to move to)
 When you shoot you will in some way become visible to other players.
- One turn cooldown after you shoot.
- A timer is displayed when it is a players turn. If the timer runs out the skip action should automatically be chosen.

