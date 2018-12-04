
public class PercolationDFSFast extends PercolationDFS{

	public PercolationDFSFast(int n) {
		super(n);
	}
	
	@Override
	protected void updateOnOpen(int row, int col) {
		if (row == 0) {
			dfs(row,col);
		}
		
		if (inBounds(row-1,col)) {
			if(isFull(row-1,col) && isOpen(row,col)) {
				dfs(row,col); 
			}
		}
		
		if (inBounds(row,col-1)) {
			if(isFull(row,col-1) && isOpen(row,col)) {
				dfs(row,col); 
			}
		}
		
		if (inBounds(row,col+1)) {
			if(isFull(row,col+1) && isOpen(row,col)) {
				dfs(row,col); 
			}
		}
		
		
		if (inBounds(row+1,col)) {
			if(isFull(row+1,col) && isOpen(row,col)) {
				dfs(row,col); 
			}
		}
		
	}

}
