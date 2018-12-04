
public class PercolationDFSFast extends PercolationDFS{

	public PercolationDFSFast(int n) {
		super(n);
	}
	
	/**
	 * @param ints row and col 
	 * makes updateOnOpen more efficient such that it does not clear all cells, but instead 
	 * calls dfs once if the newly open cell should be marked FULL because it is in the top row
	 * or because it is adjacent to an already FULL cell 
	 */
	@Override
	protected void updateOnOpen(int row, int col) {
		if (row == 0) {
			dfs(row,col);
		}
		
		if (inBounds(row-1,col)) {
			if(myGrid[row-1][col] == FULL && myGrid[row][col] == OPEN) {
				dfs(row,col); 
			}
		}
		
		if (inBounds(row,col-1)) {
			if(myGrid[row][col-1] == FULL && myGrid[row][col] == OPEN) {
				dfs(row,col); 
			}
		}
		
		if (inBounds(row,col+1)) {
			if(myGrid[row][col+1] == FULL && myGrid[row][col] == OPEN) {
				dfs(row,col); 
			}
		}
		
		
		if (inBounds(row+1,col)) {
			if(myGrid[row+1][col] == FULL && myGrid[row][col] == OPEN) {
				dfs(row,col); 
			}
		}
		
	}

}
