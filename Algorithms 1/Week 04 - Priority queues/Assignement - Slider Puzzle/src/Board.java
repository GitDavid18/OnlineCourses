import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;
public class Board {

	private int tiles [][] = null;
	private int dimensions = 0;
	private int manhattan = 0;
	private int hamming = 0; 
	
    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
    	dimensions = tiles.length;
    	 this.tiles = new int[dimensions][dimensions];
    	 for (int i = 0; i < tiles.length; i++) {
    		 for (int j = 0; j < tiles.length; j++) {
    			 this.tiles[i][j] = tiles [i][j];
    		 }
    	 }
    	 manhattanDist();
    	 hamming();
    	 
    }
                                           
    // string representation of this board
    public String toString() {
    	StringBuilder output = new StringBuilder();
    	output.append(String.valueOf(dimensions) + "\n");
    	for (int i = 0; i < dimensions; i++) {
   		 	for (int j = 0; j < dimensions; j++) {
   		 		output.append (tiles [i][j] + " ");
   		 	}
   		 	output.append("\n");
   	 	}
   	 	return output.toString();
    }

    // board dimension n
    public int dimension() {
    	return dimensions;
    }

    // number of tiles out of place
    public int hamming() {
    	int outOfPlace = 0;
    	
    	for (int i = 0; i < dimensions; i++) {
   		 	for (int j = 0; j < dimensions; j++) {
   		 		if(tiles [i][j] != i * (dimensions) + j + 1 && tiles [i][j] != 0) {
   		 			outOfPlace++;
//   		 			System.out.println("OutOfPlace: [y:" + i + "][x:"+ j + "] " + tiles [i][j]);
   		 		}
   		 	}
    	}
//    	System.out.println("------------");
    	hamming = outOfPlace;
    	return outOfPlace;
    }

    private void manhattanDist() {
   	int manhat = 0;
    	
    	for (int curY = 0; curY < dimensions; curY++) {
   		 	for (int curX = 0; curX < dimensions; curX++) {
   		 		if(tiles [curY][curX] != curY * (dimensions) + curX + 1 && tiles [curY][curX] != 0) {
   		 			int current = tiles [curY][curX]; 
   		 			int deltaX = 0, deltaY = 0;
   		 			
   		 			//deltaY is okay
   		 			for(int runY = 0; runY <= dimensions; runY++) {
   		 				if(current - (runY * dimensions) <= dimensions) {
//   		 					System.out.println("Current: " + current);
   		 					deltaY = runY - (curY);
   		 					current -= runY * (dimensions);
//   		 					System.out.println("deltaY: " + deltaY);
//   		 					System.out.println("new Current: " + current);
   		 					
   		 					break;
   		 				}
   		 			}
   		 			
//   		 			for(int runX = 0; runX <= dimensions; runX++) {
//   		 				if(dimensions - (current + runX) == 1) {
   		 				
//   		 				System.out.println("curX: " + curX);
//   		 				System.out.println("current: " + current);
//   		 					deltaX = runX - curX;
   		 					deltaX = current - curX - 1; 
//   		 					System.out.println("deltaX: " + deltaX);
//   		 					System.out.println("------------");
//   		 					break;
//   		 				}
//   		 			}
   		 			
   		 			manhat += Math.abs(deltaX) + Math.abs(deltaY);
   		 		}
   		 	}
    	}
    	manhattan = manhat;
    }
    
    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
 
    	return manhattan;
    }

    // is this board the goal board?
    public boolean isGoal() {
    	if(hamming == 0 && manhattan == 0 && tiles[dimensions - 1][dimensions - 1] == 0) return true;
    	return false; 	
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == this) return true;
        if(y == null) return false;
    	if (y.getClass() != this.getClass()) return false;
    	Board that = (Board) y; 
    	if (this.dimensions == that.dimensions) {
    	    for (int yCoord = 0; yCoord < dimensions; yCoord++) {
              for (int xCoord = 0; xCoord < dimensions; xCoord++) {
                 if(tiles[yCoord][xCoord] != that.tiles[yCoord][xCoord]) {
                     return false;
                 }
              }
          }
    	  return true;  
    	}
    	return false;
    }

    // all neighboring boards
    public Iterable<Board> neighbors(){
    	return new neighborMaker();
    }
    
    private void exchangePositions(int input [][], int x1, int y1, int x2, int y2){
        int keep = input[y1][x1];
        input [y1][x1] = input [y2][x2];
        input [y2][x2] = keep;
    }
    
    private class neighborMaker implements Iterable<Board>{

        @Override
        public Iterator<Board> iterator() {
            return new neighborIterator();
        }
        
    }
    
    private class neighborIterator implements Iterator<Board>{
       private int yOfZero = 0;
       private int xOfZero = 0;
       private int [][] copy = null;
       private Board [] boards = new Board[4];
       private int current = 0;
       private int neighbors = 0;
        
       private void findNeighbors() {
           int currentBoard = 0;
           if(yOfZero > 0) {
               exchangePositions(copy, xOfZero, yOfZero, xOfZero ,yOfZero - 1);
               boards[currentBoard] = new Board(copy);
//               System.out.println("boards[" + currentBoard  + "]: " + boards[currentBoard].toString());
               neighbors++;
               currentBoard++;
               exchangePositions(copy, xOfZero, yOfZero, xOfZero, yOfZero - 1);
           }
           
           if(yOfZero < dimensions -1 ) {
               exchangePositions(copy, xOfZero, yOfZero, xOfZero, yOfZero + 1);
               boards[currentBoard] = new Board(copy);
//               System.out.println("boards[" + currentBoard  + "]: " + boards[currentBoard].toString());
               neighbors++;
               currentBoard++;
               exchangePositions(copy, xOfZero, yOfZero, xOfZero, yOfZero + 1);
           }
           if(xOfZero > 0) {
               exchangePositions(copy, xOfZero, yOfZero, xOfZero - 1, yOfZero);
               boards[currentBoard] = new Board(copy);
//               System.out.println("boards[" + currentBoard  + "]: " + boards[currentBoard].toString());
               neighbors++;
               currentBoard++;
               exchangePositions(copy, xOfZero, yOfZero, xOfZero - 1, yOfZero);
           }
           if(xOfZero < dimensions - 1) {
               exchangePositions(copy, xOfZero, yOfZero, xOfZero + 1, yOfZero);
               boards[currentBoard] = new Board(copy);
//               System.out.println("boards[" + currentBoard  + "]: " + boards[currentBoard].toString());
               neighbors++;
               currentBoard++;
               exchangePositions(copy, xOfZero, yOfZero, xOfZero + 1, yOfZero);
           }
           
       }
       
        public neighborIterator() {
            copy = new int [dimensions][dimensions];
            // find 0
            for (int y = 0; y < dimensions; y++ ) {
                for (int x = 0; x < dimensions; x++ ) {
                    if (tiles[y][x] == 0) {
                        yOfZero = y;
                        xOfZero = x;
                    }
                    copy[y][x] = tiles[y][x];
                }
            }
  
            findNeighbors();
        }
        
        
        
        
        @Override
        public boolean hasNext() {
            if(neighbors == 0) return false;
            if(current < neighbors) return true;
            return false;
        }

        @Override
        public Board next() {
            if(hasNext()) {
//                current++;
                return boards[current++];    
            }
            return null;
        }
        
        public void remove() { throw new UnsupportedOperationException();}
        
    }

    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {
//        int rand1 = 0;
//        int rand2 = 0;
//        int rand3 = 0;
//        int rand4 = 0;
//        while (rand1 == rand2 && rand1 == rand3 && rand1 == rand4) {
//            rand1 = StdRandom.uniform(0, dimensions);
//            rand2 = StdRandom.uniform(0, dimensions);
//            rand3 = StdRandom.uniform(0, dimensions);
//            rand4 = StdRandom.uniform(0, dimensions);
//        }
//        
////        System.out.println("rand1: " + rand1 + ", rand2: " + rand2);
////        System.out.println("rand3: " + rand3 + ", rand4: " + rand4);
        int [][] save = new int [dimensions][dimensions];
        for (int y = 0; y < dimensions; y++ ) {
            for (int x = 0; x < dimensions; x++ ) {
                save[x][y] = tiles [x][y];
            }
        }
//        int keep = save[rand1][rand2];
//        save [rand1][rand2] = save [rand3][rand4];
//        save [rand3][rand4] = keep;
       int keep = 0;
       if (save[0][0] != 0) {
           keep = save[0][0];
           if (save [1][1] != 0) {
               save [0][0] = save [1][1];
               save [1][1] = keep;
           }else {
               save [0][0] = save [1][0];
               save [1][0] = keep;
           }
       }else {
           keep = save[1][0];
           save [1][0] = save [1][1];
           save [1][1] = keep;
       }
      
      
    	return new Board(save);
    }

    // unit testing (not graded)
    public static void main(String[] args) {
    	int [][]input ={{1,2,3},{4,6,5},{7,8,0}};
    	Board bla = new Board(input);
    	System.out.println(bla.toString());
    	System.out.println("============");
    	System.out.println("Dimensions: " + bla.dimension());
    	System.out.println("============");
    	System.out.println("Hamming: " + bla.hamming());
    	System.out.println("============");
    	System.out.println("Manhattan: " + bla.manhattan());
    	System.out.println("============");
    	System.out.println("Twin: \n" + bla.twin().toString());
    	System.out.println("============");
    	int [][] inp ={{1,2,3},{4,6,8},{7,0,5}};
        Board blub = new Board(inp);
        System.out.println(blub.toString());
        System.out.println("blub = bla? " + blub.equals(bla));
        System.out.println("blub = blub? " + blub.equals(blub));
        System.out.println("Hamming: " + blub.hamming());
        System.out.println("============");
        System.out.println("Manhattan: " + blub.manhattan());
        System.out.println("============");
        System.out.println("Twin: \n" + blub.twin().toString());
        System.out.println("============");
        int[][] newIn = {{1,5,2,3},{4,6,8,7},{10,0,12,11},{14,15,13,9}};
        Board plop = new Board(newIn);
        
        System.out.println(plop.toString());
//        System.out.println("============");
//        System.out.println("Dimensions: " + plop.dimension());
//        System.out.println("============");
//        System.out.println("Hamming: " + plop.hamming());
//        System.out.println("============");
//        System.out.println("Manhattan: " + plop.manhattan());
//        System.out.println("============");
//        System.out.println("Twin: \n" + plop.twin().toString());
//        System.out.println("============");
        
        for(Board b : plop.neighbors()) {
            System.out.println(b.toString());
        }
    }

}