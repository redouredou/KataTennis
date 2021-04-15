<h1>KATA Tennis</h1>

Tennis has a rather quirky scoring system, and to newcomers it can be a little difficult to keep track of. 
The tennis society has contracted you to build **a scoreboard to display the current score during tennis games.**

Your task is to write the logic which outputs the correct score as a **string** for display on the scoreboard. When a player scores a point, it triggers a method to be called on your class letting you know who scored the point.
Later, you will get a call "score()" from the scoreboard asking what it should display. This method should return a string with the current score.

1. A game is won by the first player to have won at least four points in total and at least two points more than the opponent.

2. The running score of each game is described in a manner peculiar to tennis: scores from zero to three points are described as "**Love**", "**Fifteen**", "**Thirty**", and "**Forty**" respectively.

3. If at least three points have been scored by each player, and the scores are equal, the scores are equal, te score is "**Deuce**"

4. If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is "Advantage" for the player in the lead
