import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by cole on 11/6/16.
 */
public class PriorityQueue1 {

    private ArrayList<Integer> pQueue;

    public PriorityQueue1(){
        pQueue = new ArrayList<>();
    }

    public boolean isEmpty(){
        return pQueue.isEmpty();
    }

    public void insert(int num){ //O(1)
        pQueue.add(num);
    }

    public int remove(){
        if(pQueue.isEmpty()){
            System.out.println("The priority queue is empty. Return value is 0");
        }

        int max = 0;
        int maxIndex = 0;
        for(int i = 0; i < pQueue.size(); i++){ //O(n)
            if(i == 0){
                max = pQueue.get(i);
            } else {
                if(pQueue.get(i) > max){
                    maxIndex = i;
                    max = pQueue.get(i);
                }
            }
        }
        pQueue.remove(maxIndex);
        return max;
    }

    public ArrayList<Integer> getpQueue() {
        return pQueue;
    }

    public void setpQueue(ArrayList<Integer> pQueue) {
        this.pQueue = pQueue;
    }

    /*
     * This function creates an ArrayList of input data. You may specify the size and
     * max number in the list. Use this to create data to insert into your PriorityQueue
     * when testing run time.
     */
    public ArrayList<Integer> createInput(int size, int maxNum){
        ArrayList<Integer> retVal = new ArrayList<>();
        for(int i = 0; i < size; i++){
            retVal.add(ThreadLocalRandom.current().nextInt(0, maxNum + 1));
        }
        return  retVal;
    }

    public static void main(String [] args){
    	PriorityQueue1 cack = new PriorityQueue1();
    	ArrayList<Integer> cake = cack.createInput(10,420);
    	for (int x : cake)
    	{
    		cack.insert(x);
    	}
    	
    	System.out.println("Run time");
     	
    	long time = System.nanoTime();
    	cack.remove();
		//AlgorithmLab.algorithm1(10);

		System.out.println((System.nanoTime()-time)/1000000000.0);
		
    	
    }

}
