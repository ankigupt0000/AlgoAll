import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class NQueens{
	static final int max=30;
	static Integer board[][]=new Integer[max][max];
	static boolean continuePrint=true;
	static boolean isRecursive=true;
	public static void main(String[] args){
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			initializeBoard();
			if(isRecursive == false){
				if(n>10){
					System.out.println("Please switch to recursive solution as only 10 loops available.");
				}
				if(n > max || n < 1 || n==2 || n == 3){
					System.out.println("Not possible");
					return;
				}
				if(n == 1){
					System.out.println(1);
					return;
				}
				placeQueens(n);
			}else{
				recurseQueens(n,0);
				if(continuePrint == true){
					System.out.println("Not possible");	
					continuePrint=false;
				}
			}
		}catch(IOException e){
		}
	}
	static void initializeBoard(){
		for(int i=0;i<max;i++)
		{
			for(int j=0;j<max;j++)
			{
				board[i][j] = 0;
			}
		}
	}
	static void resetNRow(int n){
		for(int i=0;i<max;i++){
			for(int j=n;j<max;j++){
				board[j][i]=0;
			}
		}
	}
	static boolean checkNQueen(int n){
		int countOfQueens = 0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(board[i][j] == 1){
					countOfQueens++;
				}
			}
		}
		if(countOfQueens != n){
			return false;
		}
		return true;
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
	static void printBoard(int n){
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(board[i][j]);
				if(j<n-1)
					System.out.print(" ");
			}
			if(i<n-1)
				System.out.println();
		}
	}
      static void recurseQueens(int n, int row)
	{
		if(continuePrint==true){
		for(int i=0;i<n;i++){
			resetNRow(row);
			board[row][i]=1;
			if(isValidBoard(n)){
				if(checkNQueen(n)){
					printBoard(n);
					continuePrint=false;
				}
				else if(row<n-1){
					recurseQueens(n,row+1);
				}
			}
		}
		}	
	}
	static void placeQueens(int n){
		aa:
		for(int i=0;i<n;i++){
			resetNRow(0);
			board[0][i]=1;
			if(!isValidBoard(n)){continue;}
			for(int j=0;j<n;j++){
				resetNRow(1);
				board[1][j]=1;
				if(!isValidBoard(n)){continue;}
				for(int k=0;k<n;k++){
					resetNRow(2);
					board[2][k]=1;
					if(!isValidBoard(n)){continue;}
					for(int l=0;l<n;l++){
						resetNRow(3);
						board[3][l]=1;
						if(!isValidBoard(n)){continue;}
						for(int m=0;m<n;m++){
							resetNRow(4);
							board[4][m]=1;
							if(!isValidBoard(n)){continue;}
							for(int o=0;o<n;o++){
								resetNRow(5);
								board[5][o]=1;
								if(!isValidBoard(n)){continue;}
								for(int p=0;p<n;p++){
									resetNRow(6);
									board[6][p]=1;
									if(!isValidBoard(n)){continue;}
									for(int q=0;q<n;q++){
										resetNRow(7);
										board[7][q]=1;
										if(!isValidBoard(n)){continue;}
										for(int r=0;r<n;r++){
											resetNRow(8);
											board[8][r]=1;
											if(!isValidBoard(n)){continue;}
											for(int s=0;s<n;s++){
												resetNRow(9);
												board[9][s]=1;
												if(isValidBoard(n) && checkNQueen(n)){
													printBoard(n);break aa;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}