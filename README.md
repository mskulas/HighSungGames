# High Sung Games - a text-based gambling game by Mitchel Skulas (CSC-325-FA25)
Welcome, fellow high society member, to the High Sung Games (legally distinct from the High Sun Games of Dungeons and Dragons: Honor Among Thieves). When the game starts, you may place your bet on any of three (3) convicted criminals chosen to compete in this gladitorial-style combative game! The game consist of each of the characters rolling dice on randomized intervals. The outcome of each roll alters their score, and when any character reaches a score of 1000 or higher, they win! Each character has their own randomized events that alter their score in different ways. The characters competing are as follows:

* The Thief: Rolls more often than the other characters, but each roll earns less. As a tradeoff, she can't be hurt as much if she rolls poorly. There's plenty of treasure to be plundered around the arena, including a priceless artifact worth 600 points!
* The Wizard: Rolls take more time, but have far greater payoffs. With high reward, however, comes higher risk of putting themself behind. They have access to a powerful incantation that could grant them 999 points in one roll, but could just as easily set them far behind the others. Better not fumble!
* The Knight - (Technically had his knighthood revoked for being a criminal, but he can call himself one here. As a treat.) The most balanced fighter, his rolls are quicker than the Wizard's and more high-stakes than the Thief's. The major boss in the center is his goal, worth 800 points if he dares try to defeat it.

## Running the Game
Running the game couldn't be simpler! Simply run App.java and the code will do the rest.

## Design
The classes fall into three categories: characters, flavor text, and GameState. Characters are threads that behave in the game and determine the outcome, flavor text is a random generator to add variety to the behavior lines (i.e. what kind of monster a character slays), and GameState is a flag that controls when the game is over. I'm aware I could have used interfaces or abstract classes but the characters aren't similar in a way that would make that beneficial, and the flavor text classes are so simple that an interface would 

## Thread stuff
This game uses multi-thread programming to determine how character actions are carried out. The fact that they all have randomized times and only modify a shared public variable once per run means that it's extremely unlikely 