
public class PercolationDFSFast extends PercolationDFS{

	public PercolationDFSFast(int n) {
		super(n);
	}
	
	@Override
	public void updateOnOpen(int row, int col) {
		if (row == 0) {
			dfs(row,col);
		}
		
		if (inBounds(row-1,col)) {
			if(myGrid[row-1][col] == FULL && myGrid[row-1][col] == OPEN) {
				dfs(row,col); 
			}
		}
		
		if (inBounds(row,col-1)) {
			if(myGrid[row][col-1] == FULL && myGrid[row][col-1] == OPEN) {
				dfs(row,col); 
			}
		}
		
		if (inBounds(row,col+1)) {
			if(myGrid[row][col+1] == FULL && myGrid[row][col+1] == OPEN) {
				dfs(row,col); 
			}
		}
		
		
		if (inBounds(row+1,col)) {
			if(myGrid[row+1][col] == FULL && myGrid[row+1][col] == OPEN) {
				dfs(row,col); 
			}
		}
		
	}

}
