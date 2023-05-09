import java.util.*;
import java.io.*;
import java.util.*;

public class Battleship {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Battleship!");

        int[][] player1 = {{9,9},
					       {9,9},
					       {9,9},
					       {9,9},
					       {9,9}};
        int[][] player2 = {{9,9},
					       {9,9},
					       {9,9},
					       {9,9},
					       {9,9}};

        System.out.println("PLAYER 1, ENTER YOUR SHIPS’ COORDINATES.");
        player1 = takeInCoordinates(player1,input);
        char[][] player1Board = initPlayingBoards(player1);
        printBattleShip(player1Board);
        print100lines();

        System.out.println("PLAYER 2, ENTER YOUR SHIPS’ COORDINATES.");
        player2 = takeInCoordinates(player2, input);
        char[][] player2Board = initPlayingBoards(player2);
        printBattleShip(player2Board);
        print100lines();



        char[][] player1TargetHistory = {{ '-', '-', '-', '-', '-' }, 
		                                 { '-', '-', '-', '-', '-' }, 
		                                 { '-', '-', '-', '-', '-' }, 
		                                 { '-', '-', '-', '-', '-' }, 
		                                 { '-', '-', '-', '-', '-' }};
		                                 
        char[][] player2TargetHistory = {{ '-', '-', '-', '-', '-' }, 
		                                 { '-', '-', '-', '-', '-' }, 
		                                 { '-', '-', '-', '-', '-' }, 
		                                 { '-', '-', '-', '-', '-' }, 
		                                 { '-', '-', '-', '-', '-' }};

        boolean winnerPlayer = false;
        int[] pfc1 = new int[2];
        int[] pfc2 = new int[2];
        int winnerPlayerCount1 = 0;
        int winnerPlayerCount2 = 0;

