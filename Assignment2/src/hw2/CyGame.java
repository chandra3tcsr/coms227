package hw2;

/**

 * Model of a Monopoly-like game. Two players take turns rolling dice to move

 * around a board. The game ends when one of the players has at least

 * MONEY_TO_WIN money or one of the players goes bankrupt (has negative money).

 * 

 * @author chandrashekar

 */

public class CyGame {

/**

 * Do nothing square type.

 */

public static final int DO_NOTHING = 0;

/**

 * Pass go square type.

 */

public static final int PASS_GO = 1;

/**

 * Cyclone square type.

 */

public static final int CYCLONE = 2;

/**

 * Pay the other player square type.

 */

public static final int PAY_PLAYER = 3;

/**

 * Get an extra turn square type.

 */

public static final int EXTRA_TURN = 4;

/**

 * Jump forward square type.

 */

public static final int JUMP_FORWARD = 5;

/**

 * Stuck square type.

 */

public static final int STUCK = 6;

/**

 * Points awarded when landing on or passing over go.

 */

public static final int PASS_GO_PRIZE = 200;

/**

 * The amount payed to the other player per unit when landing on a

 * PAY_PLAYER square.

 */

public static final int PAYMENT_PER_UNIT = 20;

/**

 * The amount of money required to win.

 */

public static final int MONEY_TO_WIN = 400;

/**

 * The cost of one unit.

 */

public static final int UNIT_COST = 50;
/**
 * money of the player 1 in the game
 */
private int playerMoney_1;
/**
 * money of the player 2 in the game
 */
private int playerMoney_2;
/**
 * units of the player 1 in the game, which is equated to 1
 */
private int playerUnits_1=1;
/**
 * units of the player 2 in the game, which is equated to 1
 */
private int playerUnits_2=1;
/**
 * used in the method isGameEnded()
 */
private boolean endGame;
/**
 * the square in which the player 1 is present
 */
private int currentPlayer1Square;
/**
 * the square in which the player 2 is present
 */
private int currentPlayer2Square;
/**
 * total squares of the game
 */
private int totalGameSquares;
/**
 * players turn currently, which is equated to 1
 */
private int currentPlayer=1;


/**
 * CyGame constructor
 * money of player 1 is equated to the startingMoney
 * money of player 2 is equated to the startingMoney
 * total squares of the game is equated to the numSquares
 * the squares of player 1 and 2 is equated to 0
 * @param numSquares
 * @param startingMoney
 */
public CyGame(int numSquares, int startingMoney){

	playerMoney_1=startingMoney;

	playerMoney_2=startingMoney;

	totalGameSquares=numSquares;

	currentPlayer1Square=0;

	currentPlayer2Square=0;

	

}


/**
 * the getCurrentPlayer() returns the current player 
 * @return
 */
public int getCurrentPlayer() {

	return currentPlayer;

}

/**
 * the getPlayer1Money() returns the money of player 1
 * @return
 */
public int getPlayer1Money() {

	return playerMoney_1;

}

/**
 * the getPlayer2Money() returns the money of player 2
 * @return
 */
public int getPlayer2Money() {

	return playerMoney_2;

}

/**
 * the getPlayer1Units() returns the units of player 1
 * @return
 */
public int getPlayer1Units() {

	return playerUnits_1;

}

/**
 * the getPlayer2Units() returns the units of player 2
 * @return
 */
public int getPlayer2Units() {

	return playerUnits_2;

}

/**
 * the getPlayer1Square() returns the square in which player 1 is there
 * @return
 */
public int getPlayer1Square() {

	return currentPlayer1Square;

}

/**
 * the getPlayer2Square() returns the square in which player 2 is there
 * @return
 */
public int getPlayer2Square() {

	return currentPlayer2Square;

}

/**
 * the getSquareType(int square) returns the type of square in which the player is there
 * the order of types are given according to the priority list 
 * @param square
 * @return
 */
public int getSquareType(int square) {

	if(square==0) {

		return PASS_GO;

	}else if(square==totalGameSquares-1) {

		return CYCLONE;

	}else if(square%5==0) {

		return PAY_PLAYER;

	}else if(square%7==0 || square%11==0) {

		return EXTRA_TURN;

	}else if(square%3==0) {

		return STUCK;

	}else if(square%2==0) {

		return JUMP_FORWARD;

	}else {

		return DO_NOTHING;

	}

}


/**
 *the buyUnit() is a method to buy a unit
 *this can only happen if the square type is DO_NOTHING and the money is greater than UNIT_COST
 *the units are increment and the money is decremented
 */
public void buyUnit() {
if(!isGameEnded()) {
	if(currentPlayer==1) {
		if(getSquareType(currentPlayer1Square)==DO_NOTHING && playerMoney_1>=UNIT_COST) {
			playerUnits_1+=1;
			playerMoney_1-=UNIT_COST;
			isGameEnded();
			endTurn();
			
		}
	}else if(currentPlayer==2 ) {
     if(getSquareType(currentPlayer2Square)==DO_NOTHING && playerMoney_2>=UNIT_COST) {

		playerUnits_2+=1;

		playerMoney_2-=UNIT_COST;
		isGameEnded();
		endTurn();

		}

		}
}

}


/**
 * the endTurn() is a method used to end a turn of a a player and given the turn to the next
 * the process continues vice-versa
 */
public void endTurn() {

	if(currentPlayer==1) {

		currentPlayer=2;

	}else {

		currentPlayer=1;

	}

}


/**
 * the sellUnit() is a method used to sell a unit to the players
 * this can only happen if the players have a minimum of 1 unit
 * the money is incremented and units are decremented
 */
public void sellUnit() {
if (!isGameEnded()) {
if(currentPlayer==1 && playerUnits_1>=1) {
		
		playerUnits_1-=1;

		playerMoney_1+=UNIT_COST;
		isGameEnded();
		endTurn();
		
		
	}else if(currentPlayer==2 && playerUnits_2>=1) {

		
		playerUnits_2-=1;
		playerMoney_2+=UNIT_COST;
		isGameEnded();
		endTurn();
		

	}
}
}



/**
 * the isGameEnded() is a method to see if the game has ended
 * this happens only if the money is in negative value or the money is greater than or equal to MONEY_TO_WIN
 * @return
 */
public boolean isGameEnded() {

	if((playerMoney_1<0) || (playerMoney_1>=MONEY_TO_WIN) || (playerMoney_2<0) || (playerMoney_2>=MONEY_TO_WIN)) {

	endGame=true;
	endTurn();

	}

return endGame;

}


/**
 * the roll(int value) is a method used to add a value to the squares of the players
 * the value of the die is only added if the player on the STUCK square rolls a even number
 * the process for the other square types are given under conditions of each of the current player in the game
 * money of players are incremented and decremented accordingly in the PAY_PLAYER square type
 * current player is equated accordingly in EXTRA_TURN
 * squares are equated to each other in CYCLONE
 * @param value
 */
public void roll(int value) {
if(!isGameEnded()) {
if(getCurrentPlayer()==1) {
if (getSquareType(currentPlayer1Square)!=STUCK ||(getSquareType(currentPlayer1Square)==STUCK && value%2==0)) {

		currentPlayer1Square+=value;

	if (totalGameSquares<=currentPlayer1Square) {
		playerMoney_1+=PASS_GO_PRIZE;
		currentPlayer1Square -=totalGameSquares;
		isGameEnded();
		endTurn();

		}


	if(getSquareType(currentPlayer1Square)==PAY_PLAYER) {

	playerMoney_1-=playerUnits_2*PAYMENT_PER_UNIT;

	playerMoney_2+=playerUnits_2*PAYMENT_PER_UNIT;
	isGameEnded();

		endTurn();	

		}else if(getSquareType(currentPlayer1Square)==EXTRA_TURN) {

			currentPlayer=1;


		}else if(getSquareType(currentPlayer1Square)==STUCK) {
			isGameEnded();
			endTurn();
		
		}else if(getSquareType(currentPlayer1Square)==DO_NOTHING) {
			isGameEnded();
			endTurn();

		
		}else if(getSquareType(currentPlayer1Square)==CYCLONE) {

		currentPlayer1Square=currentPlayer2Square;
        isGameEnded();
		endTurn();

		}else if(getSquareType(currentPlayer1Square)==JUMP_FORWARD) {

			currentPlayer1Square+=4;

		if(totalGameSquares<=currentPlayer1Square) {

		playerMoney_1+=PASS_GO_PRIZE;
		currentPlayer1Square-=totalGameSquares;

		endTurn();
		isGameEnded();
		}else {
			endTurn();
			isGameEnded();
		}

		}
	}else {
		endTurn();
	}

}	

else if(getCurrentPlayer()==2) {
if (getSquareType(currentPlayer2Square)!=STUCK ||( getSquareType(currentPlayer2Square)==STUCK && value%2==0)) {

		currentPlayer2Square+=value;

	if(totalGameSquares<=currentPlayer2Square) {
		currentPlayer2Square -= totalGameSquares;
			playerMoney_2+=PASS_GO_PRIZE;
			isGameEnded();
			endTurn();
			

		}else if(getSquareType(currentPlayer2Square)==PAY_PLAYER) {

		playerMoney_2-=playerUnits_1*PAYMENT_PER_UNIT;

		playerMoney_1+=playerUnits_1*PAYMENT_PER_UNIT;
		isGameEnded();

		endTurn();

		}else if(getSquareType(currentPlayer2Square)==EXTRA_TURN) {

			currentPlayer=2;
			isGameEnded();

		}else if(getSquareType(currentPlayer2Square)==STUCK) {
			endTurn();
			isGameEnded();
		}else if(getSquareType(currentPlayer2Square)==CYCLONE) {

			currentPlayer2Square=currentPlayer1Square;
			isGameEnded();
			endTurn();

	}else if(getSquareType(currentPlayer2Square)==JUMP_FORWARD) {
			currentPlayer2Square+=4;
		 if(totalGameSquares<=currentPlayer2Square) {

			playerMoney_2+=PASS_GO_PRIZE;

			currentPlayer2Square-=totalGameSquares;
			isGameEnded();
			endTurn();

		 }else {
			isGameEnded();
			endTurn();

		}

		}else if(getSquareType(currentPlayer2Square)==DO_NOTHING) {
			isGameEnded();
			endTurn();

		}

}else {
	isGameEnded();
   endTurn();

	}
}
isGameEnded();	
}
}

// TODO: EVERTHING ELSE

// Note that this code will not compile until you have put in stubs for all

// the required methods.

// The method below is provided for you and you should not modify it.

// The compile errors will go away after you have written stubs for the

// rest of the API methods.

/**

 * Returns a one-line string representation of the current game state. The

 * format is:

 * <p>

 * <tt>Player 1*: (0, 0, $0) Player 2: (0, 0, $0)</tt>

 * <p>

 * The asterisks next to the player's name indicates which players turn it

 * is. The numbers (0, 0, $0) indicate which square the player is on, how

 * many units the player has, and how much money the player has

 * respectively.

 * 

 * @return one-line string representation of the game state

 */

public String toString() {

String fmt = "Player 1%s: (%d, %d, $%d) Player 2%s: (%d, %d, $%d)";

String player1Turn = "";

String player2Turn = "";

if (getCurrentPlayer() == 1) {

player1Turn = "*";

} else {

player2Turn = "*";

}

return String.format(fmt,

player1Turn, getPlayer1Square(), getPlayer1Units(), 

getPlayer1Money(),

player2Turn, getPlayer2Square(), getPlayer2Units(), 

getPlayer2Money());

}

}