import java.util.Iterator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
    private Board initial = null;
    private int moves = 0;
//    private MinPQ<Board> solutionSequence = new MinPQ<Board>();
    private MinPQ<SearchNode> boardPQ ;//= new MinPQ<SearchNode>();
    private Board[] sequence; 
    private Boolean isSolvable = false;
    private SearchNode finalNode = null;
    
    
    //SearchNode Class
    private class SearchNode implements Comparable<SearchNode>{
        Board thisBoard = null;
        SearchNode prevSearchNode = null;
        int manhattan = 0;
        int hamming = 0;
        int priority = 0;
        int movesToThis = 0;
        
        SearchNode (Board b, SearchNode prevNode){
            thisBoard = b;
            prevSearchNode = prevNode;
            manhattan = b.manhattan();
            hamming = b.hamming();
            movesToThis = moves;
            priority = movesToThis + manhattan;
        }
        // +1 if this is greater , -1 if that is greater
        @Override
        public int compareTo(SearchNode that) {
//            if (that.equals(this)) return 0;
            if (that.priority > this.priority) return -1;
            if (that.priority < this.priority) return +1;
            if (that.manhattan > this.manhattan) return -1;
            if (that.manhattan < this.manhattan) return +1;
            if (that.hamming > this.hamming) return -1;
            if (that.hamming < this.hamming) return +1;
            return 0;
        }
        
    }

    
    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if(initial == null) throw new IllegalArgumentException();
        this.initial = initial;
        isSolvable = solveBoard();

        if (isSolvable()) {
            sequence = new Board[moves + 1];
            SearchNode curr = finalNode;
            for(int i = moves; i >= 0; i--) {
            	sequence[i] = curr.thisBoard;
            	curr = curr.prevSearchNode;
            }
    	}else {
    		moves = -1;
    		sequence = new Board[0];
    	}

    	
    	
    }
    
    private SearchNode aStarStep (SearchNode currentSearchNode) {
    	SearchNode minPrioNode = null;
//        MinPQ<SearchNode> helpPQ = new MinPQ<SearchNode>();
        for(Board neighbor : currentSearchNode.thisBoard.neighbors()) {
//        	System.out.println("Prio" + neighbor.toString());
        	
        	if(minPrioNode == null) {
        		minPrioNode = new SearchNode(neighbor, currentSearchNode);
        	}else       	{
        		if(currentSearchNode.prevSearchNode != null ) {
        			if( !neighbor.equals(currentSearchNode.prevSearchNode.thisBoard)) {
//        				SearchNode bla = new SearchNode(neighbor, currentSearchNode);
        				if(neighbor.manhattan() < minPrioNode.manhattan) {
            				minPrioNode = new SearchNode(neighbor, currentSearchNode);	
            			}
        			}
        		}else {
        			if(new SearchNode(neighbor, currentSearchNode).priority < minPrioNode.priority) {
        				minPrioNode = new SearchNode(neighbor, currentSearchNode);	
        			}
        			
        		}
        	}
            
        }  	
        return minPrioNode;

    }
    
    
    private boolean aStep(MinPQ<SearchNode> input) {
    	SearchNode inputMin = input.delMin();
//    	System.out.println("New input min: " + inputMin.thisBoard.toString() + " Prev: " + inputMin.prevSearchNode);
    	if (inputMin.thisBoard.isGoal()) {
//    		System.out.println("Goal reached: " + inputMin.thisBoard.toString());
    		input.insert(new SearchNode(inputMin.thisBoard, inputMin.prevSearchNode));
    		return true;
    	}else {
    		for(Board neighbor : inputMin.thisBoard.neighbors()) { //Muss noch checken ob schon in queue 
    			if(inputMin.prevSearchNode == null) { //
    				input.insert(new SearchNode(neighbor, inputMin));
    			}else if(!neighbor.equals(inputMin.prevSearchNode.thisBoard)) {
    				input.insert(new SearchNode(neighbor, inputMin));
    			}
    		}
    	}
    	return false;
    }
    
    private boolean solveBoard() {
//    	System.out.println("Is Solvable?");
    	SearchNode iniNode = new SearchNode(initial, null);
    	SearchNode twinNode = new SearchNode(initial.twin(), null);
    	
    	boardPQ = new MinPQ<SearchNode>();
    	MinPQ <SearchNode> twinPQ = new MinPQ<SearchNode>();
    	twinPQ.insert(twinNode);
    	boardPQ.insert(iniNode);
    	


    		while(true) {
    			
    			SearchNode inputMin = boardPQ.delMin();
    			
//    	    	System.out.println("New input min: " + inputMin.priority + " = " + inputMin.manhattan + "(man) + " + inputMin.movesToThis + "(movestothis)");
    	    	if (inputMin.thisBoard.isGoal()) {

    	    		finalNode = inputMin;
    	    		boardPQ = null;
    	    		twinPQ =null;
    	    		return true;
    	    	}else {
    	    		moves = inputMin.movesToThis + 1;
    	    		for(Board neighbor : inputMin.thisBoard.neighbors()) { //Muss noch checken ob schon in queue 
    	    			if(inputMin.prevSearchNode == null) { //
    	    				boardPQ.insert(new SearchNode(neighbor, inputMin));
    	    				
    	    				
    	    			}else if(!neighbor.equals(inputMin.prevSearchNode.thisBoard)) {
    	    				boardPQ.insert(new SearchNode(neighbor, inputMin));
    	    				
    	    				
    	    				
    	    			}
    	    		}
    	    		
    	    			
    	    	}
    	    	
    	    	
    	    	
    	    	inputMin = twinPQ.delMin();
//    	    	
    	    	if (inputMin.thisBoard.isGoal()) {
//    	    		
    	    		boardPQ = null;
    	    		twinPQ =null;
    	    		return false;
    	    	}else {
    	    		for(Board neighbor : inputMin.thisBoard.neighbors()) { //Muss noch checken ob schon in queue 
    	    			if(inputMin.prevSearchNode == null) { //
    	    				twinPQ.insert(new SearchNode(neighbor, inputMin));
    	    			}else if(!neighbor.equals(inputMin.prevSearchNode.thisBoard)) {
    	    				twinPQ.insert(new SearchNode(neighbor, inputMin));
    	    			}
    	    		}
    	    	}

    		}
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() { 	
    	return isSolvable;	
    }

    // min number of moves to solve initial board
    public int moves() {
    	return moves;
    }

    // sequence of boards in a shortest solution
    public Iterable<Board> solution(){
    	if (!isSolvable()) {
    		return null;
    	}else return new sequenceOfSolution();
    }
    
    private class sequenceOfSolution implements Iterable<Board>{

        @Override
        public Iterator<Board> iterator() {
        	return new solutionIterator();
        }     
    }
    
    private class solutionIterator implements Iterator<Board>{
        int current = 0;
        @Override
        public boolean hasNext() {
            if (current < sequence.length) return true;
            else return false;
        }

        @Override
        public Board next() {
        	
        	if(hasNext() ) {
        		return sequence[current++];
        	}else {
        		return null;
        	}
            
        }
        
        public void remove() { throw new UnsupportedOperationException();}
        
    }

    // test client (see below) 
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);
        System.out.println(initial.toString());

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

}