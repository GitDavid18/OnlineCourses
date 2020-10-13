package assignment1;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
      private int size = 0;
      private int trials = 0;
      private double openSiteFractions[] = null;
      private double mean = 0.0;
      private double stddev = 0.0;
      
      private double performPercolationTest(int n) {
          Percolation perco = new Percolation(n);
          int amountOpenSitesTillPercolation = 0;
          while(!perco.percolates()) {
              int row, col = 0;
              row = StdRandom.uniform(0, n + 1);
              col = StdRandom.uniform(0, n + 1);
              try {
                  if (!perco.isOpen(row, col)) {
                     // StdOut.println("Opening: (" + row + ", " + col + ")");
                      perco.open(row, col);
                      amountOpenSitesTillPercolation++;
                      }
                  }
              catch(IllegalArgumentException iae) {                          
              }
                 
              }
         
          return amountOpenSitesTillPercolation;
      }
    
        // perform trials independent experiments on an n-by-n grid
	   public PercolationStats(int n, int trials) {
	       if(n<=0 || trials <=0) throw new java.lang.IllegalArgumentException();
	       
	       this.trials = trials;
	       size = n;
	       openSiteFractions = new double [trials];
	       for(int i = 0; i < trials; i++) {
	           openSiteFractions [i] = performPercolationTest(size) / (size*size);

	       }

	   }
	   // sample mean of percolation threshold
	   public double mean() {
	       mean = StdStats.mean(openSiteFractions);
	       return mean;
	   }
	   // sample standard deviation of percolation threshold
	   public double stddev()     {
	       stddev = StdStats.stddev(openSiteFractions); 
	       return stddev;
	       
	   }      
	   // low  endpoint of 95% confidence interval
	   public double confidenceLo() {
	       return(mean()-(1.96*stddev()/Math.sqrt(trials)));
	   }    
	   // high endpoint of 95% confidence interval
	   public double confidenceHi()  {
	       return(mean()+(1.96*stddev()/Math.sqrt(trials)));
	   }   
	   
	   // test client (described below)
	   public static void main(String[] args)  {     
		    StdOut.println("Please enter the size of your grid: ");
		    int gridSize = StdIn.readInt();
		    StdOut.println("Please enter the amount of runs: ");
		    int runs = StdIn.readInt();
		    PercolationStats perfStats = new PercolationStats(gridSize, runs);
		 
	        StdOut.println("mean = " + perfStats.mean());
	        StdOut.println("stddev = " + perfStats.stddev());
	        StdOut.println("95% confidence interval = [" + perfStats.confidenceLo() +", " + perfStats.confidenceHi() + "]");
		   
	   }
		
}
