
public class PercolationUF implements IPercolate{
	
	protected int[][] myGrid;
	protected int myOpenCount;
	protected IUnionFind myFinder;
	private final int VTOP;
	private final int VBOTTOM;
	
	PercolationUF(int size, IUnionFind finder) {
		VTOP = size * size;
		VBOTTOM = size*size+1;
		finder.initialize(size*size + 2);
	}
	@Override
	public void open(int row, int col) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isOpen(int row, int col) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull(int row, int col) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean percolates() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int numberOfOpenSites() {
		// TODO Auto-generated method stub
		return 0;
	}

}
