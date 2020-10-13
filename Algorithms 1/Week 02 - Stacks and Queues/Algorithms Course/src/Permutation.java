import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RandomizedQueue<String> myQueue = new RandomizedQueue<String>();
        int k = Integer.valueOf(args[0]); 
//        StdOut.println("Inserted  k:" + k);
       
//        String [] input = StdIn.readString();
//        for(String s : input)
//        	System.out.println(s);
      //  int k = StdIn.readInt();
      while(!StdIn.isEmpty()) {
//        StdOut.println("Reading string now"); 
        myQueue.enqueue(StdIn.readString());
      }
//            
//        StdOut.println("Reading strings done");
        
        while (k > 0) {
            k--;
            StdOut.println( myQueue.dequeue());
        }
        
        
    }

}
