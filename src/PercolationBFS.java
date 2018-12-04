import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast {

	public PercolationBFS(int n) {
		super(n);
	}

	/**
	 * @param ints row and col 
	 * dequeues a cell, and checks if the any of the dequeued cell's four neighbors are open. 
	 * If any neighboring cell is open and not FULL, it is marked as FULL and enqueued 
	 */
	@Override
	protected void dfs(int row, int col) {
		int size = myGrid.length;
		Queue<Integer> qp = new LinkedList<>(); 
		qp.add(row*size+col);
		myGrid[row][col] = FULL;  
		
		while (qp.size() != 0) {
			int p = qp.remove();
			int r = p/size;
			int c = p%size;
			
			
			if (inBounds(r-1, c) && isOpen(r-1,c) && !isFull(r-1,c)) {
				myGrid[r-1][c] = FULL;
				qp.add((r-1) * size + c);
			}   
			
			if (inBounds(r+1, c) && isOpen(r+1,c) && !isFull(r+1,c)) {
				myGrid[r+1][c] = FULL;
				qp.add((r+1) * size + c);
			}   
			
			if (inBounds(r, c-1) && isOpen(r,c-1) && !isFull(r,c-1)) {
				myGrid[r][c-1] = FULL;
				qp.add((r) * size + c-1);
			}   
			
			if (inBounds(r, c+1) && isOpen(r,c+1) && !isFull(r,c+1)) {
				myGrid[r][c+1] = FULL;
				qp.add((r) * size + c+1);
			}   
			
		
		}
	}

}
