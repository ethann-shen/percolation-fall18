
public class PercolationUF implements IPercolate{
	
	protected boolean[][] myGrid;
	protected int myOpenCount;
	protected IUnionFind myFinder;
	private final int VTOP;
	private final int VBOTTOM;
	
	/**
	 * @param size is the length of myGrid
	 * @param finder is an IUnionFind object 
	 * constructor initializes myGrid, VTOP, VBOTTOM, myFinder, and myOpenCount
	 */
	PercolationUF(int size, IUnionFind finder) {
		myGrid = new boolean[size][size];
		VTOP = size * size;
		VBOTTOM = size*size+1;
		myFinder = finder;
		myFinder.initialize(size*size + 2);
		myOpenCount = 0;
	}
	
	/**
	 * @param ints row and col 
	 * if the cell is not open, marks the cell as open and connects with open neighbors 
	 */
	@Override
	public void open(int row, int col) {
		int size = myGrid.length;
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		
		if (isOpen(row,col)) {
			return;
		}
		
		myGrid[row][col] = true;
		myOpenCount += 1;
		
		if (row == 0 && isOpen(row,col)) {
			myFinder.union(row*size + col, VTOP);
		}
		if (row == size - 1 && isOpen(row,col)) {
			myFinder.union(row*size + col, VBOTTOM);
		}
 
		if (inBounds(row+1,col) && isOpen(row+1,col) && isOpen(row,col)) {
			myFinder.union(row*size + col, (row+1) * size + col);

		}
		if (inBounds(row-1,col) && isOpen(row-1,col) && isOpen(row,col)) {
			myFinder.union(row*size + col, (row-1) * size + col);

		}
		if (inBounds(row,col+1) && isOpen(row,col+1) && isOpen(row,col)) {
			myFinder.union(row*size + col, row*size + (col+1));

		}
		if (inBounds(row,col-1) && isOpen(row,col-1) ) {
			myFinder.union(row*size + col, row*size + (col-1));
		}
	}

	/**
	 * @param ints row and col
	 * throws exception if the cell is out of bounds, otherwise returns the myGrid value
	 */
	@Override
	public boolean isOpen(int row, int col) {
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		return myGrid[row][col];
	}
	
	/**
	 * @param ints row and col
	 * throws exception if the cell is out of bounds, otherwise checks if the cell is connected 
	 * to VTOP 
	 */
	@Override
	public boolean isFull(int row, int col) {
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		return myFinder.connected(row*myGrid.length + col, VTOP);
	}
	
	/**
	 * checks to see if VTOPand VBOTTOM are connected 
	 */
	@Override
	public boolean percolates() {
		return myFinder.connected(VTOP, VBOTTOM);
	}
	
	/**
	 * returns the number of open sites 
	 */
	@Override
	public int numberOfOpenSites() {
		return myOpenCount;
	}
	
	/**
	 * @param ints row and col
	 * checks to see if the cell is in bounds 
	 */
	public boolean inBounds(int row, int col) {
		if (row < 0 || row >= myGrid.length) return false;
		if (col < 0 || col >= myGrid[0].length) return false;
		return true;
	}
}
