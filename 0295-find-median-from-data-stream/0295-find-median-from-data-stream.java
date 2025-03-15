class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        

        
    }
    
    public void addNum(int num) {
        
        if(maxHeap.isEmpty() || maxHeap.peek()>num)
        {
            maxHeap.add(num);
            if(maxHeap.size()>minHeap.size()+1)
            {
                minHeap.add(maxHeap.remove());
            }
        }
        else{
            minHeap.add(num);
            if(minHeap.size()>maxHeap.size()+1)
            {
                maxHeap.add(minHeap.remove());
            }
        }

          
       

        
    }
    
    public double findMedian() {
        if(minHeap.size()==maxHeap.size())
        {
            double a=maxHeap.peek()+minHeap.peek();
            return a/2.0;
        }
        else if(minHeap.size()>maxHeap.size())return minHeap.peek();
        else return maxHeap.peek();
       
        
        
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */