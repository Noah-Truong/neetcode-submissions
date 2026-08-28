
class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    int items;
    public MedianFinder() {
       right = new PriorityQueue<>();
       left = new PriorityQueue<>(Collections.reverseOrder());
       items = 0;
    }
    
    public void addNum(Integer num) {
        if (items == 0) {
            left.add(num);
            items++;
        } else {
            int l = left.peek();
            
            if (num <= l) {
                left.add(num);
            } else {
                right.add(num);
            }
            items++;
        }
        
        if (left.size() - right.size() == 2) {
            right.add(left.poll());
        }
        if (right.size() - left.size() == 1) {
            left.add(right.poll());
        }
    }
    
    public double findMedian() {
        if (items % 2 == 1) {
            return left.peek();
        } else {
            return (((double) right.peek() + (double) left.peek()) / 2);
        }
    }
}