        do {
        	pfc1 = fireInCoordinates(1, player1TargetHistory, input);
	        player1TargetHistory  = firePlayingBoards(1, 2, player2, player1TargetHistory, pfc1[0],pfc1[1]);
	        winnerPlayerCount1 = winnerPlayerCountCheck(player1TargetHistory);
	        printBattleShip(player1TargetHistory);

	        if (winnerPlayerCount1 >= 5){
	        	winnerPlayer = true;
	        	System.out.printf("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!\n");
	        	System.out.printf("\nFinal boards:\n");
	        	player1Board = swapBoards(player1Board, player2TargetHistory);
	        	player2Board = swapBoards(player2Board, player1TargetHistory);
	        	printBattleShip(player1Board);
	        	printBattleShip(player2Board);
	        	break;
	        }

	        pfc2 = fireInCoordinates(2, player2TargetHistory, input);
	        player2TargetHistory  = firePlayingBoards(2, 1, player1, player2TargetHistory, pfc2[0],pfc2[1]);
		    winnerPlayerCount2 = winnerPlayerCountCheck(player2TargetHistory);
		    printBattleShip(player2TargetHistory);

	        if (winnerPlayerCount2 >= 5){
	        	winnerPlayer = true;
	        	System.out.printf("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!\n");
	        	System.out.printf("\nFinal boards:\n");
	        	player1Board = swapBoards(player1Board, player2TargetHistory);
	        	player2Board = swapBoards(player2Board, player1TargetHistory);
	        	printBattleShip(player1Board);
	        	printBattleShip(player2Board);
	        	break;
	        }	
	        
        } while(!winnerPlayer); 

    }

    public	static void print100lines(){
    	int i = 0;
    	while(i < 100){
    		System.out.println("");
    		i++;
    	}
    }
    public static char[][] swapBoards(char[][] initBoard, char[][] incrementBoard){
    	for (int i = 0; i < initBoard.length; i++ ){
    		for (int j = 0; j < initBoard[i].length; j++ ){
    			if (incrementBoard[i][j] != '-'){
    				initBoard[i][j] = incrementBoard[i][j];
    			}
    		}
    	}
    	return initBoard;
    }

    public static int winnerPlayerCountCheck(char[][] playerTargetHistory){
    	int winnerPlayerCount = 0;
    	for (char[] hitSpots: playerTargetHistory){
	    	for(char hitSpot : hitSpots){
	    		if (hitSpot == 'X'){
	    			winnerPlayerCount++;
	    		}
	    	}
		}
		return winnerPlayerCount;
    }

    public static int[][] takeInCoordinates(int[][] player,Scanner input){
        
        int i = 0;
        do{
            System.out.printf("Enter ship %d location:\n",i + 1);
            if (input.hasNextInt()) {
                player[i][0] = input.nextInt();
                if (input.hasNextInt()) {
                    player[i][1] = input.nextInt();
                    
                    if ((player[i][0]< 0||player[i][1]<0||player[i][0] > 4||player[i][1] > 4)){
                    	System.out.println("Invalid coordinates. Choose different coordinates.");
                    	continue;
                    } else if (checkCoordinates(i, player) ) {
                        System.out.println("You already have a ship there. Choose different coordinates.");
                        continue;
                    } 
                } else {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    continue;
                }
            } else {
                System.out.println("Invalid coordinates. Choose different coordinates.");
                continue;
            }
            i++;    
        } while (i < 5);
        return player;
    }

    public static int[] fireInCoordinates(int firePlayer, char[][] EnemyPlayer,Scanner input){
    	int[] playerFireCoordinate = new int[2];


        boolean i = true;
        do{
        	System.out.printf("Player %d, enter hit row/column:\n", firePlayer);
            if (input.hasNextInt()) {
                playerFireCoordinate[0] = input.nextInt();
                if (input.hasNextInt()) {
                    playerFireCoordinate[1] = input.nextInt();
                    
                    if ((playerFireCoordinate[0] < 0||playerFireCoordinate[1] <0||playerFireCoordinate[0] > 4||playerFireCoordinate[1] > 4)){
                    	System.out.println("Invalid coordinates. Choose different coordinates.");
                    	continue;
                    } else if (EnemyPlayer[playerFireCoordinate[0]][playerFireCoordinate[1]] != '-'){
                    	System.out.printf("You already fired on this spot. Choose different coordinates.\n");
                    	continue;
                    }
                 
                } else {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    continue;
                }
            } else {
                System.out.println("Invalid coordinates. Choose different coordinates.");
                continue;
            }
            i = false;
        } while (i);
            
        return playerFireCoordinate;
    }

    public static char[][] initPlayingBoards(int[][] player) {
        char[][] playerCharts = {{ '-', '-', '-', '-', '-' }, 
                                { '-', '-', '-', '-', '-' }, 
                                { '-', '-', '-', '-', '-' }, 
                                { '-', '-', '-', '-', '-' }, 
                                { '-', '-', '-', '-', '-' }};
        for (int[] coordinate : player) {
            playerCharts[coordinate[0]][coordinate[1]] = '@';
        }
        return playerCharts;
    }

    public static char[][] firePlayingBoards(int playerWhoFires,int playerBeFired,int[][] EnemyCoordinates,char[][] EnemyPlayer,int x,int y){
		boolean hitOrNot = true; 
		while(hitOrNot){
			for (int[] coordinate : EnemyCoordinates) {       
	        	if (EnemyPlayer[x][y] == '-' ){
	        		if (findCoordinate(x,y,EnemyCoordinates)) {
		        		EnemyPlayer[x][y] = 'X';
		        		hitOrNot = false;
		        		System.out.printf("PLAYER %d HIT PLAYER %d’s SHIP!\n", playerWhoFires, playerBeFired);
		        		break;
	        		} else {
		        		EnemyPlayer[x][y] = 'O';
		        		hitOrNot = false;
						System.out.printf("PLAYER %d MISSED!\n", playerWhoFires) ;
						break;       	
	        		}

	        	} else {
	            	System.out.printf("firePlayingBoardsError.\n");
	            	break;
	        	}
	        }
		}
        
        return EnemyPlayer;
    }

    private static boolean findCoordinate(int x, int y, int[][] EnemyCoordinates){
    	boolean hitOrNot = false;
    	for (int[] coordinate: EnemyCoordinates){
    		if (coordinate[0] == x && coordinate[1] == y){
    			hitOrNot = true;
    			break;
    		}
    	}


    	return hitOrNot;	
    }


    private static boolean checkCoordinates(int start, int[][] coordinates){
        boolean repetitiveCoordinate = false;
        for (int i = 0; i < coordinates.length; i++){
            if (i == start){
            	continue;
            } else if (coordinates[start][0] == coordinates[i][0] && coordinates[start][1] == coordinates[i][1]){
                repetitiveCoordinate = true;
                break;
            }
        }
        return repetitiveCoordinate;
    }

    // Use this method to print game boards to the console.
    private static void printBattleShip(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");
        }
    }
}
