import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class RecurQueens{
	static final int max=30;
	static Integer board[][]=new Integer[max][max];
	static int numQ=4;
    // as we need to print the fist board only
    static boolean boardPrinted=false;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Taking number of N for NxN board and N queens from console.
		numQ = Integer.parseInt(br.readLine());
		initializeBoard();
		recursePlaceQueensAtXRow(0);
		if(boardPrinted == false){
			System.out.println("Not possible");
		}
	}
	
	static boolean isValidBoard(int n){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(board[i][j]==1)
				{
					for(int c=i-1;c>=0;c--){
						if(board[c][j]==1){
							return false;
						}
					}
					for(int c=i-1,r=j-1;c>=0 && r>=0;c--,r--){
						if(board[c][r]==1){
							return false;
						}
					}
					for(int c=i-1,r=j+1;c>=0 && r<max;c--,r++){
						if(board[c][r]==1){
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	/*As we can place only one queen in a row, 
	on setting new queen in same row, 
	we need to remove/reset other queen in that row.*/
	static void clearBelowRows(int n){
		for(int j=n;j<max;j++){
			for(int i=0;i<max;i++){
				board[j][i]=0;
			}
		}
	}	
	
	/* Initializing board is setting 0 value at every row and column
	so setting all rows values to 0 */
	static void initializeBoard(){
			clearBelowRows(0);
	}
	
	static void printBoard()
	{
		for(int i=0;i<numQ;i++){
			for(int j=0;j<numQ;j++){
				System.out.print(board[i][j]);
				if(j<numQ-1){
					System.out.print(" ");
				}
			}
			if(i<numQ-1){
				System.out.println();
			}
		}
		System.out.println();
	}
	
	/*Generate all possibilities for placing 4 queen in 4 rows columns.*/
	static void placeQueens(int n){
		for(int a=0;a<n;a++){
			clearBelowRows(0);
			board[0][a]=1;
			for(int b=0;b<n;b++){
				clearBelowRows(1);
				board[1][b]=1;
				for(int c=0;c<n;c++){
					clearBelowRows(2);
					board[2][c]=1;
					for(int d=0;d<n;d++){
						clearBelowRows(3);
						board[3][d]=1;
						printBoard();
					}
				}
			}    
		}
	}
	/*as we see loops containing a, b, c and d variables 
	are same loops running on different rows of the board,
	to reduce complexity of code we use the recursive function*/
	
	//The equivalent recursive code
	static void recursePlaceQueensAtXRow(int x){
		//don't continue computing if board already printed
        if(boardPrinted == false){
		    for(int a=0;a<numQ;a++){
				//clear all queens before placing another on row
			    clearBelowRows(x);
				//place the queen on value of 'a' column of row
     			board[x][a]=1;
				/*if n queens are not placed on n rows
				then call function again with new row to be filled and current board is valid*/
				if(isValidBoard(numQ)){
					if(x<numQ){
						recursePlaceQueensAtXRow(x+1);
						/* if this is the nth queen check if no queen capture other and print*/
						if(x==numQ-1){
							/*check if board is valid and not printed once*/
							if(boardPrinted==false ){
								printBoard();
								boardPrinted = true;
							}
						}
					}
				}
	    	}
	    }
    }
}