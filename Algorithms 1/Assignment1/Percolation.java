package assignment1;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
//import java.lang.IllegalArgumentException;;


public class Percolation {
	private WeightedQuickUnionUF WQU;
	private int size = 0;
	private int[][] siteState = null;
	private int openSites;
	
	    // create n-by-n grid, with all sites blocked
	   public Percolation(final int n)  {
	       if(n<=0) throw new java.lang.IllegalArgumentException();
	       
	       //initialise WQU with n*n+2 sites
	       WQU = new WeightedQuickUnionUF(n*n+2);
	       size = n;
	       siteState = new int[n][n];
	       openSites = 0;
	       
	       for (int i = 0; i < n; i++) {
	           for (int j =0; j<n; j++) {
	               siteState[i][j] = 0;
	           }
	       }
	   }

	   // open site (row, col) if it is not open already
	   public     void open(final int row, final int col){
	       //check if row and col are legal arguments
	       if (row <= 0 || col <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
	       if (row > size || col > size) {
            throw new java.lang.IllegalArgumentException();
        }
	       //set sitestate in row and col to 1 if not already 1 and increase number of open sites
	       if(siteState[row-1][col-1] != 1) {
	           openSites++;
	           siteState[row-1][col-1] = 1;
	       }
	       
	       //connect ends to virtual endpoints
	       if (row == 1) {
	           WQU.union(size*(row-1)+col, 0);
	       }
	       if (row == size) {
               WQU.union(size*(row-1)+col, size*size+1);
           }
	       //connect site to all adjacent open sites
	       try {
	           if(isOpen(row-1, col)) {
                WQU.union(size*(row-1)+col, size*(row-2)+col);
            }
	       }
	       catch(IllegalArgumentException iae){
	       }
	       try {
	           if(isOpen(row,   col-1)) {
                WQU.union(size*(row-1)+col, size*(row-1)+col-1);
            }
	       }
	       catch(IllegalArgumentException iae){
	       }
	       try {
	           if(isOpen(row,   col+1)) {
                WQU.union(size*(row-1)+col, size*(row-1)+col+1);
            }
	       }
	       catch(IllegalArgumentException iae){
	       }
	       try {
	           if(isOpen(row+1, col)) {
                WQU.union(size*(row-1)+col, size*(row)+col);
            }
	       }
	       catch(IllegalArgumentException iae){
	       }
	   }
	   
	   // is site (row, col) open?
	   public  boolean isOpen(final int row, final int col) {
           //check if row and col are legal arguments
	      // StdOut.println("isOpen: " + row + ", " + col);
           if (row <= 0 || col <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
           if (row > size || col > size) {
            throw new java.lang.IllegalArgumentException();
        }
           
	       return siteState[row-1][col-1] == 1;
	   }
	   
	   // is site (row, col) full?
	   public  boolean isFull(final int row, final int col) {
	       //check if row and col are legal arguments
           if (row <= 0 || col <= 0) {
               throw new java.lang.IllegalArgumentException();
           }
           if (row > size || col > size) {
               throw new java.lang.IllegalArgumentException();
           }
           return WQU.connected(size*(row-1)+col, 0);
       
	   }
	   
	   // number of open sites
	   public      int numberOfOpenSites() {
	       return openSites;
	   }
	   
	   // does the system percolate?
	   public  boolean percolates() {
	       return (WQU.connected(0, size*size+1)); // technically size*size+2-1
	   }             

	   public static void main(final String[] args)  { // test client (optional)
		// TODO Auto-generated method stub

	}

}
